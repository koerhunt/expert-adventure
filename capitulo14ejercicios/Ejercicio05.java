/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitulo14ejercicios;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class Ejercicio05 extends JFrame {
        
    String cadena = "";
    Ejercicio05(){
        JPanel p = new Ejercicio05Panel();        
        p.setFocusable(true);
        add(p);
    }
    
    public static void main(String args[]){
        JFrame frame = new Ejercicio05();
        frame.setSize(600,600);
        frame.setTitle("Ejercicio - 5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);       
    }
    
    private class Ejercicio05Panel extends JPanel{

        
        Ejercicio05Panel(){
            addKeyListener(new PressedListener());
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
            grphcs.drawString(cadena,getWidth()/2-100, getHeight()/2);
        }
        
        private class PressedListener extends KeyAdapter{

            PressedListener(){
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyChar()==KeyEvent.VK_ENTER){
                    cadena = "";
                    repaint();
                }else{
                    cadena += ke.getKeyChar();
                    repaint();
                }
                System.out.println(cadena);

            }
        }
    }
    
    
}
