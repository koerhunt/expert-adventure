/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioTransformaciones;

import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author shikami
 * 
 */

public class TransformacionesMain2 extends JFrame{
    
    Timer t;
    int alpha;
    int ox, oy;
    boolean tick;
    
    TransformacionesMain2(){
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
        TransformacionesMain2 p = new TransformacionesMain2();
    }
    
    class Panel extends JPanel{
        
        int x1[];
        int x2[];
        
        int alpha;
        CustomFillArc aspas[];
        
        Panel(){
            aspas = new CustomFillArc[4];
        }
        
        @Override
        protected void paintComponent(Graphics grphcs) {  
            super.paintComponent(grphcs);
            
            if(t==null){
                t = new Timer(1000,(ae) -> {
                    if(tick){
                        System.out.println("tack");
                        tick=false;
                    }else{
                        System.out.println("tick");
                        tick=true;
                    }
                    repaint();
                });
                t.start();
            }
            
            ox = getWidth()/2;
            oy = getHeight()/2;
            
            //Creacion de las 4 aspas
            aspas[0] = new CustomFillArc(ox,oy,100,0);
            aspas[1] = new CustomFillArc(ox,oy,100,90);
            aspas[2] = new CustomFillArc(ox,oy,100,180);
            aspas[3] = new CustomFillArc(ox,oy,100,270);
            
            
            for (CustomFillArc aspa : aspas) {
                //Rotacion sobre si mismo
                aspa.translate(-ox, -oy);
                aspa.rotate(alpha);
                aspa.translate(ox, oy);
                
                //dibuja
                aspa.draw(grphcs);
            }
            
            //incrementa el angulo de rotacion
            
            alpha+=30;
        }
        
        
    }
}