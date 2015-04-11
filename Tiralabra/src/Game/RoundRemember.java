/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * Tietorakenne kierroksien taltiointiin, kaksisuuntainen linkitetty lista Tämä
 * luokka muistaa edellisen kierroksen ja on vaihtoehtoinen tapa toteuttaa
 * linkitetty lista ilman taulukkoa
 */
public class RoundRemember {

    private Round lastRound;

    public RoundRemember() {
        this.lastRound = null;
    }

    public Round getLastRound() {
        return lastRound;
    }

    public void setLastRound(Round lastRound) {
        this.lastRound = lastRound;
    }
}
