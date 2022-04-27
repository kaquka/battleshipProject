package System;

import java.io.Serializable;

public class Barco implements Serializable{
    private boolean hundido;
    private Seccion SeccionDeBarco[];

    public Barco(Seccion seccionesDeBarco[]){
        this.hundido = false;
        this.SeccionDeBarco = seccionesDeBarco;
    }

    /*Función que retorna true en caso de que se haya hundido el barco*/
    public boolean isHundido(){
        return hundido;
    }

    /*Editado por: Angel
        Esta funcion regresa la i-ésima sección del barco */
    public Seccion getSeccion(int i) {
        return SeccionDeBarco[i];//OJITO: solo hay 3 secciones, verificar si es necesario poner restriccion
    }
    
    /*Funcion que regresa el número de secciones que tiene el barco, se podría decir que es su longitud*/
    public int getLenghtSecciones(){
        return SeccionDeBarco.length;
    }

    /*Asigna un correspondiente al atributo hundido cuando haya verificado el estado de sus secciones*/
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
    
    /*Función que marca con un hit/golpe a una sección del barco, por ende marca es a sección como no funcional*/
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