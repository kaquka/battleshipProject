/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 *
 * @author azare
 */
public class Archivo {
   
    /*Función que permite guardar en tablero en un archivo binario.
        No se utilza en el programa por que no se requiere.
        Para agregar el nombre con la ruta del archivo se debe modificar  esta función.*/
    public static void guardarArchivo(Tablero tablero){

        FileOutputStream archivo;
        try {
            archivo = new FileOutputStream("src/Files/Tablero5.dat");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(tablero);
            salida.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.err.println("Error al guardar el archivo");
        }
         
    }
    
    /*Función que regresa un Tablero de cinco al azar.
        Se utilza en el programa.
        Si se quiere agregar otro tablero se debe modificar la función.*/
    public static Tablero elegirArchivo(){
        Tablero recuperado = new Tablero();
        Random rnd = new Random();
        ArrayList<String> archivos = new ArrayList<>();
        FileInputStream archivo;
        int a;
        
        archivos.add("src/Files/Tablero1.dat");
        archivos.add("src/Files/Tablero2.dat");
        archivos.add("src/Files/Tablero3.dat");
        archivos.add("src/Files/Tablero4.dat");
        archivos.add("src/Files/Tablero5.dat");
        
        a=rnd.nextInt(5);
        try {
            archivo = new FileInputStream((String) archivos.get(a));
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            recuperado = (Tablero)entrada.readObject();
            entrada.close();
        } catch (Exception e1) {
            System.err.println(e1);
        }        
        
        return recuperado;
    }
    
    /*Funcion para obtener un Tablero dada una ruta
        No se utiliza como tal en el programa ya que es para hacer pruebas*/
    public static Tablero getArchivo(String ruta){
        Tablero recuperado = new Tablero();
        FileInputStream archivo;
        ObjectInputStream entrada;
        
        try {
            archivo = new FileInputStream(ruta);
            entrada = new ObjectInputStream(archivo);
            recuperado = (Tablero)entrada.readObject();
            entrada.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
        return recuperado;
    }
}
