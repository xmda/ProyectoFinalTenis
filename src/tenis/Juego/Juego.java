/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import tenis.idioma.Español;
import tenis.idioma.Idioma;
import tenis.idioma.Ingles;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;
    private Marcador marcador;
    private Idioma idioma;
    private InterfazGrafica campo;
    private Idioma[] idiomasDisponibles = new Idioma[]{new Español(), new Ingles()};

    public Juego() {
    }

    public Juego(String nombreJugador1, String nombreJugador2, Idioma i) {
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);
        marcador = new Marcador(i);
        idioma = i;
        campo = new InterfazGrafica(jugador1, jugador2, marcador);
    }

    public void iniciarJuego() {
        if(campo==null)
          campo = new InterfazGrafica(jugador1, jugador2, marcador);
        campo.setVisible(true);
        campo.lanzarPelota();
    }

    public Idioma[] getIdiomasDisponibles() {
        return idiomasDisponibles;
    }

    public void setIdiomasDisponibles(Idioma[] idiomasDisponibles) {
        this.idiomasDisponibles = idiomasDisponibles;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 =new Jugador(jugador1);
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = new Jugador(jugador2);
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
        if(marcador==null)
            marcador=new Marcador(idioma);
        else
            marcador.setIdioma(idioma);
    }

    public String getMarcador() {
        return marcador.marcador(jugador1.getPuntuacion(),jugador2.getPuntuacion());
    }
    
}
