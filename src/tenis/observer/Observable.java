/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.observer;

import java.util.LinkedList;
import java.util.List;


public interface Observable {
    
    /**
     *
     */
    public List<Observador> observadores =new LinkedList<>();
    
    public void notificar();
    
    public void agregarObservador(Observador o);
    
    public void removerObservador(Observador o);
    
    
    
    
}
