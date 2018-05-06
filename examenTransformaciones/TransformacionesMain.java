/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenTransformaciones;

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
    
    public static void main(String args[]){
        TransformacionesMain p = new TransformacionesMain();
    }
    
    class Panel extends JPanel{
        
        Panel(){
        }
        
        @Override
        protected void paintComponent(Graphics grphcs) {            
            super.paintComponent(grphcs);
            
           CustomPolygon cp = new CustomPolygon();
           cp.draw(grphcs);
           
           cp.rotate(90); 
           cp.translate(200,0);
            
           grphcs.setColor(Color.red);
           cp.draw(grphcs);
           
           cp = new CustomPolygon();
           cp.translate(200, 0);
           
           grphcs.setColor(Color.orange);
           cp.draw(grphcs);
            
            
        }
        
    }
}


//Abanico de ventilador