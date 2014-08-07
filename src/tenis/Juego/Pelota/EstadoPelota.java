/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego.Pelota;

public abstract class EstadoPelota {

    public Pelota pelota;

    public EstadoPelota(Pelota pelota) {
        this.pelota = pelota;
    }

    public abstract void rebotar();

    public abstract void mover();

    public abstract void parar();
}
