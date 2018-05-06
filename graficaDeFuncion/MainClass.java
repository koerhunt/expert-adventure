/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaDeFuncion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */

public class MainClass  extends JFrame{
    
    int escala_x = 10;
    int escala_y = 10;
    
    MainClass(){
        setSize(600, 600);
        setTitle("Graficar Funciones");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        PlanoCartesiano pc = new PlanoCartesiano();
        add(pc);
        
        setVisible(true);
        pc.setFocusable(true);
    }
    
    public static void main(String args[]){
        MainClass ProgramaGraficacion = new MainClass();           
    }
    
    public class PlanoCartesiano extends JPanel{
        
        int ox;
        int oy;
                
        PlanoCartesiano(){
            addKeyListener(new KeyBoardListener());
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            drawPlanoCarteciano(grphcs);
            drawFuncion(grphcs);
        }

        private void drawPlanoCarteciano(Graphics grphcs) {
                
            //Punto de origen (centro)
            ox = getWidth()/2;
            oy = getHeight()/2;
            
            int linea = 6;
            grphcs.setColor(Color.gray);
            //Escala eje x positiva y negativa
            for(int i=ox;i<=getWidth();i+=escala_x){
                grphcs.drawLine(i, oy -linea, i, oy +linea);
            }
            for(int i=ox;i>=0;i-=escala_x){
                grphcs.drawLine(i, oy -linea, i, oy +linea);
            }
            
            //Escala ehe y positiva y negativa
            for(int i=oy;i<=getHeight();i+=escala_y){
                grphcs.drawLine(ox-linea, i, ox+linea, i);
            }
            for(int i=oy;i>=0;i-=escala_y){
                grphcs.drawLine(ox-linea, i, ox+linea, i);
            }
            
            //Ejes cordenados
            grphcs.setColor(Color.RED);
            grphcs.drawLine(ox, 0, ox, getHeight());
            grphcs.drawLine(0, oy, getWidth(), oy);
            
        }

        private void drawFuncion(Graphics grphcs) {
            
            grphcs.setColor(Color.blue);
            
            int x,y, xant, yant;
            
            for(y=0;y<getWidth()/2;y++){
                x = y*y;
                yant = y+1;
                xant = yant*yant;
                
                grphcs.drawLine(
                        (int)(ox+(x*escala_x)),
                        (int)(oy+(y*escala_y)),
                        (int)(ox+(xant*escala_x)),
                        (int)(oy+(yant*escala_y))
                );
            }
            
            for(y=0;y<getWidth()/2;y++){
                x = y*y;
                yant = y+1;
                xant = yant*yant;
                
                grphcs.drawLine(
                        (int)(ox+(x*escala_x)),
                        (int)(oy+(-y*escala_y)),
                        (int)(ox+(xant*escala_x)),
                        (int)(oy+(-yant*escala_y))
                );
            }
            
            //System.out.println("REAL: ("+x+","+y+")");
            //System.out.println("TRASLADADA: ("+(ox+(x*escala))+","+((y*escala)+oy)+")");      

//            for(int x = -(getWidth()/2);x<=getWidth()/2;x++){
//                
//                y = -evaluaFuncionCon(x); //evalue e invierte el eje y
//                xant = x+1;
//                
//                yant = -evaluaFuncionCon(xant); //evalue e invierte el eje y
//                
//                grphcs.drawLine(
//                        (int)(ox+(x*escala_x)),
//                        (int)(oy+(y*escala_y)),
//                        (int)(ox+(xant*escala_x)),
//                        (int)(oy+(yant*escala_y))
//                );
//            }            
        }

        private int evaluaFuncionCon(int x) {
            //return  ((int)Math.pow(x,2)-8);
            //return x;
//            return (int) Math.pow(x,2)-12;
//            return x;
            return (int)(  Math.pow(x,3) + 2*Math.pow(x,2) -x -2  ); //x^3+2x^2-x-2
//              return Math.cos(x);
//            return (int) Math.pow(x,3);
            
        }
    }
    
    
    class KeyBoardListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent ke) {
            switch(ke.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    escala_x+=2;
                    break;
                case KeyEvent.VK_RIGHT:
                    if(escala_x>=1) escala_x-=2;
                    if(escala_x<1) escala_x=1;
                    break;
                case KeyEvent.VK_UP:
                    if(escala_y>=1) escala_y-=2;
                    if(escala_y<1) escala_y=1;
                    break;
                case KeyEvent.VK_DOWN:
                    escala_y+=3;
                    break;
                default: 
                    break;
            }
            repaint();
        }
        
    }
}
