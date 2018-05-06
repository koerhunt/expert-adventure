/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea02;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 *
 * @author shikami
 */
public class CustomCircle implements Drawable{
    
    int WSCALE = 20;
    int HSCALE = 20;
    
    float x1, y1;
    float r;
    
     
    CustomCircle(float x, float y,float r){
        this.x1 = x;
        this.y1 = y;
        this.r = r;
    }
    
    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D gp = (Graphics2D)g;
        //Calculate point for each angle
        for(double alpha = 0; alpha<360;alpha=alpha+0.01){
            double dx = (r*WSCALE)*Math.cos(alpha);
            double dy = (r*WSCALE)*Math.sin(alpha);
            Shape s = new Line2D.Double((x+(WSCALE*x1))+dx, (y-(WSCALE*y1))+dy,(x+(WSCALE*x1))+dx, (y-(WSCALE*y1))+dy);
            gp.draw(s);
        }  
    }
    
}
