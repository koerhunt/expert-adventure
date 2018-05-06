/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author shikami
 */
public class Pelota extends JFrame {
    
    Pelota(){
        setSize(600, 600);
        setTitle("Ejercicio del circulo");
        setLocationRelativeTo(null);
        PelotaPanel rc = new PelotaPanel();
        add(rc);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String args[]){
        Pelota p = new Pelota();
    }
    
    
    class PelotaPanel extends JPanel{
        
        int pelotax;
        int pelotay;
        
        int diametro = 25;
        
        int limrebote;
        boolean subiendo;
        
        
        
        PelotaPanel(){                       
            pelotax = 300;
            pelotay = 0;
            limrebote = getHeight()/2;
            Timer t = new Timer(20,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    repaint();
                }
            });
            t.start();
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
             if(subiendo){
                        pelotay-=10;//getHeight()/30;
                        if(pelotay<=0){
                            subiendo=false;
                        }
                    }else{
                        pelotay+=10;//getHeight()/30;
                        if(pelotay>=(getHeight()-diametro)){
                            subiendo=true;
                        }
                    }
             
            g.setColor(Color.red);
            g.fillOval(pelotax, pelotay, diametro, diametro);
            
        }
        
        
        
    }
    
    
    
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tarea05;
//
//import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
///**
// *
// * @author shikami
// */
//public class Pelota extends JFrame {
//    
//    Pelota(){
//        setSize(600, 600);
//        setTitle("Ejercicio del circulo");
//        setLocationRelativeTo(null);
//        PelotaPanel rc = new PelotaPanel();
//        add(rc);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//    
//    public static void main(String args[]){
//        Pelota p = new Pelota();
//    }
//    
//    
//    class PelotaPanel extends JPanel{
//        
//        int pelotax;
//        int pelotay;
//        
//        int diametro = 25;
//        
//        int limrebote;
//        boolean subiendo;
//        
//        PelotaPanel(){   
//            pelotax = 300;
//            pelotay = 0;
//            limrebote = getHeight()/2;
//            Timer t = new Timer(20,new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent ae) {
//                    repaint();
//                }
//            });
//            t.start();
//        }
//        
//        @Override
//        public void paintComponent(Graphics g){
//            super.paintComponent(g);
//            
//             if(subiendo){
//                        pelotay-=10;//getHeight()/30;
//                        if(pelotay<=0){
//                            subiendo=false;
//                        }
//                    }else{
//                        pelotay+=10;//getHeight()/30;
//                        if(pelotay>=(getHeight()-diametro)){
//                            subiendo=true;
//                        }
//                    }
//             
//            g.setColor(Color.red);
//            g.fillOval(pelotax, pelotay, diametro, diametro);
//            
//        }
//        
//        
//        
//    }
//    
//    
//    
//}
