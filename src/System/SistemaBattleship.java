package System;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class SistemaBattleship{
    Scanner lee = new Scanner(System.in);

    public static void guardarArchivo(Tablero tablero){

        FileOutputStream archivo;
        try {
            archivo = new FileOutputStream("Tablero4.dat");
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
        archivos.add("Tablero1.dat");
        archivos.add("Tablero2.dat");
        archivos.add("Tablero3.dat");
        archivos.add("Tablero4.dat");
        archivos.add("Tablero5.dat");
        int a = random.nextInt(5);
        FileInputStream archivo2;
        try {
            archivo2 = new FileInputStream((String) archivos.get(a));
            ObjectInputStream entrada = new ObjectInputStream(archivo2);
            recuperado = (Tablero)entrada.readObject();
            entrada.close();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            System.err.println("Error al recuperar archivo");
        }        
        
        return recuperado;
    }

    public static Tablero elegirArchivo(String nombre){
        Tablero recuperado = new Tablero();
        FileInputStream archivo2;
        try {
            //archivo2 = new FileInputStream((String) archivos.get(a));
            archivo2 = new FileInputStream(nombre);
            ObjectInputStream entrada = new ObjectInputStream(archivo2);
            recuperado = (Tablero)entrada.readObject();
            entrada.close();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            System.err.println("Error al recuperar archivo");
        }        
        
        return recuperado;
    }

    private int menu(){
        int op;
        System.out.println("Menu:\n 1.-Otra partida\n 2.-Mostrar score particular\n 3.Mostrar score general\n 4.-salir\n Opcion:_");
        op=lee.nextInt();
        return op;
    }

    public static void main(String[] args)throws IOException, ClassNotFoundException{

        //Jugador Miguel = new Jugador("Miguel", 1995, 1,6);
        
       /* Seccion s1 = new Seccion(0,1);
        Seccion s2 = new Seccion(0,2);
        Seccion s3 = new Seccion(0,3);

        Seccion s4 = new Seccion(1,6);
        Seccion s5 = new Seccion(1,7);
        Seccion s6 = new Seccion(1,8);
        
        Seccion s7 = new Seccion(2,3);
        Seccion s8 = new Seccion(2,4);
        Seccion s9 = new Seccion(2,5);

        Seccion s10 = new Seccion(3,7);
        Seccion s11 = new Seccion(3,8);
        Seccion s12 = new Seccion(3,9);
        
        Seccion s13 = new Seccion(4,1);
        Seccion s14 = new Seccion(4,2);
        Seccion s15 = new Seccion(4,3);

        Seccion s16 = new Seccion(5,4);
        Seccion s17 = new Seccion(5,5);
        Seccion s18 = new Seccion(5,6);
        
        Seccion s19 = new Seccion(6,6);
        Seccion s20 = new Seccion(6,7);
        Seccion s21 = new Seccion(6,8);

        Seccion s22 = new Seccion(7,1);
        Seccion s23 = new Seccion(7,2);
        Seccion s24 = new Seccion(7,3);

        Seccion s25 = new Seccion(8,6);
        Seccion s26 = new Seccion(8,7);
        Seccion s27 = new Seccion(8,8);

        Seccion s28 = new Seccion(9,0);
        Seccion s29 = new Seccion(9,1);
        Seccion s30 = new Seccion(9,2);*/ //Aqui es mi parte

        /*Seccion s1 = new Seccion(0,3);
        Seccion s2 = new Seccion(0,4);
        Seccion s3 = new Seccion(0,5);

        Seccion s4 = new Seccion(1,0);
        Seccion s5 = new Seccion(1,1);
        Seccion s6 = new Seccion(1,2);
        
        Seccion s7 = new Seccion(2,7);
        Seccion s8 = new Seccion(2,8);
        Seccion s9 = new Seccion(2,9);

        Seccion s10 = new Seccion(3,2);
        Seccion s11 = new Seccion(3,3);
        Seccion s12 = new Seccion(3,4);
        
        Seccion s13 = new Seccion(4,6);
        Seccion s14 = new Seccion(4,7);
        Seccion s15 = new Seccion(4,8);

        Seccion s16 = new Seccion(5,0);
        Seccion s17 = new Seccion(5,1);
        Seccion s18 = new Seccion(5,2);
        
        Seccion s19 = new Seccion(6,4);
        Seccion s20 = new Seccion(6,5);
        Seccion s21 = new Seccion(6,6);

        Seccion s22 = new Seccion(7,1);
        Seccion s23 = new Seccion(7,2);
        Seccion s24 = new Seccion(7,3);

        Seccion s25 = new Seccion(8,6);
        Seccion s26 = new Seccion(8,7);
        Seccion s27 = new Seccion(8,8);

        Seccion s28 = new Seccion(9,7);
        Seccion s29 = new Seccion(9,8);
        Seccion s30 = new Seccion(9,9);

        Seccion secciones[]={s1,s2,s3};
        Seccion secciones1[]={s4,s5,s6};
        Seccion secciones2[]={s7,s8,s9};
        Seccion secciones3[]={s10,s11,s12};
        Seccion secciones4[]={s13,s14,s15};
        Seccion secciones5[]={s16,s17,s18};
        Seccion secciones6[]={s19,s20,s21};
        Seccion secciones7[]={s22,s23,s24};
        Seccion secciones8[]={s25,s26,s27};
        Seccion secciones9[]={s28,s29,s30};

        Barco b1 = new Barco(secciones);
        Barco b2 = new Barco(secciones1);
        Barco b3 = new Barco(secciones2);
        Barco b4 = new Barco(secciones3);
        Barco b5 = new Barco(secciones4);
        Barco b6 = new Barco(secciones5);
        Barco b7 = new Barco(secciones6);
        Barco b8 = new Barco(secciones7);
        Barco b9 = new Barco(secciones8);
        Barco b10 = new Barco(secciones9);

        Barco barcos[]={b1,b2,b3,b4,b5,b6,b7,b8,b9,b10};

        Tablero tablero = new Tablero (barcos);

        
        guardarArchivo(tablero);*/


        Tablero tablero1 = elegirArchivo();
        tablero1.imprimeTableroPartida();
        System.out.println();

        /*Tablero tablero2 = elegirArchivo("Tablero2.dat");
        System.out.println("Tablero 2\n");
        tablero2.imprimeTableroPartida();
        System.out.println();

        Tablero tablero3 = elegirArchivo("Tablero3.dat");
        System.out.println("Tablero 3\n");
        tablero3.imprimeTableroPartida();
        System.out.println();

        Tablero tablero4 = elegirArchivo("Tablero4.dat");
        System.out.println("Tablero 4\n");
        tablero4.imprimeTableroPartida();
        System.out.println();

        Tablero tablero5 = elegirArchivo("Tablero5.dat");
        System.out.println("Tablero 5\n");
        tablero5.imprimeTableroPartida();
        System.out.println();*/

        /*tablero.actualizarTablero(0, 1, Miguel);
        System.out.println();
        tablero.actualizarTablero(0, 2, Miguel);
        System.out.println();
        tablero.actualizarTablero(0, 3, Miguel);
        System.out.println();
        tablero.actualizarTablero(0, 7, Miguel);*/
    }
    
}