/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.VetoableChangeListener;
import javax.swing.JPanel;


public class CustomPanel extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.RED);
        g.drawLine(0, 0, 80, 50);
        g.setColor(Color.BLACK);
        g.drawRect(180, 20, 25, 80);
        g.setColor(Color.BLUE);
        g.fillRect(85, 20, 25, 80);
        g.setColor(Color.YELLOW);
        g.draw3DRect(200, 200, 120, 100, true);
        g.fill3DRect(200, 200, 120, 100, true);
        g.setColor(Color.GRAY);
        g.draw3DRect(20, 200, 120, 100, false);
        g.fill3DRect(20, 200, 120, 100, false);
    }
    
    
}