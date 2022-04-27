package System;

import java.io.Serializable;
public class Seccion implements Serializable{
    private int x, y;
    private boolean funcional;
    
    public Seccion(int x, int y){
        this.x=x;
        this.y=y;
        this.funcional=true;
    }

    public void noFunciona(){
        funcional=false;
    }

    public boolean getFuncional(){
        return this.funcional;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
