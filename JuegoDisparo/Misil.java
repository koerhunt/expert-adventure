/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDisparo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 *
 * @author shikami
 */
public class Misil {
    
    //origen de la pelota
    private int x;
    private int y;
    
    private int w;
    private int h;
    
    private boolean active;
    
    
    Misil(int x, int y){
        
        //Inicializacion
        this.x = x;
        this.y = y;       
        
        this.w = 10;
        this.h = 15;
        
        active=true;
        
    }
 
    void move() {            
        if(this.y>=-h){
            this.y--;
        }else{
            this.active = false;
            System.out.println("Tope Superior");
        }
    }   
    
    //Dibujar Misil
    public void draw(Graphics g){
        Color prevColor = g.getColor();
        g.setColor(Color.red);
        g.fillRect(x, y, w, h);
        g.setColor(prevColor);
    };
    
    public void drawRect(Graphics g){
        Color prevColor = g.getColor();
        g.setColor(Color.blue);
        g.drawRect(x, y, w, h);
        g.setColor(prevColor);
    }
    
    public Rectangle getRect(){
        return new Rectangle(x,y,w,h);
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    boolean isActive() {
        return this.active;
    }
    
    
    
    
}
