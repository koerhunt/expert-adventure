/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitulo14ejercicios;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class Ejercicio07 extends JFrame {
    
        public static void main(String args[]){
            JFrame frame = new Ejercicio07();
            frame.setSize(600,600);
            frame.setTitle("Ejercicio - 6");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        
        Ejercicio07(){
            DrawingPoint d = new DrawingPoint();
            d.setFocusable(true);
            add(d);
            System.out.println(getWidth());
            System.out.println(getHeight());
            
        }
        
        class DrawingPoint extends JPanel{
            int x;
            int y;
            
            DrawingPoint() {
            this.x = super.getWidth()/2;
            this.y = super.getHeight()/2;
            addKeyListener(new KeyAdapter(){
                
                @Override
                public void keyPressed(KeyEvent e){
                    System.out.println("drawing");
                    switch(e.getKeyCode()){
                        case KeyEvent.VK_UP:
                            y-=1;
                            break;
                        case KeyEvent.VK_RIGHT:
                            x+=1;
                            break;
                        case KeyEvent.VK_DOWN:
                            y+=1;
                            break;
                        case KeyEvent.VK_LEFT:
                            x-=1;
                            break;   
                    }
                    System.out.println("x:"+x+" y:"+y);
                    repaint();
                }
            });
            }
            
            @Override
            public void paintComponent(Graphics g) {
                g.drawLine(x, y, x, y);
            }
            
        
        
    
        }
        
        
}
