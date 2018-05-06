/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioTransformaciones;

import examenTransformaciones.*;
import java.awt.Color;
import transformaciones.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 * 
 */

public class TransformacionesMain extends JFrame{
    
    TransformacionesMain(){
        setSize(650, 450);
        setTitle("Transformaciones");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel panel = new Panel();        
        add(panel);
        panel.setFocusable(true);
        setVisible(true);
    }
    
//    public static void main(String args[]){
//        TransformacionesMain p = new TransformacionesMain();
//    }
    
    class Panel extends JPanel{
        
        Panel(){
        }
        
        @Override
        protected void paintComponent(Graphics grphcs) {            
           super.paintComponent(grphcs);
           
           //Definicion del poligono mediante sus puntos
           int ox, oy;
           ox = getWidth()/2;
           oy = getHeight()/2;
           
            int originalPolygon[][] = new int[][]{
                {50+ox,00+oy,1},
                {70+ox,30+oy,1},
                {60+ox,50+oy,1},
                {60+ox,70+oy,1},
                {40+ox,70+oy,1},
                {40+ox,50+oy,1},
                {30+ox,30+oy,1}
            };
           
            CustomPolygon cp;
            for(int i=0;i<360;i+=60){
                cp = new CustomPolygon(originalPolygon);
                cp.translate(-ox, -oy);
                cp.rotate(i);
                cp.translate(ox, oy);
                cp.draw(grphcs);
            }
           
           
        }
        
    }
}


//Abanico de ventilador