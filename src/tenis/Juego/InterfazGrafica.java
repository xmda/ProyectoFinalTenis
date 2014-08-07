/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import tenis.Juego.Pelota.Pelota;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import tenis.Juego.Pelota.EstadoPelota;
import tenis.Juego.Pelota.PelotaAFuera;
import tenis.MarcadorTabla;
import tenis.observer.Observable;
import tenis.observer.Observador;

public class InterfazGrafica extends JFrame implements Observador, ActionListener {

    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Marcador marcador;
    private final Pelota pelota;
    private final Raqueta raquetaJugador1;
    private final Raqueta raquetaJugador2;
    private final JPanel letreroMarcador;
    private final JToggleButton stop;
    private final JButton reiniciar;
    private EstadoPelota estado_anterior_al_stop;
    private final MarcadorTabla marcadorT;

    public InterfazGrafica(Jugador jugador1, Jugador jugador2, Marcador marcador) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.marcador = marcador;
        pelota = new Pelota(this);
        raquetaJugador1 = new Raqueta(true);
        raquetaJugador2 = new Raqueta(false);
        letreroMarcador = new JPanel();
        marcadorT =new MarcadorTabla();
        stop = new JToggleButton("Stop");
        reiniciar = new JButton("reiniciar");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLayout(null);
        setSize(800, 600);
        raquetaJugador1.setFocusable(true);
        raquetaJugador2.setFocusable(true);
        this.add(pelota).setBounds(0, 0, 30, 30);
        this.add(raquetaJugador1).setBounds(0, 0, 50, 200);
        this.add(raquetaJugador2).setBounds(this.getWidth() - 60, 0, 50, 200);
        this.add(letreroMarcador).setBounds(0, 0, this.getWidth(), 50);
        this.add(stop).setBounds(this.getWidth() / 2 - 50, 60, 100, 20);
        this.add(reiniciar).setBounds(this.getWidth() / 2 - 50, 80, 100, 20);
        this.setBackground(Color.GREEN);
        pelota.agregarObservador(raquetaJugador1);
        pelota.agregarObservador(raquetaJugador2);
        pelota.agregarObservador(this);
        stop.addActionListener(this);
        reiniciar.addActionListener(this);
        letreroMarcador.setLayout(null);
        marcadorT.setMarcador(marcador);
        marcadorT.setVisible(true);
        JLabel temporal = new JLabel(marcador.marcador(0, 0));
        JLabel temporal2 = new JLabel("0:0");
        temporal.setHorizontalAlignment(JLabel.CENTER);
        temporal2.setHorizontalAlignment(JLabel.CENTER);
        letreroMarcador.setOpaque(false);
        letreroMarcador.add(temporal).setBounds(0, 0, this.getWidth(), 25);
        letreroMarcador.add(temporal2).setBounds(0, 25, this.getWidth(), 25);


    }

    public void lanzarPelota() {
        pelota.start();
    }

    @Override
    public void update(Observable o) {
        if (o instanceof Pelota) {
            Pelota p = (Pelota) o;
            if (p.getEstado() instanceof PelotaAFuera) {
                if (p.seMueveALaDerecha()) {
                    jugador1.anotar();
                    p.reiniciar();
                    p.setEstado(p.MOVIMIENTO_DERECHA);
                } else if(p.seMueveALaIzquierda()) {
                    jugador2.anotar();
                    p.reiniciar();
                    p.setEstado(p.MOVIMIENTO_IZQUIERDA);
                }
                String txt_marcador = this.marcador.marcador(jugador1.getPuntuacion(), jugador2.getPuntuacion());
                if ((txt_marcador == null ? this.marcador.getIdioma().player_1_win() == null : txt_marcador.equals(this.marcador.getIdioma().player_1_win())) || (txt_marcador == null ? this.marcador.getIdioma().player_2_win() == null : txt_marcador.equals(this.marcador.getIdioma().player_2_win()))) {
                    p.setEstado(p.PELOTA_STOP);
                    if (txt_marcador.equals(this.marcador.getIdioma().player_1_win())) {
                        JOptionPane.showMessageDialog(this, "Ganó: " + jugador1.getNombre());
                    } else {
                        JOptionPane.showMessageDialog(this, "Ganó: " + jugador2.getNombre());
                    }
                }
                marcadorT.setDatos(jugador1.getPuntuacion(), jugador2.getPuntuacion());
                letreroMarcador.removeAll();
                JLabel temporal = new JLabel(txt_marcador);
                JLabel temporal2 = new JLabel(jugador1.getPuntuacion() + ":" + jugador2.getPuntuacion());
                temporal.setHorizontalAlignment(JLabel.CENTER);
                temporal2.setHorizontalAlignment(JLabel.CENTER);
                letreroMarcador.setOpaque(false);
                letreroMarcador.add(temporal).setBounds(0, 0, this.getWidth(), 25);
                letreroMarcador.add(temporal2).setBounds(0, 25, this.getWidth(), 25);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();
        if (e.getSource() == this.stop) {
            boolean selected = abstractButton.getModel().isSelected();
            if (selected) {
                estado_anterior_al_stop = pelota.getEstado();
                pelota.setEstado(pelota.PELOTA_STOP);
            } else {
                pelota.setEstado(estado_anterior_al_stop);
            }
        } else if (e.getSource() == reiniciar) {
            this.jugador1.setPuntuacion(0);
            this.jugador2.setPuntuacion(0);
            pelota.reiniciar();
            letreroMarcador.removeAll();
            marcadorT.reiniciar();
            JLabel temporal = new JLabel(marcador.marcador(0, 0));
            JLabel temporal2 = new JLabel("0:0");
            temporal.setHorizontalAlignment(JLabel.CENTER);
            temporal2.setHorizontalAlignment(JLabel.CENTER);
            letreroMarcador.setOpaque(false);
            letreroMarcador.add(temporal).setBounds(0, 0, this.getWidth(), 25);
            letreroMarcador.add(temporal2).setBounds(0, 25, this.getWidth(), 25);
        }
    }
}
