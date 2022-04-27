package System;

import java.io.Serializable;
public class Seccion extends PuntoXY implements Serializable{
    private boolean funcional;
 
    public Seccion(int x, int y){
        super(x,y);
        this.funcional=true;
    }

    public void noFunciona(){
        funcional=false;
    }

    public boolean getFuncional(){
        return this.funcional;
    }


}
