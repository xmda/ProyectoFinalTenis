/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tenis.observer.Observable;
import tenis.observer.Observador;

public class Campo extends JFrame implements Observador {

    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Marcador marcador;
    private final Pelota pelota;
    private final Raqueta raquetaJugador1;
    private final Raqueta raquetaJugador2;
    private final JPanel letreroMarcador;

    public Campo(Jugador jugador1, Jugador jugador2, Marcador marcador) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.marcador = marcador;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        letreroMarcador = new JPanel();
        pack();
        setLayout(null);
        setSize(800, 600);
        pelota = new Pelota(this);
        this.add(pelota).setBounds(0, 0, 30, 30);
        raquetaJugador1 = new Raqueta(true);
        raquetaJugador2 = new Raqueta(false);
        raquetaJugador1.setFocusable(true);
        raquetaJugador2.setFocusable(true);
        this.add(raquetaJugador1).setBounds(0, 0, 50, 200);
        this.add(raquetaJugador2).setBounds(this.getWidth() - 60, 0, 50, 200);
        this.setBackground(Color.GREEN);
        pelota.agregarObservador(raquetaJugador1);
        pelota.agregarObservador(raquetaJugador2);
        pelota.agregarObservador(this);
        letreroMarcador.setLayout(null);
        letreroMarcador.add(new JLabel(marcador.marcador(0, 0))).setBounds(0, 0, 400, 50);
        this.add(letreroMarcador).setBounds(this.getWidth() / 2 - 200, 0, 400, 50);
    }

    public void lanzarPelota() {
        pelota.start();
    }

    @Override
    public void update(Observable o) {
        if (o instanceof Pelota) {
            Pelota p = (Pelota) o;
            if (p.isSalio()) {
                if (p.seMueveALaDerecha()) {
                    jugador1.anotar();
                } else {
                    jugador2.anotar();
                }
                letreroMarcador.removeAll();
                letreroMarcador.add(new JLabel(marcador.marcador(jugador1.getPuntuacion(), jugador2.getPuntuacion()))).setBounds(0, 0, 400, 50);
            }
        }
    }
}
