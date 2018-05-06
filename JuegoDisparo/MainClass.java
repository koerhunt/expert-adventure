/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDisparo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author shikami
 */
public class MainClass extends JFrame{
    
    Timer gameclock;    
    Racket player;
    
    ArrayList<Misil> misiles;
    ArrayList<Ball> enemigos;
    
    MainClass(){
        setSize(400, 650);
        setTitle("Disparos");
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
        
        boolean prepared;
        
        public GamePanel(){
            super();
        }

        @Override
        protected void paintComponent(Graphics grphcs) {            
            super.paintComponent(grphcs);
            
            //inicializar juego
            if(!prepared){
                prepare();
            }
            
            //Dibujar Jugador
            if(player!=null){
                player.draw(grphcs);
            }
            
            
            //Dibujar enemigos
            if(!enemigos.isEmpty()){
                enemigos.forEach((e) -> {
                    if(e.isNotDead()){
                        e.draw(grphcs);   
                    }
                });
            }  
            
            
            //dibujar y mover misiles
            if(!misiles.isEmpty()){
                misiles.forEach((m) -> {
                    if(m.isActive()){
                        m.move();
                        
                        if(!enemigos.isEmpty()){
                            enemigos.forEach((e) -> {
                                if(m.getRect().intersects(e.getRect())){
                                    e.setDead(true);
                                }
                            });
                        }  
                        
                        m.draw(grphcs);   
                    }
                });
            }  
            
        }

        
        //Inicializacion de elementos del juego
        private void prepare() {
            
            //Jugador Uno
            player = new Racket((getWidth()/2)-50,(getHeight())-80,100,20);
            player.setWcontainer(getWidth());
            
            //Preparar memoria para los misiles
            misiles = new ArrayList<>();
            
            //Preparar espacio para enemigos
            enemigos = new ArrayList<>();
            
            //Crear enemigos
            int diametro = 20;
            for(int i=0;i<5;i++){
                enemigos.add(new Ball(
                    i*getWidth()/5 + (getWidth()/5)/2, 
                    100-(diametro/2), 
                    diametro,
                    Color.GREEN,
                    getWidth(), 
                    getHeight()
                ));
            }
                
            //agregar escucha del teclado
            addKeyListener(new KeyboardListener());
            
            //agregar timer de la pelota
            gameclock = new Timer(10,new GameClockTimer());
            gameclock.start();

            prepared = true;
            
            
        }
        
        //update Graphics
        private void updateGraphics(){ 
            repaint();
        }
        
        private void shotMisil(){
            misiles.add(new Misil(player.getX()+player.getWidth()/2, player.getY()));
        }
        
        //Escucha del teclado
        class KeyboardListener extends KeyAdapter{
            @Override
            public void keyPressed(KeyEvent ev){
                if(ev.getKeyCode()==KeyEvent.VK_LEFT){
                    player.moveLeft();
                    repaint();
                }else{
                    if(ev.getKeyCode()==KeyEvent.VK_RIGHT){
                        player.moveRigth();
                        repaint();
                    }else{
                        if(ev.getKeyChar()==KeyEvent.VK_SPACE){
                            shotMisil();
                        }
                    }
                }
            }
        }//fin del escucha del teclado

        //Update Rate
        class GameClockTimer implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateGraphics();
            }
        }
        
        
    }
}

