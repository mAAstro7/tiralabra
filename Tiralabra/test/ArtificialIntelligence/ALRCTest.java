/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtificialIntelligence;

import Game.Round;
import org.junit.Assert;
import org.junit.Test;

/**
 * Luokka AfterLostRoundCalculator testaamiseen
 *
 * @author Jomppa
 */
public class ALRCTest {
    private AfterLostRoundCalculator ALRC = new AfterLostRoundCalculator();
    
    public ALRCTest() {

    }

 /**
 * Testi testaamaan tunnistetaanko tod.näk. että p1 vaihtaa siirtoa hävityn kierroksen jälkeen
 *
 */
    @Test
    public void isAfterTwoWorking() {
        for (int i = 0; i < 4; i++) {
            Round round = new Round("k", "s", true);
            ALRC.update(round);
        }
        Assert.assertEquals(20, (int)ALRC.chanceOfChange());
    }
    
        @Test
    public void isDidp1qWonworking() {
 
            Round round = new Round("k", "s", true);
            ALRC.update(round);
        
        Assert.assertEquals(true, ALRC.didP1LostLastRound());
    }
}
