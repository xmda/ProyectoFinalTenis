/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.idioma;

public abstract class Idioma {

    public abstract String all();

    public abstract String love();

    public abstract String fifteen();

    public abstract String thirty();

    public abstract String forty();

    public abstract String player_1_win();

    public abstract String player_2_win();

    public abstract String deuce();

    public abstract String advantage_player_1();

    public abstract String advantage_player_2();

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
