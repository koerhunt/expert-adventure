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
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class Ejercicio04 extends JFrame{
    
    public static void main(String args[]){
        JFrame frame = new Ejercicio04();
        frame.setSize(600,600);
        frame.setTitle("Ejercicio - 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
    }
    
    Ejercicio04(){
        add(new AlternateString());
    }
    
    private class AlternateString extends JPanel{
        private String s =  "Java is fun";
        private int toggle = 0;
        
        AlternateString(){
            addMouseListener(new ToggleListener());
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(s,getWidth()/2-100, getHeight()/2);
        }
        
        class ToggleListener extends MouseAdapter{

            @Override
            public void mouseClicked(MouseEvent ae) {
                System.out.println("action performed");
                if(toggle==0){
                    toggle=1;
                    s = "Java is fun";
                    repaint();
                }else{
                    toggle=0;
                    s = "Java is powerful";
                    repaint();
                }
            }
            
        }
    }    
    
    
}
