/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * Luokka yhden kierroksen taltiointii.
 */
public class Round {
    
    //pitää sisällään pelaajan siirron
    private String player1Move;
    //pitää sisällään tekoälyn siirron
    private String AIMove;
    //pitää sisällään tiedon kumpi voitti (voitto = AI voittaa)
    private String whatHappend;
    
    public Round(){
        
    }
    public Round(String m1, String m2) {
        
    }

    public String getPlayer1Moves() {
        return player1Move;
    }

    public void setPlayer1Moves(String player1Moves) {
        this.player1Move = player1Moves;
    }

    public String getAIMoves() {
        return AIMove;
    }

    public void setAIMoves(String AIMoves) {
        this.AIMove = AIMoves;
    }

    public String getWhathappend() {
        return whatHappend;
    }

    public void setWhathappend(String whathappend) {
        this.whatHappend = whathappend;
    }
    
    @Override
    public String toString() {
        return "this is ROOOUUUNDDD!!";
    }

}
