/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea03;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author shikami
 */

public class Reloj extends JFrame{
    
    
    Reloj(){
        setSize(600, 600);
        setTitle("Ejercicio del circulo");
        setLocationRelativeTo(null);
        RelojContainer rc = new RelojContainer();
        add(rc);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String args[]){
        Reloj r = new Reloj();
    }
    
    class RelojContainer extends JPanel{
        int xCenter;
        int yCenter;
        
        int xOrigin;
        int yOrigin;        
        
        int diametro;
                
        RelojContainer(){
            Timer t = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    repaint();
                }
            });
            t.start();
        }
                
        void setCurrentTime(){
            repaint();
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //Pintar circulo
            
            //Ver el lado mas chico y establecer el radio en base a una proporcion
            if(getWidth()>getHeight()){
                diametro = (int)(getHeight()*0.9);
            }else{
                diametro = (int)(getWidth()*0.9);
            }
            
            //encontrar el centro del frame
            xCenter = getWidth()/2;
            yCenter = getHeight()/2;
            
            //Calcular el punto donde comenzar a pintar
            xOrigin = xCenter - diametro/2;
            yOrigin = yCenter - diametro/2;
            
            g.setColor(Color.black);
            g.drawOval(xOrigin, yOrigin, diametro, diametro);
            
            //establecer margen y pintar las horas principales
            int margen = (int)((diametro/2)*0.95);
            g.drawString("12", xCenter, yCenter-margen);
            g.drawString("3", xCenter+margen, yCenter);
            g.drawString("6", xCenter, yCenter+margen);
            g.drawString("9", xCenter-margen, yCenter);
                
            Calendar calendar = new GregorianCalendar();            
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            
            System.out.println(hour+":"+minute+":"+second);
            
            //Dibujar manecilla de segundos
            g.setColor(Color.black);
            
            //tamanio de la manecilla
            int seg_d = (int)((diametro/2)*0.9);
            
            //Calcular punto de la hora
            int XsegPoint,YsegPoint;            
            XsegPoint = (int)(xCenter + seg_d * Math.sin(second * (2 * Math.PI / 60)));
            YsegPoint = (int)(yCenter - seg_d * Math.cos(second * (2 * Math.PI / 60)));

            
            System.out.println(XsegPoint);
            System.out.println(YsegPoint);
            
            g.drawLine(xCenter, yCenter, XsegPoint, YsegPoint);
            
            //Dibujar manecilla de minutos
            g.setColor(Color.green);
            int min_d = (int)((diametro/2)*.7);
            
            XsegPoint = (int)(xCenter + min_d * Math.sin(minute * (2 * Math.PI / 60)));
            YsegPoint = (int)(yCenter - min_d * Math.cos(minute * (2 * Math.PI / 60)));
            g.drawLine(xCenter, yCenter, XsegPoint, YsegPoint);
            
            //Dibujar manecilla de horas
            g.setColor(Color.red);
            int hrs_d = (int)((diametro/2)*.4);
            XsegPoint = (int)(xCenter + hrs_d * Math.sin(hour * (2 * Math.PI / 12)));
            YsegPoint = (int)(yCenter - hrs_d * Math.cos(hour * (2 * Math.PI / 12)));
            g.drawLine(xCenter, yCenter, XsegPoint, YsegPoint);
            
        }
        
    }
    
}
