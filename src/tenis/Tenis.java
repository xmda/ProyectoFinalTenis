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
        j.setJugador1("Felix");
        j.setJugador2("Felix");
        j.setIdioma(new Ingles());
        j.iniciarJuego();
    }
}
