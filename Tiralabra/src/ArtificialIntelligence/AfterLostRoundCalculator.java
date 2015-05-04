/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtificialIntelligence;

import Game.Round;

/**
 * Luokan tehtävä on muistaa vaihtoiko pelaaja/ eikö vaihtanut siirtoa hävityn
 * kierroksen jälkeen
 *
 * @author Jomppa
 */
public class AfterLostRoundCalculator {

    private Round lastRound;
    private int change = 1;
    private int didntchange = 1;
    
    public AfterLostRoundCalculator() {
        lastRound = null;
    }

    /**
     * Metodi tarkastaa onko pelaaja hävinnyt viimeisen kierroksen Jos on
     * tarkastetaan seuraava siirto ja katsotaan vaihtaako pelaaja siirtoa
     *
     * @param round uusi round olio
     */
    public void update(Round round) {
        if (lastRound == null) {
            lastRound = round;
        } else {
            if (lastRound.getWhathappend()) {
                System.out.println("tännevaaa");
                if (lastRound.getPlayer1Move().contains(round.getPlayer1Move())) {
                    didntchange++;
                    System.out.println("tännasdasdsadsevaaa");
                } else {
                    change++;
                }
            }

            lastRound = round;
        }
    }

    /**
     * Palautetaan todennäköisyys sille että pelaaja vaihtaa siirtoa hävityn
     * kierroksen jälkeen
     * @return probofchance todennäköisyys vaihdolle
     */
    public double chanceOfChange() {
        double probofchange = ((double)change / (change + didntchange)) *100;
        System.out.println(probofchange);
        return probofchange;
    }
    
    public boolean didP1LostLastRound() {
        if(lastRound != null) {
            return lastRound.getWhathappend();
        } else {
            return false;
        }
        
    }
}
