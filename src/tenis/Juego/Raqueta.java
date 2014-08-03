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
import tenis.observer.Observable;
import tenis.observer.Observador;

public class Raqueta extends JComponent implements KeyListener, Observador {

    private final Color c = Color.BLACK;
    private final int ancho = 50;
    private final int alto = 200;
    private final int velocidad = 1;
    private final boolean raqueda1;

    public Raqueta(boolean raqueda1) {
        this.raqueda1 = raqueda1;
    }

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
            if (p.y + this.getHeight() <= this.getParent().getHeight() - velocidad) {
                this.setLocation(p.x, p.y + velocidad);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            Point p = this.getLocation();
            if (p.y - velocidad >= 0) {
                this.setLocation(p.x, p.y - velocidad);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void update(Observable o) {
        if (o instanceof Pelota) {
            Pelota p = (Pelota) o;
            Point pelota = p.getLocation();
            if (tocaPelota(p)) {
                p.rebota();
            }
        }
    }

    private boolean tocaPelota(Pelota p) {
        Point pelota = p.getLocation();
        Point raqueta = this.getLocation();
        if (p.seMueveALaDerecha() && raqueda1) {
            if (pelota.x + p.getWidth() > raqueta.x && pelota.y >= raqueta.y && pelota.y <= raqueta.y + this.getHeight()) {
                return true;
            }
        }
        if (!raqueda1 && p.seMueveALaIzquierda()) {
            if (pelota.x < raqueta.x + this.getWidth() && pelota.y >= raqueta.y && pelota.y <= raqueta.y + this.getHeight()) {
                return true;
            }
        }
        return false;
    }
}
