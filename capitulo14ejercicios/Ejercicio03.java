/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitulo14ejercicios;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author shikami
 */
public class Ejercicio03 extends JFrame {
     
    Ejercicio03(){
        addMouseListener(new MouseAdapter() {            
            @Override
            public void mouseReleased(MouseEvent e){
                getContentPane().setBackground(Color.white);
                System.out.println("released");
            }
            
            @Override     
            public void mousePressed(MouseEvent e){
                getContentPane().setBackground(Color.black);
                System.out.println("presed");
            }
        });     
    }
    
    public static void main(String args[]){
        
        JFrame frame = new Ejercicio03();
        
        frame.setSize(600,600);
        frame.setTitle("Ejercicio - 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
