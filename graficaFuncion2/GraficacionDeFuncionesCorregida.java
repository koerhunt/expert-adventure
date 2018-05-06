/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaFuncion2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


/**
 *
 * @author shikami
 */
public class GraficacionDeFuncionesCorregida extends JFrame {
        
    
//Rango de la funcion a graficar
    int escala_x_p = 6;
    int escala_x_n = -3;
    
    boolean drawScaleX = true;
    boolean drawScaleY = true;

    GraficacionDeFuncionesCorregida(){
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
        GraficacionDeFuncionesCorregida GFD = new GraficacionDeFuncionesCorregida();
    }
    
    public class PlanoCartesiano extends JPanel{
        
        //Numero de partidos de la escala en x
        int ncx;
        int ncy;
                
        //punto de origen
        int ox;
        int oy;

        @Override
        protected void paintComponent(Graphics grphcs) {
            drawPlanoCarteciano(grphcs);
            drawFuncion(grphcs);
        }

        private void drawPlanoCarteciano(Graphics grphcs) {
                
            int max = obtenerMaximo();
            int min = obtenerMinimo();
            
            //Escala
            ncx = Math.round((float)getWidth()/(float)(Math.abs(escala_x_p) + Math.abs(escala_x_n)));
            ncy = Math.round((float)getHeight()/(float)(Math.abs(max)+Math.abs(min)));
            
            //Calcular coordenada x el origen
            ox = (escala_x_n*-1)*ncx;
            if(min<0){  
                oy = (Math.abs(max)-Math.abs(min))*ncy;
            }
            
            //Dibujar Eje de las X
            grphcs.setColor(Color.red);
            grphcs.drawLine(0, oy, getWidth(), oy);
            
            //Dibujar Eje de las Y
            grphcs.setColor(Color.blue);
            grphcs.drawLine(ox, 0, ox, getHeight());
            
            //Escala del Eje Y
            if(drawScaleY){
                grphcs.setColor(Color.gray);
                for(int i=0;i<=getHeight();i+=ncy){
                    grphcs.drawLine(ox+10, i, ox-10, i);
                }
            }
            
            //Escala del Eje X 
            if(drawScaleX){
                grphcs.setColor(Color.gray);
                for(int i=0;i<=getWidth();i+=ncx){
                    grphcs.drawLine(i, oy+10, i, oy-10);
                }   
            }
            
            
        }

        private void drawFuncion(Graphics grphcs) {
            
            double y,x;
            double rx,ry;
            
            double yant,xant;
            double rxant,ryant;
            
            //Parte positiva
            grphcs.setColor(Color.red);
            
            for(x = escala_x_n; x<=getWidth();x++){
                
                rx = (x-ox);
                ry = -evaluaFuncionCon((rx/ncx));
                
                rxant = ((x-1)-ox);
                ryant = -evaluaFuncionCon((rxant/ncx));
                        
                x = rx+ox;
                y = (ry*ncy)+oy;
                
                xant = rxant+ox;
                yant = (ryant*ncy)+oy;
                
                grphcs.drawLine((int)xant,(int)yant,(int)x,(int)y);
            }
            
            
         
        }

        private double evaluaFuncionCon(double x) {
            return ( Math.pow(x,3) + 2*Math.pow(x,2) -x -2  ); //x^3+2x^2-x-2
        }
        
        private int obtenerMaximo(){
            double max, y;
            max = evaluaFuncionCon(escala_x_n);
            for(int x = (escala_x_n+1); x<=escala_x_p;x++){
                y = evaluaFuncionCon(x);
                if(max<y){
                    max = y;
                }
            }
            return (int)max;
        }
        
         private int obtenerMinimo(){
            double  min, y;
            min = evaluaFuncionCon(escala_x_n);
            for(int x = (escala_x_n+1); x<=escala_x_p;x++){
                y = evaluaFuncionCon(x);
                if(min>y){
                    min = y;
                }
            }
            return (int)min;
        }
        
    }
    
}

