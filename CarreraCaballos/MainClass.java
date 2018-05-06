/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarreraCaballos;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    
    ArrayList<Caballo> caballos;
    
    MainClass(){
        setSize(650, 450);
        setTitle("Carrera de caballos");
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
            
            //Dibujar caballos
            if(!caballos.isEmpty()){
                caballos.forEach((c) -> {
                    c.setX(c.getX()+(int)(Math.random()*10));
                    c.draw(grphcs);  
                    System.out.println("moving");
                    if(c.getX()>=(getWidth()-50)){
                        gameclock.stop();
                        System.out.println("Carrera terminada");
                    }
                });
            }  
                        
        }

        
        //Inicializacion de elementos del juego
        private void prepare() {
            
            //Preparar memoria para los misiles
            caballos = new ArrayList<>();
            
            //Crear enemigos
            for(int i=0;i<5;i++){
                caballos.add(new Caballo(
                        50, 
                        (getHeight()/5) * (i) + 20,50, 50));
            }
                
            
            //agregar timer de la pelota
            gameclock = new Timer(60,new GameClockTimer());
            gameclock.start();

            prepared = true;
            
            
        }
        
        //update Graphics
        private void updateGraphics(){ 
            repaint();
        }
        
        //Update Rate
        class GameClockTimer implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateGraphics();
            }
        }
        
        
    }
}

