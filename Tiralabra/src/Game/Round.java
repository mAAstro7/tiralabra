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
    //pitää sisällään tiedon round olion indexistä
    private int index;
    //edellinen siirto
    private Round prev = null;
    //seuraava siirto
    private Round next = null;

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

    public String getPlayer1Move() {
        return player1Move;
    }

    public void setPlayer1Move(String player1Moves) {
        this.player1Move = player1Moves;
    }

    public String getAIMove() {
        return AIMove;
    }

    public void setAIMove(String AIMoves) {
        this.AIMove = AIMoves;
    }

    public boolean getWhathappend() {
        return didAIWin;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
