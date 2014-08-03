/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;

public class Pelota extends JComponent implements Runnable {

    private final Campo padre;
    private final Color color;
    private final boolean stop = false;
    private final Point centro;
    private final int radio = 10;
    private final int velocidad;
    private final Thread hilo;
    private final int incrementoX = 1;
    private int incrementoY = 1;
    private boolean hacia_abajo=true;
    
    public Pelota(Campo padre) {
        this.padre = padre;
        centro = new Point(padre.getWidth() / 2 - radio, padre.getHeight() / 2 - radio);
        velocidad = 5;
        hilo = new Thread(this);
        color=Color.BLACK;
    }

    public void start() {
        hilo.start();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, radio * 2, radio * 2);
    }

    @Override
    public void run() {
        this.setLocation(centro);
        int x = centro.x;
        int y = centro.y;
        while (!stop) {
            try {
                x += incrementoX;
                y += incrementoY;
                this.setLocation(x, y);
                if (y >= (padre.getHeight()-radio*2) && hacia_abajo ) {
                    incrementoY = -1;
                    hacia_abajo=false;
                }else if (y < 0&& !hacia_abajo) {
                    incrementoY = 1;
                    hacia_abajo=true;
                }
                hilo.sleep(velocidad);
            } catch (InterruptedException ex) {
            }

        }

    }
}
