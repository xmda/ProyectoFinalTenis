/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

public class Jugador {

    private String nombre;
    private int puntuacion;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void anotar() {
        if (puntuacion < 30) {
            puntuacion += 15;
        } else {
            puntuacion += 10;
        }
    }
}
