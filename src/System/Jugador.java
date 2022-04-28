package System;

import GUI.DateUtils;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Jugador{
    private String id;
    private String nombre;
    private Date fechaNacimiento;
    private int edad;
    private int intentos;
    private int barcosHundidos;

    public Jugador(String nombre, Date fecha){
        this.nombre=nombre;
        this.fechaNacimiento=fecha;
        edad=calcularEdad(fecha);
        intentos=10;
        barcosHundidos=0;
    }
    
    /*Calcula la edad de un jugador dada su fecha de nacimiento*/
    public int calcularEdad(Date fecha){
        Period periodo = Period.between(DateUtils.asLocalDate(fecha), LocalDate.now());
        return periodo.getYears();
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    public void setId(String id){
        this.id=id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public int getEdad(){
        return edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setIntentos(int intentos){
        this.intentos=intentos;
    }
    
    public int getIntentos(){
        return intentos;
    }
    
    public void setBarcosHundidos(int barcosHundidos){
        this.barcosHundidos=barcosHundidos;
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