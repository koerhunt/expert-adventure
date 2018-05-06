/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

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
public class PelotaRebotandoPorLaPantalla extends JFrame {
    
    Ball pelota;
    
    PelotaRebotandoPorLaPantalla(){
        setSize(600, 600);
        setTitle("Pelota Rebotando");
        
        //creacion de la pelota
        pelota = new Ball(
                getWidth()/2-40, 
                getHeight()/2-40, 
                80,
                Color.black,
                getWidth(), 
                getHeight()
        );
        
        pelota.changeToRandomDirection();
        
        Panel rc = new Panel();
        add(rc);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setVisible(true);
        
        Timer t = new Timer(33,new BounceBallListener());
        t.start();
        
    }

    public static void main(String args[]){
        JFrame frame = new PelotaRebotandoPorLaPantalla();
    }
    
    public void moveBall(){
        pelota.move();
        //limite superior
        if(pelota.getY()<=0){
            System.out.println("tope arriba");
            pelota.setY(2);
            pelota.changeToRandomDirection();
        }
        //limite izquierdo
        if(pelota.getX()<=0){
            System.out.println("tope izquierda");   
            pelota.horizontal = !pelota.horizontal;
            pelota.setX(2);
            pelota.changeToRandomDirection();
        }
        //limite inferior
        if(pelota.getY()>=(getHeight()-100)){
            System.out.println("tope abajo");
            pelota.setY(getHeight()-101);
            pelota.changeToRandomDirection();
        }
        
        //limite derecho
        if(pelota.getX()>(getWidth()-80)){
            System.out.println("tope derecho");
            pelota.horizontal = !pelota.horizontal;
            pelota.setX(getWidth()-pelota.getRadio());
            pelota.changeToRandomDirection();
        }
        repaint();    
    }
    
    class Panel extends JPanel{
        
        Panel(){
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            pelota.draw(g);   
            g.setColor(Color.blue);
            
            g.drawRect(pelota.getX(), pelota.getY(), pelota.getRadio(), pelota.getRadio());
            
            // y = mx - mx1 + y1
            for(int x=0; x<=getWidth();x++){
                int y = (int) (pelota.getMd()*x -  pelota.getMd()*pelota.getX1() + pelota.getY1());
                g.drawLine(x,y,x,y);
            }
        } 
    }
    
    class BounceBallListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            moveBall();
        }
    }
    
}


///HACER UN PING PONG CON ESTOOOOOOOO DDDDDDD:
///x'D'
///Yeah >:v
