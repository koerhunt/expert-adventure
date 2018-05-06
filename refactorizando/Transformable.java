/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactorizando;

import java.awt.Graphics;

/**
 *
 * @author shikami
 */
public abstract class Transformable {
    
    int points[][];
    
    public void draw(Graphics g){};
    
    //Draw points of the figure
    public void drawPoints(Graphics grphcs) {
        for (int[] point : points) {
            grphcs.fillOval(point[0], point[1], 3, 3);
        }
    }
    
    public void rotate(int degg) {
        for (int[] point : points) {
            int[] npoint = transformaciones.Transformations.transformRotate(point, degg);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }
    
    public void scale(int sx, int sy) {
        for (int[] point : points) {
            int[] npoint = transformaciones.Transformations.transformScale(point, sx, sy);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }
    
    public void translate(int dx, int dy){
        for (int[] point : points) {
            int[] npoint = transformaciones.Transformations.transformTranslate(point, dx, dy);
            point[0] = npoint[0];
            point[1] = npoint[1];
            point[2] = npoint[2];
        }
    }
    
}
