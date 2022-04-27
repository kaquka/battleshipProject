/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azare
 */
public class Archivo {
    
    public Archivo(){}
    
    public static void guardarArchivo(Tablero tablero){

        FileOutputStream archivo;
        try {
            archivo = new FileOutputStream("src/Files/Tablero1.dat");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(tablero);
            salida.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.err.println("Error al guardar el archivo");
        }
         
    }
    
    public static Tablero elegirArchivo(){
        Tablero recuperado = new Tablero();
        Random random = new Random();
        ArrayList<String> archivos = new ArrayList<>();
        archivos.add("src/Files/Tablero1.dat");
        archivos.add("src/Files/Tablero2.dat");
        archivos.add("src/Files/Tablero3.dat");
        archivos.add("src/Files/Tablero4.dat");
        archivos.add("src/Files/Tablero5.dat");
        int a = random.nextInt(5);
        FileInputStream archivo;
        try {
            archivo = new FileInputStream((String) archivos.get(a));
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            recuperado = (Tablero)entrada.readObject();
            entrada.close();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            System.err.println("Error al recuperar archivo");
        }        
        
        return recuperado;
    }
    
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
