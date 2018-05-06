package ejercicioTransformaciones;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author shikami
 */

public abstract class Transformable {
    
    //Arreglo de puntos de la figura
    int points[][];
    
    //Constructor
    public Transformable(){};
    
    //Metodo de dibujar, para especificar la manera en la que seran mostrados
    //los puntos points[][]
    public void draw(Graphics g){};
    
    //Draw points of the figure
    public void drawPoints(Graphics grphcs) {
        Color before = grphcs.getColor();
        grphcs.setColor(Color.red);
        for (int[] point : points) {
            grphcs.fillOval(point[0]-2, point[1]-2, 4, 4);
        }
        grphcs.setColor(before);
    }
    
    //Rotar cada uno de los puntos de la figura
    public void rotate(double degg) {
        for (int[] point : points) {
            int[] npoint = Transformations.transformRotate(point, degg);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }
    
    //Escalar cada uno de los puntos de la figura
    public void scale(int sx, int sy) {
        for (int[] point : points) {
            int[] npoint = Transformations.transformScale(point, sx, sy);
            point[0] = npoint[0];
            point[1] = npoint[1];
        }
    }
    
    //Trasladar cada uno de los puntos de la figura
    public void translate(int dx, int dy){
        for (int[] point : points) {
            int[] npoint = Transformations.transformTranslate(point, dx, dy);
            point[0] = npoint[0];
            point[1] = npoint[1];
            point[2] = npoint[2];
        }
    }
    
}
