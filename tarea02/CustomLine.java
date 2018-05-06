/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea02;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author shikami
 */
public class CustomLine implements Drawable{
    
    int WSCALE = 20;
    int HSCALE = 20;
    
    float x1;
    float y1;
    
    float x2;
    float y2;
    
    CustomLine(float x1, float y1,float x2, float y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
      Graphics2D g2 = (Graphics2D)g;
      g2.draw(new Line2D.Double(x+(WSCALE*x1),y-(HSCALE*y1),x+(WSCALE*x2),y-(HSCALE*y2)));
    }
    
    
    
}
