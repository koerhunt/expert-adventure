/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioTransformaciones;

import examenTransformaciones.*;
import java.awt.Graphics;
import transformaciones.Transformations;

/**
 *
 * @author shikami
 */
public class CustomPolygon extends Transformable{
    
    public CustomPolygon(int[][] matrixOfPoints){
        //Clona el arreglo de puntos.
        points = new int[matrixOfPoints.length][matrixOfPoints[0].length];
        for(int i = 0;i<matrixOfPoints.length;i++){
            System.arraycopy(matrixOfPoints[i], 0, points[i], 0, matrixOfPoints[0].length);
        }
    }

    @Override
    public void draw(Graphics grphcs) {
        drawPoints(grphcs);
        for (int i=0;i<points.length;i++) {
            if(i==points.length-1){
                grphcs.drawLine(points[i][0], points[i][1],points[0][0], points[0][1]);
            }else{
                grphcs.drawLine(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
            }
        }
    }
    
}
