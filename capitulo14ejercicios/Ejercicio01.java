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


//source
//
public class Ejercicio01 extends JFrame{
    
    Ejercicio01(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                Graphics g = getGraphics();
                g.drawString("("+e.getX()+","+e.getY()+")", e.getX(), e.getY());
            }
        });
    }
    
    public static void main(String args[]){
        
        JFrame frame = new Ejercicio01();
        
        frame.setSize(600,600);
        frame.setTitle("Ejercicio - 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    
}
