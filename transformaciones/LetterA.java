/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformaciones;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;
/**
 *
 * @author shikami
 */
public class LetterA{
    
    int points[][];
    int origin[];
    
    LetterA(int orx, int ory){
        
        
        points = new int[5][3];
        origin = new int[3];
        
        origin[0] = orx;
        origin[1] = ory;
        origin[2] = 1;
        
        points[0][0] = 0;
        points[0][1] = 8;
        points[0][2] = 1;
        
        points[1][0] = 4;
        points[1][1] = 0;
        points[1][2] = 1;
        
        points[2][0] = 8;
        points[2][1] = 8;
        points[2][2] = 1;
        
        points[3][0] = 6;
        points[3][1] = 4;
        points[3][2] = 1;
        
        points[4][0] = 2;
        points[4][1] = 4;
        points[4][2] = 1;
    }
    
    public int[][] getPointMatrix(){
        return points;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(origin[0], origin[1], 3, 3);
        g.setColor(Color.black);
         for (int i=0;i<points.length;i++) {
            if(i==points.length-1){
                g.drawLine(points[i][0]+origin[0], points[i][1]+origin[1],points[i][0]+origin[0], points[i][1]+origin[1]);
            }else{
                g.drawLine(points[i][0]+origin[0], points[i][1]+origin[1], points[i+1][0]+origin[0], points[i+1][1]+origin[1]);
            }
           
        }
    }
    
    void rotate(int degrees){        
        for (int[] point : points) {
            int[] npoint = Transformations.transformRotate(point, degrees);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }

    void scale(int sx, int sy) {
        for (int[] point : points) {
            int[] npoint = Transformations.transformScale(point, sx, sy);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }
    
    void translate(int dx, int dy){
        for (int[] point : points) {
            int[] npoint = Transformations.transformTranslate(point, dx, dy);
            point[0] = npoint[0];
            point[1] = npoint[1];
            point[2] = npoint[2];
        }
    }
            
}

