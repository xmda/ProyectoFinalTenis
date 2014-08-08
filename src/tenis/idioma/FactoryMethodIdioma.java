/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.idioma;

public class FactoryMethodIdioma {

    public static Idioma creaIdioma(String nombre) {

        switch (nombre) {
            case "Español":
                return new Español();
            case "Ingles":
                return new Ingles();
            case "Aleman":
                return new Aleman();
            case "Frances":
                return new Frances();
        }
        return new Ingles();
    }
}
