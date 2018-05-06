/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea01;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class PruebaDibujarCirculo extends JFrame {
    
    public static void main (String args[]){
        
        PruebaDibujarCirculo pd = new PruebaDibujarCirculo();
        pd.setTitle("Prueba de dibujar circulo");
        pd.setSize(600, 600);
        pd.setLocationRelativeTo(null);
        pd.setVisible(true);
        
        JPanel jp = new JPanel(){
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawOval(getWidth()/2, getHeight()/2, 35, 35);
            }
            
        };
        
        
        pd.add(jp);
        
        pd.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    
}
