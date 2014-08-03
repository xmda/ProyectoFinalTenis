/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import java.awt.Color;
import javax.swing.JFrame;

public class Campo extends JFrame {

    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Marcador marcador;
    private final Pelota pelota;
    private final Raqueta raquetaJugador1;
    private final Raqueta raquetaJugador2;

    public Campo(Jugador jugador1, Jugador jugador2, Marcador marcador) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.marcador = marcador;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        setLayout(null);
        setSize(800, 600);
        pelota=new Pelota(this);
        this.add(pelota).setBounds(0, 0, 30, 30);
        raquetaJugador1=new Raqueta();
        raquetaJugador2=new Raqueta();
        raquetaJugador1.setFocusable(true);
        raquetaJugador2.setFocusable(true);
        this.add(raquetaJugador1).setBounds(0,0,50,200);
        this.add(raquetaJugador2).setBounds(this.getWidth()-60,0,50,200);
        this.setBackground(Color.GREEN);
    }
    
    public void lanzarPelota(){
        pelota.start();
    }
}
