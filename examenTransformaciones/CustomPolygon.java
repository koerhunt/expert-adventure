/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenTransformaciones;

import java.awt.Graphics;
import transformaciones.Transformations;

/**
 *
 * @author shikami
 */
public class CustomPolygon {
    
    int points[][];
    
    public CustomPolygon(){
        points = new int[7][3];
        
        points[0] = new int[]{50,0,1};
        points[1] = new int[]{70,30,1};
        points[2] = new int[]{60,50,1};
        points[3] = new int[]{60,70,1};
        points[4] = new int[]{40,70,1};
        points[5] = new int[]{40,50,1};
        points[6] = new int[]{30,30,1};
    }

    public void draw(Graphics grphcs) {
        for (int i=0;i<points.length;i++) {
            if(i==points.length-1){
                grphcs.drawLine(points[i][0], points[i][1],points[0][0], points[0][1]);
            }else{
                grphcs.drawLine(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
            }
        }
    }
    public void rotate(int degrees){        
        for (int[] point : points) {
            int[] npoint = Transformations.transformRotate(point, degrees);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }

    public void scale(int sx, int sy) {
        for (int[] point : points) {
            int[] npoint = Transformations.transformScale(point, sx, sy);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }
    
    public void translate(int dx, int dy){
        for (int[] point : points) {
            int[] npoint = Transformations.transformTranslate(point, dx, dy);
            point[0] = npoint[0];
            point[1] = npoint[1];
            point[2] = npoint[2];
        }
    }
    
}
