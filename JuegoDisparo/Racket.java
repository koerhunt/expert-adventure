/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates

 * and open the template in the editor.
 */
package JuegoDisparo;

import JuegoPingPong.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author shikami
 */
public class Racket{
    
    private int x;
    private int y;
    
    private int width;
    private int height;
    
    private int velocity;
    private Rectangle area;
    
    private int wcontainer;
    private int hcontainer;
        
    Racket(int x,int y, int width, int height){
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        this.velocity = 5;
        area = new Rectangle(x, y, width, height);
        
    }
    
    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, width, height);
        g.setColor(c);
    }

    void moveLeft() {
        if(this.x>=0-width/2){
            this.x-=velocity;
        }
    }

    void moveRigth() {
        if(this.x<=(wcontainer-width/2)){
            this.x+=velocity;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getArea() {
        return area;
    }

    public void setArea(Rectangle area) {
        this.area = area;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getWcontainer() {
        return wcontainer;
    }

    public void setWcontainer(int wcontainer) {
        this.wcontainer = wcontainer;
    }

    public int getHcontainer() {
        return hcontainer;
    }

    public void setHcontainer(int hcontainer) {
        this.hcontainer = hcontainer;
    }
    
    
    public void drawRect(Graphics g){
        Color prevColor = g.getColor();
        g.setColor(Color.blue);
        g.drawRect(x,y,width,15);
        g.setColor(prevColor);
    }
    
    public Rectangle getRect(){
        return new Rectangle(x,y,width,15);
    }
    
    
}
