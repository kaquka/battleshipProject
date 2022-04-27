package System;

import java.io.Serializable;
public class Barco implements Serializable{
    private boolean hundido;
    private Seccion SeccionDeBarco[];

    public Barco(Seccion seccionesDeBarco[]){
        this.hundido = false;
        this.SeccionDeBarco = seccionesDeBarco;
    }

    public boolean isHundido(){
        return hundido;
    }

    /*Editado por: Angel
        Esta funcion regresa la i-ésima sección del barco */
    public Seccion getSeccion(int i) {
        return SeccionDeBarco[i];//OJITO: solo hay 3 secciones, verificar si es necesario poner restriccion
    }

    public int getLenghtSecciones(){
        return SeccionDeBarco.length;
    }

    private void hundirse(){
        this.hundido=verificaSecciones();
    }

    /*Editado por: Angel
        Esta funcion verifica la funcionalidad de las secciones del barco */
    private boolean verificaSecciones(){
        for(int i=0;i<SeccionDeBarco.length;i++){
            if(SeccionDeBarco[i].getFuncional()){
                return false;
            }      
        }
        return true;
    }

    public void hit(int y){
        int i;

        for(i=0; i<getLenghtSecciones(); i++){
            if(y==SeccionDeBarco[i].getY()){
                SeccionDeBarco[i].noFunciona();
                break;
            }
        }

        hundirse();
    }
}