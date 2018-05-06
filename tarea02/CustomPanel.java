/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this te}mplate file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea02;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class CustomPanel extends JPanel{
    
    Graphics g;
    CustomPanel(){
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        this.g = grphcs;
        
        drawCaracter('A',10,50);
        drawCaracter('E',60,50);
        drawCaracter('I',100,50);
        drawCaracter('O',150,50);
        drawCaracter('U',200,50);
    }
    
    
    private void drawCaracter(char c,int x, int y){
        
        Drawable a[] = {
            new CustomLine(0,0,1,2),
            new CustomLine(1,2,2,0),
            new CustomLine(0.5f,1,1.5f,1)
        };
        
        Drawable e[] = {
            new CustomLine(0.5f,2,1.5f,2),
            new CustomLine(0.5f,1,1.5f,1),
            new CustomLine(0.5f,0,1.5f,0),
            new CustomLine(0.5f,0,0.5f,2)
        };
        
        Drawable i[] = {
            new CustomLine(0.5f,0,1.5f,0),
            new CustomLine(0.5f,2,1.5f,2),
            new CustomLine(1,0,1,2)
        };
        
        Drawable o[] = {
            new CustomCircle(1f,1f,1f)
        };
        
//        CustomLine o2[] = {
//            new CustomLine(0.5f,0,0.5f,2),
//            new CustomLine(0.5f,0,2,0),
//            new CustomLine(2,2,0.5f,2),
//            new CustomLine(2,2,2,0)
//        };
        
//        CustomLine u2[] = {
//            new CustomLine(0.5f,0,0.5f,2),
//            new CustomLine(2,2,2,0),
//            new CustomLine(0.5f,0,2,0)
//        };

         Drawable u[] = {
            new CustomLine(0.5f,0.5f,0.5f,2),
            new CustomLine(1.75f,2,1.75f,0.5f),
            new CustomArc(0.5f, 1, 1, 0, 0.75f,180,90),
            new CustomArc(1f, 1, 1.5f, 1, 0.75f,270,90),
            new CustomLine(0.75f,0,1.5f,0),
        };

        
        switch(c){
            case 'A':
                for (Drawable node : a) {
                    (node).draw(g,x,y);
                }
                break;
            case 'E':
                for (Drawable node : e) {
                    (node).draw(g,x,y);
                }
                break;
            case 'I':
                for (Drawable node : i) {
                    (node).draw(g,x,y);
                }
                break;
            case 'O':
                for (Drawable node : o) {
                    (node).draw(g,x,y);
                }
                break;
            case 'U':
                for (Drawable node : u) {
                    (node).draw(g,x,y);
                }
               break;
            default:
                System.out.println("caracter no soportado");
                break;
        }
    }
    
    
}
