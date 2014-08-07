/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego.Pelota;

/**
 *
 * @author Yannik Gonzalez A
 */
public class PelotaAFuera extends EstadoPelota{

    public PelotaAFuera(Pelota pelota) {
        super(pelota);
    }

    
    @Override
    public void rebotar() {
        
    }

    @Override
    public void mover() {
        pelota.reiniciar();
    }

    @Override
    public void parar() {
        
    }
    
}
