/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.idioma;


public class Frances extends Idioma {
//        String [] idiomaFrances= {"Amour","Quinze","Trente","Quarante","Victoires de player 1","Victoires de player 2","Tirer","Avantage player 1","Avantage player 2","Égal"} ;

    @Override
    public String all() {
        return "Tirer";
    }

    @Override
    public String love() {
        return "Amour";
    }

    @Override
    public String fifteen() {
        return "Quinze";
    }

    @Override
    public String thirty() {
        return "Trente";
    }

    @Override
    public String forty() {
        return "Quarante";
    }

    @Override
    public String player_1_win() {
        return "Victoires de player 1";
    }

    @Override
    public String player_2_win() {

        return "Victoires de player 2";
    }

    @Override
    public String deuce() {
        return "Égal";
    }

    @Override
    public String advantage_player_1() {
        return "Avantage player 1";
    }

    @Override
    public String advantage_player_2() {
        return "Avantage player 2";

    }
}
