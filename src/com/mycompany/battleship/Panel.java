/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.battleship;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author avalo
 */
public class Panel extends JPanel{
    ImageIcon imagen;
    String nombre;
    
    public Panel(String nombre){
        this.nombre=nombre;
    }
    
    public void paint(Graphics g){
        Dimension tamanio=getSize();
        imagen=new ImageIcon(getClass().getResource(nombre));
        g.drawImage(imagen.getImage(),0,0,tamanio.width,tamanio.height,null);
        setOpaque(false);
        super.paint(g);
    }
}
