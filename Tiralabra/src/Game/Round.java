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
    private boolean didAIWin;

    //edellinen siirto
    private Round prev;
    //seuraava siirto
    private Round next;

    public Round() {

    }

    public Round(String m1, String m2, boolean didBotWin) {
        this.player1Move = m1;
        this.AIMove = m2;
        this.didAIWin = didBotWin;
    }

    public Round getPrev() {
        return prev;
    }

    public void setPrev(Round prev) {
        this.prev = prev;
    }

    public Round getNext() {
        return next;
    }

    public void setNext(Round next) {
        this.next = next;
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

    public boolean getWhathappend() {
        return didAIWin;
    }

    public void setWhathappend(boolean didaiwin) {
        this.didAIWin = didaiwin;
    }

    //testailuun
    @Override
    public String toString() {
        return "this is ROOOUUUNDDD!!";
    }

}
