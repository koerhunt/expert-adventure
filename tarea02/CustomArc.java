/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea02;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author shikami
 */
public class CustomArc implements Drawable {
    float h, x1,x2,y1,y2;
    
    int WSCALE = 20;
    int HSCALE = 20;
    
    float a, b;
    
    CustomArc(float x1, float y1,float x2, float y2,float h,int a, int b){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.h = h;
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D)g;
        
        Shape r = new Rectangle2D.Double(x + (WSCALE*x1)  ,y - (HSCALE*y1),(WSCALE*h),HSCALE);
        
        Shape s =  new Arc2D.Float((Rectangle2D)r, a, b, Arc2D.OPEN);
//        g2.draw(r);
        g2.draw(s);
//        g2.draw(s2);
        
    }
    
}

//Graphics2D g2 = (Graphics2D)g;
//        
//        Shape r = new Rectangle2D.Double(x+15, y-(HSCALE*2),WSCALE,(HSCALE*2));
//        
//        Shape s =  new Arc2D.Float((Rectangle2D)r, 90, 180, (int) h);
//        Shape s2 =  new Arc2D.Float((Rectangle2D)r, 180, 360, (int) h);
//        
////        g2.draw(r);
//        g2.draw(s);
//        g2.draw(s2);