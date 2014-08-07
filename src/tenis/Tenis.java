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
        j.setJugador1("Yo");
        j.setJugador2("Tu");
        j.setIdioma(new Ingles());
        j.iniciarJuego();
        
//        Marcador m=new Marcador(new Ingles());
//        System.out.println(m.marcador(0, 0)); 
//        System.out.println(m.marcador(15,30)); 
//        System.out.println(m.marcador(40, 30)); 
//        System.out.println(m.marcador(50, 40)); 
//        System.out.println(m.marcador(60, 40)); 
//        System.out.println(m.marcador(70, 40)); 
//        System.out.println(m.marcador(40, 40)); 
//        System.out.println(m.marcador(15, 60)); 
       
    }
}
