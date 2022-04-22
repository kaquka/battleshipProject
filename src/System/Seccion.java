package System;

import java.io.Serializable;
public class Seccion implements Serializable{
    private int coordenadaX, coordenadaY;
    private boolean funcional;

    public Seccion(int x, int y){
        coordenadaX=x;
        coordenadaY=y;
        this.funcional=true;
    }

    public void noFunciona(){
        funcional=false;
    }

    public int getCoordenadaX(){
        return coordenadaX;
    }

    public int getCoordenadaY(){
        return coordenadaY;
    }

    public boolean getFuncional(){
        return this.funcional;
    }


}
