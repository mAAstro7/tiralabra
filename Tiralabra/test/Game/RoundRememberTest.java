/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jomppa
 */
public class RoundRememberTest {

    private RoundRemember RR = new RoundRemember();

    public RoundRememberTest() {

    }

    @Test
    public void canIGetLastRound() {
        Round round = new Round("s", "s", false);
        RR.setLastRound(round);
        Assert.assertEquals(round, RR.getLastRound());

    }

    @Test
    public void isIndexWorking() {
        Round round = new Round("s", "s", false);
        Round round2 = new Round("k", "k", false);
        Round round3 = new Round("r", "r", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        Assert.assertEquals(2, RR.getLastRound().getIndex());
    }

    @Test
    public void isIndexWorkingAfterRoundDelete() {
        Round round = new Round("s", "s", false);
        Round round2 = new Round("k", "k", false);
        Round round3 = new Round("r", "r", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        RR.deleteRoundInIndex(1);
        Assert.assertEquals(1, RR.getLastRound().getIndex());
    }

    @Test
    public void isPrevRoundCorrectAfterDelete() {
        Round round = new Round("s", "s", false);
        Round round2 = new Round("k", "k", false);
        Round round3 = new Round("r", "r", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        //poistetaan siis round2
        RR.deleteRoundInIndex(1);
        Assert.assertEquals(round, round3.getPrev());
    }

    @Test
    public void isNextRoundCorrectAfterDelete() {
        Round round = new Round("s", "s", false);
        Round round2 = new Round("k", "k", false);
        Round round3 = new Round("r", "r", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        //poistetaan siis round2
        RR.deleteRoundInIndex(1);
        Assert.assertEquals(round3, round.getNext());
    }

    @Test
    public void CanIFindRoundByIndex() {
        Round round = new Round("s", "s", false);
        Round round2 = new Round("k", "k", false);
        Round round3 = new Round("r", "r", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        Round findedRound = RR.getRoundByIndex(0);
        Assert.assertEquals(round, findedRound);
    }

}
