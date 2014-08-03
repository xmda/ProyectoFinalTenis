/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis;

import tenis.Juego.Juego;
import tenis.idioma.Ingles;


public class Tenis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego j=new Juego();
        j.setJugador1("Diony");
        j.setJugador2("Eli");
        j.setIdioma(new Ingles());
        j.iniciarJuego();
        System.out.println(j.getMarcador());
        j.getJugador1().anotar();
        System.out.println(j.getMarcador());
        j.getJugador1().anotar();
        System.out.println(j.getMarcador());
        j.getJugador1().anotar();
        System.out.println(j.getMarcador());
        j.getJugador1().anotar();
        System.out.println(j.getMarcador());
        j.getJugador1().anotar();
        System.out.println(j.getMarcador());
    }
}
