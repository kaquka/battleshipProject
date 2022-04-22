package System;

import java.io.Serializable;

public class Tablero implements Serializable{
    private int partidaTablero[][] = new int [10][10];
    private int tablero[][] = new int [10][10];
    private Barco barco[]=new Barco[10];

    public Tablero(){}
    
    public Tablero(Barco barco[]){
        limpiaTablero(partidaTablero);
        limpiaTablero(tablero);
        this.barco=barco;
        asignaBarcos(barco);
    }

    public Tablero(int tab[][],Barco barcos[]){
        limpiaTablero(partidaTablero);
        this.tablero=tab;
        this.barco=barcos;//no sabemos si esto es legal, asignacion entre arrays
    }

    /*  Editado por: Azarel Pazos
        El método actualizarTablero se encarga de actualizar el tablero dado las coordenadas
        que haya seleccionado el jugador.
        En este métododo se imprime el tablero en caso de ser necesario, si el jugador
        selecciona una casilla que ya haya seleccionado anteriormente no se imprimirá
        el tablero, en su lugra se mostrará un mensaje que indica que ya ha seleccionado esa
        casilla
        */
    public boolean actualizarTablero(int x, int y, Jugador jugador){
        if(jugador.getBarcosHundidos()<10 && jugador.getIntentos()>0){
            if(checarCasilla(x, y)){
                imprimirTablero(partidaTablero);
                if(partidaTablero[x][y]==1){ // le dió a un barco
                    if(barco[tablero[x][y]].isHundido()){
                        System.out.println("Has hundido un barco!!!");
                        jugador.aumentaBarcosHundidos();
                        jugador.aumentaIntentos();
                    }else{
                        System.out.println("Le has dado a un barco!!!");
                    }
                }else{ 
                    System.out.println("No hay algún barco en esa zona!!!");
                    jugador.restaIntentos();
                }
            }else
                System.out.println("Ya ha seleccionado esa casilla anteriormente!!!");
            return true;
        }
        return false;
    }

    /*  Editado por: Azarel Pazos
        El método checarCasilla verifica si hay un barco o parte de este
        en la posición x e y, que son variables pasadas por parámetro.
        Se retornará 1 en el caso de que el jugador haya seleccionado
        una casilla que no haya seleccionado anteriormente y por ende se
        debe actualizar el tablero*/
    private boolean checarCasilla(int x, int y){
        int iBarco=tablero[x][y];

        if(partidaTablero[x][y]==-1){//significa que en la coordenada seleccionada no ha sido seleccionada anteriormente
            if(iBarco!=-1){ //le dió a una parte del barco
                this.barco[iBarco].hit(x,y);
                partidaTablero[x][y]=1; // 1 indica que el jugador le dió a un barco
            }else
                partidaTablero[x][y]=2; // 2 indica que no le dió a nada
            return true;
        }

        return false;
    }
    
    /*  Editado por: Angel
        Esta funcion va a imprimir una matriz en forma de tablero */
    public void imprimirTablero(int a[][]){


        for (int x=0; x < a.length; x++) {
            
            for (int y=0; y < a[x].length; y++) {
                System.out.print ("["+a[x][y]+"]");
                if (y!=a[x].length-1) System.out.print("\t");
            }
            System.out.println("\n");
        }
    }

    public void imprimeTableroPartida(){
        imprimirTablero(partidaTablero);
        System.out.println("Tablero\n");
        imprimirTablero(tablero);
    }

    /*  Editado por: Azarel Pazos
        Inicializa el tablero en -1, el cual indica que no hay nada en las casillas (no hay barcos)*/
    private void limpiaTablero(int tablero[][]){
        int i, j, longRen=tablero.length, longCol=tablero[0].length;

        for(i=0; i<longRen; i++){
            for(j=0; j<longCol; j++)
                tablero[i][j]=-1;
        }

    }
    
    /*  Editado por: Azarel Pazos
        Asigna barcos al tablero*/
    private void asignaBarcos(Barco barco[]){
        int i, j, longitud=barco.length, secciones=barco[0].getLenghtSecciones();
        Seccion SeccAux;

        for(i=0; i<longitud; i++)
            for(j=0; j<secciones; j++){
                SeccAux=barco[i].getSeccion(j); // toma la seccion j-ésima del barco i-ésimo
                tablero[SeccAux.getCoordenadaX()][SeccAux.getCoordenadaY()]=i;  // coloca en el tablero la sección j-ésima del barco i-ésimo (en esas posiciones del tablero se coloca el índice del barco)
            }
    }
}