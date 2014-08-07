/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.idioma;

public class FactoryMethodIdioma {

    public static Idioma creaIdeoma(String nombre) {

        switch (nombre) {
            case "Español":
                return new Español();
            case "Ingles":
                return new Ingles();
        }
        return new Español();
    }
}
