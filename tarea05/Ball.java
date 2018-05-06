/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author shikami
 */
public class Ball {
    
    //origen de la pelota
    private int x;
    private int y;
    
    //radio y color
    private int radio;
    private final Color ball_color;
    
    //2do punto para calcular eq de recta
    private int x1, y1;
    private int x2, y2;
    
    private double md;
    
    //maximo del contenedor
    private int wcontainer;
    private int hcontainer;
    
    public int direction = 2;
    
    public boolean vertical;
    public boolean horizontal;
    
    Ball(int x, int y, int radio, Color ball_color, int wcont, int hcont){
        
        //Inicializacion
        this.x = x;
        this.y = y;
        
        this.x1 = x;
        this.y1 = y;
        
//        this.x2 = ThreadLocalRandom.current().nextInt(0, wcont);
//        this.y2 = ThreadLocalRandom.current().nextInt(0, hcont);
        
        this.ball_color = ball_color;
        this.radio = radio;
        
        this.wcontainer = wcont;
        this.hcontainer = hcont;
        
        vertical = true;
       
        
    }
    
    
    void changeToRandomDirection() {
        
        this.x1 = x;
        this.y1 = y;
        
        this.x2 = ThreadLocalRandom.current().nextInt(0, wcontainer);
        this.y2 = ThreadLocalRandom.current().nextInt(0, hcontainer);

//        this.x2 = x*-1;
//        this.y2 = y*-1;
        
        this.md = ((double)(y2-y1))/((double)(x2-x1));
        System.out.println(md);
        

    }
    
    void move() {
//        System.out.println("horizontal: "+horizontal);
//        System.out.println("vertical: "+vertical);
               
        if(horizontal){
            x+=5;
            this.y = (int) (md*x -  md*x1 + y1);
        }else{
            x-=5;
            this.y = (int) (md*x -  md*x1 + y1);
        }
//        System.out.println(x);
    }   
    
    //Dibujar pelota en posicion actual
    public void draw(Graphics g){
        Color prevColor = g.getColor();
        g.setColor(ball_color);
        g.fillOval(x, y, (radio), (radio));
        g.setColor(prevColor);
    };

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

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    } 

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public double getMd() {
        return md;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
    
}
