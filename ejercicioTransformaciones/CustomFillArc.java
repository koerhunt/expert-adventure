package ejercicioTransformaciones;
import java.awt.Graphics;

/**
 *
 * @author shikami
 */

public class CustomFillArc extends Transformable{
    
    int ox, oy;
    
    //Crea un arreglo de puntos de un arco relleno de ox,oy y un radio de r
    //comienza en offset y termina en offset+30
    CustomFillArc(int ox, int oy, int r,int offset){
        
        //Coordenadas del origen de la figura
        this.ox = ox;
        this.oy = oy;
        
        //Arreglo de puntos del arco
        points = new int[30][3];
        for (int i = 0; i < 30; i++) {
            points[i][0] = (int)((r)*Math.cos(Math.toRadians(i+offset))+ox);
            points[i][1] = (int)((r)*Math.sin(Math.toRadians(i+offset))+oy);
            points[i][2] = 1;
        }
        
    }
    
    //Especifica como sera dibujada la figura
    @Override
    public void draw(Graphics grphcs) {
        for (int[] point : points) {            
            grphcs.drawLine(ox, oy, point[0], point[1]);
        }
    }
    
    
}
