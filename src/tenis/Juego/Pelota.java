/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;
import tenis.observer.Observable;
import tenis.observer.Observador;

public class Pelota extends JComponent implements Runnable, Observable {

    private final Campo padre;
    private Color color;
    private boolean stop = false;
    private Point centro;
    private int radio = 10;
    private final int velocidad;
    private final Thread hilo;
    private int incrementoX = 1;
    private int incrementoY = 1;
    private boolean hacia_abajo = true;
    private boolean salio = false;

    public Pelota(Campo padre) {
        this.padre = padre;
        centro = new Point(padre.getWidth() / 2 - radio, padre.getHeight() / 2 - radio);
        velocidad = 5;
        hilo = new Thread(this);
        color = Color.BLACK;
        incrementoX = (int) (Math.random() * 2 + 1);
        incrementoY = (int) (Math.random() * 2 + 1);
    }

    public void reiniciar() {
        incrementoX = (int) (Math.random() * 2 + 1);
        incrementoY = (int) (Math.random() * 2 + 1);
        centro = new Point(padre.getWidth() / 2 - radio, padre.getHeight() / 2 - radio);
        this.setLocation(centro);
        salio = false;
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
        }
    }

    public void rebota() {
        incrementoX = incrementoX * -1;
    }

    public boolean seMueveALaIzquierda() {
        return incrementoX > 0;
    }

    public boolean seMueveALaDerecha() {
        return incrementoX < 0;
    }

    public void start() {
        hilo.start();
    }

    /**
     *
     * @param g
     */
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
                notificar();
                if (y >= (padre.getHeight() - this.getHeight() - radio) && hacia_abajo) {
                    incrementoY = incrementoY * -1;
                    hacia_abajo = false;
                } else if (y < 0 && !hacia_abajo) {
                    incrementoY = Math.abs(incrementoY);
                    hacia_abajo = true;
                }else if (x < 0 || x+this.getWidth() > padre.getWidth() ) {
                    salio = true;
                    notificar();
                    x = centro.x;
                    y = centro.y;
                    reiniciar();
                    hacia_abajo = true;
                }
                Thread.sleep(velocidad);
            } catch (InterruptedException ex) {
            }

        }

    }

    public Color getColor() {
        return color;
    }

    public boolean isSalio() {
        return salio;
    }

    public void setSalio(boolean salio) {
        this.salio = salio;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getIncrementoX() {
        return incrementoX;
    }

    public void setIncrementoX(int incrementoX) {
        this.incrementoX = incrementoX;
    }

    public int getIncrementoY() {
        return incrementoY;
    }

    public void setIncrementoY(int incrementoY) {
        this.incrementoY = incrementoY;
    }

    @Override
    public void notificar() {
        for (Observador o : observadores) {
            o.update(this);
        }
    }

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }
}
