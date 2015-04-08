/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 * Luokka voittaja tarkistukseen
 * @author Jomppa
 */
public class Inspector {
    
    public Inspector() {
        
    }
    
/**
 * Tarkistaa kömpelösti (atm) kumpi siirroista voittaa.
 * @param p1 player1 siirto
 * @param p2 player2 siirto
     * @return p1 tai p2, riippuen kumpi voittaa
 */
    public String checkWhoWins(String p1, String p2) {
        if (p1.contains(p2)) {
            return "t";
        } else if (p1.equals("k")) {
            if (p2.equals("s")) {
                return "p1";
            } else {
                return "p2";
            }
        }
            else if (p1.equals("s")) {
                if (p2.equals("p")) {
                return "p1";
            } else {
                return "p2";
            }      
        } else if (p1.equals("p")) {
                if (p2.equals("k")) {
                return "p1";
            } else {
                return "p2";
                }
    } else {
            return null;
        }
}
}
