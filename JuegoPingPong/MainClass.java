/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPingPong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author shikami
 */
public class MainClass extends JFrame{
    
    Timer gameclock;
    
    MainClass(){
        setSize(400, 650);
        setTitle("PingPong");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();        
        add(panel);
        panel.setFocusable(true);
        setVisible(true);
    }
    
    public static void main(String args[]){
        
        MainClass Game = new MainClass();
        
    }
    
    
    class GamePanel extends JPanel{
        
        Racket r; //raqueta
        Ball p; //pelota
        
        boolean prepared;
        
        public GamePanel(){
            super();
        }

        @Override
        protected void paintComponent(Graphics grphcs) {            
            super.paintComponent(grphcs);
            
            if(!prepared){
                prepare();
            }
            
            if(r!=null){
                r.draw(grphcs);
//                r.drawRect(grphcs);
            }
            
            if(p!=null){                 
                p.draw(grphcs);
//                p.drawRect(grphcs);


//                
//                for(int x=0; x<=getWidth();x+=1){
//                    grphcs.setColor(Color.black);
//                    int y = (int) (p.getMd()*x -  p.getMd()*p.getX1() + p.getY1());
//                    grphcs.drawLine(x+p.getRadio()/2,y+p.getRadio()/2,x+p.getRadio()/2,y+p.getRadio()/2);
//                }
            }
            
            
        }

        
        //Inicializacion de elementos del juego
        private void prepare() {
            
            //raqueta
            r = new Racket((getWidth()/2)-50,(getHeight())-80,100,20);
            r.setWcontainer(getWidth());
            
            //pelota
            int diametro = 25;
            p = new Ball(
                getWidth()/2-(diametro/2), 
                getHeight()/2-(diametro/2), 
                diametro,
                Color.red,
                getWidth(), 
                getHeight()
            );
                
            //agregar escucha del teclado
            addKeyListener(new KeyboardListener());
            
            //agregar timer de la pelota
            gameclock = new Timer(10,new BounceBallListener());
            gameclock.start();

            prepared = true;
        }
        
        //mover pelota
        private void moveBall(){
                
                if(p.getRect().intersects(r.getRect())){
                    System.out.println("rebota en raqueta");
                    p.setY(r.getY()-p.getRadio());
                    p.bounceOnRacket();
                }
                
                //limite superior
                if(p.getY()<=0){
                    System.out.println("tope arriba");
                    p.setY(1);
                    p.vertical = false;
                    p.changeToRandomDirection();
                }
                
                //limite izquierdo
                if(p.getX()<=0){
                    System.out.println("tope izquierda");   
                    p.changeToRandomDirection();
                }

                //limite derecho
                if( (p.getX()+p.getRadio()) >= getWidth() ){
                    System.out.println("tope derecho");
                    p.changeToRandomDirection();
                }
                
                if(p.getY()+p.getRadio()>=(getHeight())){
                    JOptionPane.showMessageDialog(null, "Juego Terminado, has perdido");
                    gameclock.stop();
                }
                
                p.move();
                
                repaint();
        }
        
        //Escucha de las flechas
        class KeyboardListener extends KeyAdapter{
        
            @Override
            public void keyPressed(KeyEvent ev){
                if(ev.getKeyCode()==KeyEvent.VK_LEFT){
                    r.moveLeft();
                    repaint();
                }else{
                    if(ev.getKeyCode()==KeyEvent.VK_RIGHT){
                        r.moveRigth();
                        repaint();
                    }else{
                        moveBall();
                    }
                }
            }

        }

        //Escucha de animacion de pelota
        class BounceBallListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                moveBall();
            }
        }
    }
}
