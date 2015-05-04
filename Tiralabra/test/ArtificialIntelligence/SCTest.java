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
 * Luokka StreakCalculatorin testaamiseen
 * Testit toimiiko tod.näk. putken jatkumiselle
 * @author Jomppa
 */
public class SCTest {

    private StreakCalculator SC = new StreakCalculator();

    public SCTest() {

    }

    @Test
    public void isAfterTwoWorking() {
        for (int i = 0; i < 4; i++) {
            SC.increaseDouble();
        }
        SC.increaseDoubleCount();
        Assert.assertEquals(80, (int) SC.getAfterTwo());
    }

    @Test
    public void isAfterThreeWorking() {
        for (int i = 0; i < 4; i++) {
            SC.increaseTreble();
        }
        SC.increaseTrebleCount();
        Assert.assertEquals(80, (int) SC.getAfterThree());
    }

    @Test
    public void isAfterFourWorking() {
        for (int i = 0; i < 3; i++) {
            SC.increaseFour();
        }
        SC.increaseFourCount();
        Assert.assertEquals(75, (int) SC.getAfterFour());
    }

    @Test
    public void probabilityCorrect() {
        Assert.assertEquals(100, (int) SC.getProbForSameNext(6));
    }
}
