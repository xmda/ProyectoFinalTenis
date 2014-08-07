/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego.Pelota;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JComponent;
import tenis.Juego.InterfazGrafica;
import tenis.observer.Observable;
import tenis.observer.Observador;

public class Pelota extends JComponent implements Runnable, Observable {

    public final EstadoPelota MOVIMIENTO_IZQUIERDA = new PelotaMovimientoIzquierda(this);
    public final EstadoPelota MOVIMIENTO_DERECHA = new PelotaMovimientoDerecha(this);
    public final EstadoPelota PELOTA_AFUERA = new PelotaAFuera(this);
    public final EstadoPelota PELOTA_STOP = new PelotaStop(this);
    private final InterfazGrafica padre;
    private Color color;
    private Point centro;
    private int radio = 10;
    private int velocidad;
    private final Thread hilo;
    private int incrementoX = 1;
    private int incrementoY = 1;
    private EstadoPelota estado;

    public Pelota(InterfazGrafica padre) {
        estado = new PelotaMovimientoDerecha(this);
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
    }

    public boolean seMueveALaIzquierda() {
        return incrementoX < 0;
    }

    public boolean seMueveALaDerecha() {
        return incrementoX > 0;
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
        while (true) {
            try {
                estado.mover();
                if (this.getLocation().x < 0 || this.getLocation().x + this.getWidth() > padre.getWidth()) {
                    estado = new PelotaAFuera(this);
                }
                notificar();
                Thread.sleep(velocidad);
                Thread.yield();
            } catch (InterruptedException ex) {
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void stop() {
        estado = new PelotaStop(this);
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

    public Point getCentro() {
        return centro;
    }

    public EstadoPelota getEstado() {
        return estado;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setEstado(EstadoPelota estado) {
        this.estado = estado;
        System.err.println(estado.getClass().getName());
    }

    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }
}
