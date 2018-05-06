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
public class AlejarseDelObjeto  extends JFrame{
    
    Persona p;
    
    public AlejarseDelObjeto(){
        setSize(400, 650);
        setTitle("Perspectiva");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel panel = new Panel();
        add(panel);
        panel.setFocusable(true);
        setVisible(true);
    }
    
    public static void main(String args[]){
        AlejarseDelObjeto a = new AlejarseDelObjeto();
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

            grphcs.drawLine(0, 2*getHeight()/3, 7*getWidth()/16, 0);
            grphcs.drawLine(getWidth(), 2*getHeight()/3, 9*getWidth()/16, 0);
            
             
            if(p==null){
                p = new Persona(getWidth()/2,getHeight()/2);
            }
            p.draw(grphcs);
            
            
            
        }
        
        class KeyboardListener extends KeyAdapter{
            
            @Override
            public void keyPressed(KeyEvent ev){
                switch(ev.getKeyCode()){
                    case KeyEvent.VK_DOWN:
                        p.alejar();
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        p.acercar();
                        repaint();
                        break;
                }
            }
            
            
        }
        
    }
    
}

//kwin_x11
