/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

public class Raqueta extends JComponent implements KeyListener {

    private final Color c = Color.BLACK;
    private final int ancho = 50;
    private final int alto = 200;
    private final int velocidad = 1;

    @Override
    public void paint(Graphics g) {
        g.setColor(c);
        g.fillRect(0, 0, ancho, alto);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Point p = this.getLocation();
            if (p.y+this.getHeight() <= this.getParent().getHeight() - velocidad) {
                this.setLocation(p.x, p.y + velocidad);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            Point p = this.getLocation();
            if (p.y-velocidad >= 0) {
                this.setLocation(p.x, p.y - velocidad);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
