package System;

import java.io.Serializable;

public class Tablero implements Serializable{
    //private int partidaTablero[][] = new int [10][10];
    private static int longitud=10;
    private int tablero[][] = new int [longitud][longitud];
    private Barco barco[]=new Barco[longitud];

    public Tablero(){}
    
    public Tablero(Barco barco[]){
        limpiaTablero(this.tablero);
        this.barco=barco;
        asignaBarcos(barco);
    }

    public Tablero(int tab[][],Barco barcos[]){
        this.tablero=tab;
        this.barco=barcos;//no sabemos si esto es legal, asignacion entre arrays
    }
    
    public int getCasillaTablero(int x, int y){
        return this.tablero[x][y]; 
    }

    /*  Editado por: Azarel Pazos
        El método checarCasilla verifica si hay un barco o parte de este
        en la posición x e y, que son variables pasadas por parámetro.
        Se retornará 1 en el caso de que el jugador haya seleccionado
        una casilla que no haya seleccionado anteriormente y por ende se
        debe actualizar el tablero*/
    public int checarCasilla(int x, int y, Jugador jugador){
        int iBarco=this.tablero[x][y];
        
        if(iBarco==-1){
            jugador.restaIntentos();
            this.tablero[x][y]=longitud;
            return 2;
        }else{
            if(iBarco>=0 && iBarco<=(longitud-1)){
                this.barco[iBarco].hit(y);
                if(this.barco[iBarco].isHundido()){
                    jugador.aumentaBarcosHundidos();
                    jugador.aumentaIntentos();
                }
                this.tablero[x][y]=longitud;
                return 1;
            }
            return 0;
        }
    }
   

    /*  Editado por: Azarel Pazos
        Inicializa el tablero en -1, el cual indica que no hay nada en las casillas (no hay barcos)*/
    private void limpiaTablero(int tablero[][]){
        int i, j;

        for(i=0; i<longitud; i++){
            for(j=0; j<longitud; j++)
                tablero[i][j]=-1;
        }

    }
    
    /*  Editado por: Azarel Pazos
        Asigna barcos al tablero*/
    private void asignaBarcos(Barco barco[]){
        int i, j, secciones=barco[0].getLenghtSecciones();
        Seccion SeccAux;

        for(i=0; i<longitud; i++)
            for(j=0; j<secciones; j++){
                SeccAux=barco[i].getSeccion(j); // toma la seccion j-ésima del barco i-ésimo
                tablero[SeccAux.getX()][SeccAux.getY()]=i;  // coloca en el tablero la sección j-ésima del barco i-ésimo (en esas posiciones del tablero se coloca el índice del barco)
            }
    }
}