/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego.Pelota;

public class PelotaMovimientoDerecha extends EstadoPelota {

    public PelotaMovimientoDerecha(Pelota pelota) {
        super(pelota);
    }

    /**
     *
     */
    @Override
    public void rebotar() {
    }

    @Override
    public void mover() {
        int x = pelota.getLocation().x;
        int y = pelota.getLocation().y;
        x += Math.abs(pelota.getIncrementoX());
        y += pelota.getIncrementoY();
        if (y > (pelota.getParent().getHeight() - pelota.getHeight()) && pelota.getIncrementoY()>=0) {
            pelota.setIncrementoY(pelota.getIncrementoY() * -1);
        } else if (y < 0 && pelota.getIncrementoY()<=0) {
            pelota.setIncrementoY(Math.abs(pelota.getIncrementoY()));
        }
        pelota.setLocation(x, y);
    }

    @Override
    public void parar() {
    }
}
