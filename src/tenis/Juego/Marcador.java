/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.Juego;

import tenis.idioma.Idioma;

public class Marcador {

    public Idioma idioma;

    public Marcador(Idioma ideoma) {
        this.idioma = ideoma;
    }

    public String marcador(int puntos1, int puntos2) {
        if (puntos1 == 0 && puntos2 == 0) {
            return idioma.love() + ":" + idioma.all();
        } else if (puntos1 == 0 && puntos2 == 15) {
            return idioma.love() + ":" + idioma.fifteen();
        } else if (puntos1 == 0 && puntos2 == 30) {
            return idioma.love() + ":" + idioma.thirty();
        } else if (puntos1 == 0 && puntos2 == 40) {
            return idioma.love() + ":" + idioma.forty();
        } else if (puntos1 == 15 && puntos2 == 0) {
            return idioma.fifteen() + ":" + idioma.love();
        } else if (puntos1 == 30 && puntos2 == 0) {
            return idioma.thirty() + ":" + idioma.love();
        } else if (puntos1 == 40 && puntos2 == 0) {
            return idioma.forty() + ":" + idioma.love();
        } else if (puntos1 == 15 && puntos2 == 15) {
            return idioma.fifteen() + ":" + idioma.all();
        } else if (puntos1 == 30 && puntos2 == 30) {
            return idioma.thirty() + ":" + idioma.all();
        } else if (puntos1 == 15 && puntos2 == 30) {
            return idioma.fifteen() + "" + idioma.thirty();
        } else if (puntos1 == 15 && puntos2 == 40) {
            return idioma.fifteen() + "" + idioma.forty();
        } else if (puntos1 == 30 && puntos2 == 15) {
            return idioma.thirty() + "" + idioma.fifteen();
        } else if (puntos1 == 40 && puntos2 == 15) {
            return idioma.forty() + "" + idioma.fifteen();
        } else if (puntos1 == 30 && puntos2 == 40) {
            return idioma.thirty() + "" + idioma.forty();
        } else if (puntos1 == 40 && puntos2 == 30) {
            return idioma.forty() + "" + idioma.thirty();
        } else if (diferenciaDeTresJugador1(puntos1, puntos2)) {
            return idioma.player_1_win();
        }
        if (diferenciaDeTresJugador1(puntos2, puntos1)) {
            return idioma.player_2_win();
        }
        if (puntos1 == puntos2 && puntos1 >= 40) {
            return idioma.deuce();
        }
        if (puntos1 >= 40 && puntos2 >= 40 && puntos1 > puntos2) {
            return idioma.advantage_player_1();
        }
        if (puntos1 >= 40 && puntos2 >= 40 && puntos2 > puntos1) {
            return idioma.advantage_player_2();
        }
        return "";
    }

    private boolean diferenciaDeTresJugador1(int puntaje1, int puntaje2) {
        int puntos1;
        int puntos2;
        if (puntaje1 <= 30) {
            puntos1 = puntaje1 % 15;
        } else {
            puntos1 = ((puntaje1 - 30) % 10 + 2);
        }
        if (puntaje2 <= 30) {
            puntos2 = puntaje1 % 15;
        } else {
            puntos2 = ((puntaje2 - 30) % 10 + 2);
        }
        System.out.println(puntos1+"  "+puntos2);
        if (puntos1 - puntos2 == 2) {
            return true;
        }
        return false;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}
