package System;

import java.lang.String;

public class Jugador{
    private String nombre;
    private String fechaNacimiento;
    private int intentos;
    private int barcosHundidos;

    public Jugador(String nombre, int anio, int  mes, int dia){
        this.nombre=String.valueOf(nombre);
        fechaNacimiento=anio+"/"+mes+"/"+dia;
        intentos=10;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setFechaNacimiento(int anio, int  mes, int dia){
        fechaNacimiento=anio+"/"+mes+"/"+dia;
    }

    public String getFechaNacimiento(){
        return fechaNacimiento;
    }

    public int getIntentos(){
        return intentos;
    }

    public int getBarcosHundidos(){
        return barcosHundidos;
    }

    public void aumentaIntentos(){
        intentos++;
    }

    public void restaIntentos(){
        intentos--;
    }

    public void aumentaBarcosHundidos(){
        barcosHundidos++;
    }

}