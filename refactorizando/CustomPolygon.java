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
public class CustomPolygon extends Transformable{
    
    public CustomPolygon(){
        super();
        
        points = new int[7][3];
        
        points[0] = new int[]{50,0,1};
        points[1] = new int[]{70,30,1};
        points[2] = new int[]{60,50,1};
        points[3] = new int[]{60,70,1};
        points[4] = new int[]{40,70,1};
        points[5] = new int[]{40,50,1};
        points[6] = new int[]{30,30,1};
    }
    
    
    @Override
    public void draw(Graphics g){
        drawPoints(g);
    }
    
}
