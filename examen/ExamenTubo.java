/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ExamenTubo extends JFrame{
    
    //constructor
    ExamenTubo(){
        add(new CustomPanel());
    }
    
    public static void main(String args[]){
        JFrame frame = new ExamenTubo();
        frame.setSize(800,600);
        frame.setTitle("Examen 1 - Graficacion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    class CustomPanel extends JPanel{
        
        CustomPanel(){
            
        }
        
        @Override
        public void paintComponent(Graphics g) {
            
            drawCilindroBase(g);
            drawCilindroVistaFrente(g);
            drawCilindroVistaAbajo(g);
        }

        private void drawCilindroBase(Graphics g) {
            //Draw cilindro de frente
            
            int dimencion_base = 50;
            
            //Linea izquierda
            g.drawLine(100,175,100,400);
            
            //Linea derecha
            g.drawLine(250,175,250,400);
            
            //Linea curveada inferior
            g.drawArc(100, 375, 150, dimencion_base, 180, 180);
            
            //Linea curveada superior
//            g.drawArc(100, 150, 150, dimencion_base, 180, 180);
            g.drawArc(100, 150, 150, dimencion_base, 0, 180);
        }

        private void drawCilindroVistaFrente(Graphics g) {
             //Draw cilindro de frente
            
            int dimencion_base = 50;
            
            //Linea izquierda
            g.drawLine(305,175,300,400);
            
            //Linea derecha
            g.drawLine(440,175,450,400);
            
            //Linea curveada inferior
            //opcion 1
            g.drawArc(300, 375, 150, dimencion_base, 0, 360);
            
            //Linea curveada superior
            g.drawArc(305, 150, 135, dimencion_base, 0, 180);
            //g.fillOval(300, 375, 150, dimencion_base);
        }

        private void drawCilindroVistaAbajo(Graphics g) {
             //Draw cilindro de frente
            
            int dimencion_base = 50;
            
            //Linea izquierda
            g.drawLine(500,200,510,400);
            
            //Linea derecha
            g.drawLine(650,200,640,400);
            
            //Linea curveada superior
            g.drawArc(500, 175, 150, dimencion_base, 0, 180);
            g.drawArc(500, 175, 150, dimencion_base, 180, 180);
            
            //Linea curveada inferior
            g.drawArc(510, 375, 130, dimencion_base, 180, 180);
            
        }
        
    }
      
      
      
      
      
}
