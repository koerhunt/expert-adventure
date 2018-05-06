/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programasPerspectivas;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class AlejarseDelObjeto2  extends JFrame{
    
    Persona p;
    int x1;
    int x2;
    
    public AlejarseDelObjeto2(){
        setSize(400, 650);
        setTitle("Perspectiva2");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel panel = new Panel();
        add(panel);
        panel.setFocusable(true);
        setVisible(true);
    }
    
    public static void main(String args[]){
        AlejarseDelObjeto2 a = new AlejarseDelObjeto2();
    }
    
    class Panel extends JPanel{
        
        Panel(){
            addKeyListener(new KeyboardListener());
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);
            
            
//            grphcs.drawLine(getWidth()/8, 2*getHeight()/3, 7*getWidth()/16, getHeight()/6);
//            grphcs.drawLine(7*getWidth()/8, 2*getHeight()/3, 9*getWidth()/16, getHeight()/6);
 
            if(p==null){
                p = new Persona(getWidth()/2,getHeight()/2);
                x1 = 7*getWidth()/16;
                x2 = 9*getWidth()/16;
            }
            p.draw(grphcs);
            
            
            grphcs.drawLine(0, 2*getHeight()/3, x1, 0);
            grphcs.drawLine(getWidth(), 2*getHeight()/3, x2, 0);
            
            
            
        }
        
        class KeyboardListener extends KeyAdapter{
            
            @Override
            public void keyPressed(KeyEvent ev){
                switch(ev.getKeyCode()){
                    case KeyEvent.VK_DOWN:
                        x1+=10;
                        x2-=10;
                        p.alejar();
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        x1-=10;
                        x2+=10;
                        p.acercar();
                        repaint();
                        break;
                }
            }
            
            
        }
        
    }
    
}

//kwin_x11
