/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programasPerspectivas;

import java.awt.Graphics;

/**
 *
 * @author shikami
 */
public class Persona {
    
    int x;
    int y;
    
    int scale;

    Persona(int i, int i0) {
        this.x = i;
        this.y = i0;
        this.scale = 10;
    }
    
    public void draw(Graphics g){
        
        g.fillOval(x-(5*scale),y-(5*scale),10*scale,10*scale);
        
    }
    
    public void alejar(){
        this.y+=40;
        this.scale++;
    }
    
    public void acercar(){
        this.y-=40;
        this.scale--;
    }
    
}

