/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class ExamenMatriz extends JFrame{
        
    public CustomPanel panel;
    public ExamenMatriz form;
      //constructor
    ExamenMatriz(){
        panel = new CustomPanel();
        form = this;
        add(panel);
        
    }
    
    public static void main(String args[]){
        JFrame frame = new ExamenMatriz();
        frame.setSize(800,600);
        frame.setTitle("Examen 2 - Graficacion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }    
    
    class CustomPanel extends JPanel{
        
        CustomPanel(){
        }
        
        @Override
        public void paintComponent(Graphics g) {
            
            int height = (int)(getHeight()/3);
            int width = (int)(getWidth()/2);
            
            System.out.println(height);
            System.out.println(width);
            
            int medida;
            medida = Math.min(width, height);
            
            //fila 1
            g.drawOval(0, 0, medida, medida);
            g.drawOval(medida, 0, medida, medida);
            
            //fila 2
            g.drawOval(0, medida, medida, medida);
            g.drawOval(medida, medida, medida, medida);
            
            //fila 3
            g.drawOval(0, 2*medida, medida, medida);
            g.drawOval(medida, 2*medida, medida, medida);            
            
            
        }
        
//        int height = (int)(getHeight()/3);
//            int width = (int)(getWidth()/2);
//            
//            g.drawOval(0, 0, width, height);
//            g.drawOval(width, 0, width, height);
//            
//            g.drawOval(0, height, width, height);
//            g.drawOval(width, height, width, height);
//            
//            g.drawOval(0, 2*height, width, height);
//            g.drawOval(width, 2*height, width, height);
    }
        
}
