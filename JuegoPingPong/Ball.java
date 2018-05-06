/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoPingPong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
    private int 
            radio;
    private final Color ball_color;
    
    //2do punto para calcular eq de recta
    private int x1, y1;
    private int x2, y2;
    
    private double md;
    
    //maximo del contenedor
    private final int wcontainer;
    private final int hcontainer;
    
    
    public boolean vertical;
    public boolean horizontal;
    
    Ball(int x, int y, int radio, Color ball_color, int wcont, int hcont){
        
        //Inicializacion
        this.x = x;
        this.y = y;
        
        this.x1 = x;
        this.y1 = y;
        
        
        this.ball_color = ball_color;
        this.radio = radio;
        
        this.wcontainer = wcont;
        this.hcontainer = hcont;
        
        vertical = true;
        horizontal = false;
       
        
    }
    
    void bounceOnRacket(){
        vertical = true;
        
        this.x1 = x;
        this.y1 = y;
        
        this.x2 = ThreadLocalRandom.current().nextInt(0, wcontainer);
        this.y2 = ThreadLocalRandom.current().nextInt(0, hcontainer-200);

        
        this.md = ((double)(y2-y1))/((double)(x2-x1));
        
    }
    
    void changeToRandomDirection() {
        
        if(x<=0){
            horizontal = true;
            x++;
        }else{
            if( (x+radio) >=wcontainer){
                horizontal = false;
                x--;
            }
        }
        
        this.x1 = x;
        this.y1 = y;
        
        
        this.x2 = ThreadLocalRandom.current().nextInt(0, wcontainer);
        
        if(vertical){
            this.y2 = ThreadLocalRandom.current().nextInt(0, y);
        }else{
            this.y2 = ThreadLocalRandom.current().nextInt(y, hcontainer);
        }

        
        this.md = ((double)(y2-y1))/((double)(x2-x1));
        System.out.println(md);
        

    }
    
    void move() {            
        if(horizontal){
            x+=1;
            this.y = (int) (md*x -  md*x1 + y1);
        }else{
            x-=1;
            this.y = (int) (md*x -  md*x1 + y1);
        }
    }   
    
    //Dibujar pelota en posicion actual
    public void draw(Graphics g){
        Color prevColor = g.getColor();
        g.setColor(ball_color);
        g.fillOval(x, y, (radio), (radio));
        g.setColor(prevColor);
    };
    
    public void drawRect(Graphics g){
        Color prevColor = g.getColor();
        g.setColor(Color.blue);
        g.drawRect((x+(radio/3)), y+(radio-10), (radio/4)+2, (10));
        g.setColor(prevColor);
    }
    
    public Rectangle getRect(){
        return new Rectangle((x+(radio/3)), y+(radio-10), (radio/4)+2, (10));
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
