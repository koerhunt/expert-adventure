/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitulo14ejercicios;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author shikami
 */
public class Ejercicio02 extends JFrame {
    
    
    Ejercicio02(){
        addMouseListener(new MouseAdapter() {            
            @Override
            public void mouseReleased(MouseEvent e){
                repaint();
            }
            
            @Override     
            public void mousePressed(MouseEvent e){
                Graphics g = getGraphics();
                g.drawString("("+e.getX()+","+e.getY()+")", e.getX(), e.getY());
            }
        });     
    }
    
    public static void main(String args[]){
        
        JFrame frame = new Ejercicio02();
        
        frame.setSize(600,600);
        frame.setTitle("Ejercicio - 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
}
