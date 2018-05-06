/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitulo14ejercicios;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Ejercicio06 extends JFrame{
    String c = "";
    int x;
    int y;

     
    public static void main(String args[]){
        JFrame frame = new Ejercicio06();
        frame.setSize(600,600);
        frame.setTitle("Ejercicio - 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);       
        
    }
    
    Ejercicio06(){
        addMouseMotionListener(new MouseMotionAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent e){
                x = e.getX();
                y = e.getY();
                System.out.println("Updated position ("+x+""+y+")");
            }
        });
        
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent ke) {
                c = String.valueOf(ke.getKeyChar());
                
                x = (int)getMousePosition().getX();
                y = (int)getMousePosition().getY();
                getGraphics().drawString(c, x, y);
                System.out.println(c);
            } 
        });
    }
    
     
     
}
