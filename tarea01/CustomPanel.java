/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author shikami
 */
public class CustomPanel  extends JPanel {
    
    private final int xCenter;
    private final int yCenter;
    private final int radius;
    
    public CustomPanel (int x, int y, int r){
        this.xCenter = x;
        this.yCenter = y;
        this.radius = r;
    }
            
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        drawCircle(g);
        drawCircleWithEq(g);
    }
    
    private void drawCircleWithEq(Graphics g){
        Graphics2D gp = (Graphics2D)g;
        gp.draw(new Line2D.Double(xCenter,yCenter,xCenter,yCenter));
         boolean rootNegative = false;
         double x=0;
         while(!rootNegative){
             float y = (float) Math.sqrt( Math.pow(radius,2)-Math.pow(x,2));
             Shape s = new Line2D.Double(xCenter+x, yCenter+y, xCenter+x,yCenter+y);
             Shape s2 = new Line2D.Double(xCenter-x, yCenter-y, xCenter-x,yCenter-y);
             Shape s3 = new Line2D.Double(xCenter-x, yCenter+y, xCenter-x,yCenter+y);
             Shape s4 = new Line2D.Double(xCenter+x, yCenter-y, xCenter+x,yCenter-y);
             
             gp.draw(s);
             gp.draw(s2);
             gp.draw(s3);
             gp.draw(s4);
             
             if(Float.isNaN(y)){
                 break;
             }
             x+=0.01;
         }
    }
    
    
    private void drawCircle(Graphics g){
        Graphics2D gp = (Graphics2D)g;
        gp.draw(new Line2D.Double(xCenter+220,yCenter,xCenter+220,yCenter));
        //Calculate point for each angle
        for(double alpha = 0; alpha<360;alpha=alpha+0.01){
            double dx = radius*Math.cos(alpha);
            double dy = radius*Math.sin(alpha);
            Shape s = new Line2D.Double(xCenter+dx+220, yCenter+dy, xCenter+dx+220,yCenter+dy);
            gp.draw(s);
        }   
    };
    
}
