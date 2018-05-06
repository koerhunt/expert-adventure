/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones;

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
            
            LetterA l = new LetterA(200,200);
            l.draw(grphcs);
            
            l.scale(4, 4);
            l.draw(grphcs);
            
            l.rotate(-180);
            l.draw(grphcs);
            
            l.translate(50, 0);
            l.draw(grphcs);
        }
        
    }
}


//Abanico de ventilador