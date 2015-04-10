/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 * Luokka voittaja tarkistukseen
 *
 * @author Jomppa
 */
public class Inspector {

    public Inspector() {

    }

    /**
     * Tarkistaa kumpi siirroista voittaa.
     *
     * @param p1 player1 siirto
     * @param p2 player2 siirto
     * @return true/false sen perusteella voittiko tekoäly
     */
    public boolean didAIwin(String p1, String AI) {
        if (PaperOverRock(AI, p1)) {
            return true;
        } else if (ScissorsOverPaper(AI, p1)) {
            return false;
        } else if (RockOverScissors(AI, p1)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Tarkistaa kumpi siirroista voittaa.
     *
     * @param m1 move yksi
     * @param m2 move kaksi
     * @return true jos siirto yksi on paperi ja kaksi kivi
     */
    public boolean PaperOverRock(String m1, String m2) {
        if (m1.contains("r") && m2.contains("p")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tarkistaa kumpi siirroista voittaa.
     *
     * @param m1 move yksi
     * @param m2 move kaksi
     * @return true jos siirto yksi on sakset ja kaksi paperi
     *
     */
    public boolean ScissorsOverPaper(String m1, String m2) {
        if (m1.contains("s") && m2.contains("p")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tarkistaa kumpi siirroista voittaa.
     *
     * @param m1 move yksi
     * @param m2 move kaksi
     * @return true jos siirto yksi on kivi ja kaksi sakset
     *
     */
    public boolean RockOverScissors(String m1, String m2) {
        if (m1.contains("r") && m2.contains("s")) {
            return true;
        } else {
            return false;
        }

    }
}
