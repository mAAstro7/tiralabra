/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtificialIntelligence;

import Game.Round;
import Game.RoundRemember;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Jomppa
 */
public class AITest {

    private AI ai = new AI();
    private RoundRemember RR = new RoundRemember();

    public AITest() {

    }

    /**
     * Testataan valitseeko tekoäly siirroksi k, p tai s
     */
    @Test
    public void canAIMakeMoveK() {
        Round round = new Round();
        String move = ai.getMove(round) + "";
        if (move.equals("k") || move.equals("s") || move.equals("p")) {

            assertFalse("I didnt make k, p or s :(", "".contains(move));
        } else {
            assertFalse("I didnt make k, p or s :(", move.contains(""));
        }
    }

    @Test
    public void isMostUsedWorking() {

        for (int i = 0; i < 4; i++) {
            Round round = new Round("k", "s", false);
            RR.addRound(round);
        }
        ai.setRound(RR.getLastRound());
        ai.countMostUsed();
        Assert.assertEquals("k", ai.getMostUsed());
    }

    @Test
    public void isMostUsedShareOfMovesCorrect() {
        for (int i = 0; i < 3; i++) {
            Round round = new Round("k", "s", false);
            RR.addRound(round);
        }
        Round round4 = new Round("s", "p", false);
        RR.addRound(round4);
        ai.setRound(RR.getLastRound());
        ai.countMostUsed();
        Assert.assertEquals(75, (int) ai.getmUshareOfMoves());
    }

    @Test
    public void isCounterMoveWorking() {
        for (int i = 0; i < 6; i++) {
            Round round = new Round("k", "s", false);
            RR.addRound(round);
        }
        ai.setRound(RR.getLastRound());
        ai.countMostUsed();
        ai.getCounterMove();
        Assert.assertEquals("p", ai.getMove4Test());
    }

    @Test
    public void isLeastUsedWorking() {
        Round round = new Round("k", "s", false);
        RR.addRound(round);
        for (int i = 0; i < 6; i++) {
            round = new Round("s", "s", false);
            RR.addRound(round);
        }
        for (int i = 0; i < 3; i++) {
            round = new Round("p", "s", false);
            RR.addRound(round);
        }
        ai.setRound(round);
        ai.countLeastUsed();
        Assert.assertEquals("k", ai.getLeastUsed());
    }

    @Test
    public void isShareOfLeastUsedWorking() {
        Round round = new Round("k", "s", false);
        RR.addRound(round);
        for (int i = 0; i < 6; i++) {
            round = new Round("s", "s", false);
            RR.addRound(round);
        }
        for (int i = 0; i < 3; i++) {
            round = new Round("p", "s", false);
            RR.addRound(round);
        }
        ai.setRound(round);
        ai.countLeastUsed();
        Assert.assertEquals(10, (int) ai.getlEshareOfMoves());
    }

    @Test
    public void isSafestMoveWorking() {
        for (int i = 0; i < 6; i++) {
            Round round = new Round("k", "s", false);
            RR.addRound(round);
        }
        for (int i = 0; i < 3; i++) {
            Round round = new Round("s", "s", false);
            RR.addRound(round);
        }
        ai.setRound(RR.getLastRound());
        ai.countLeastUsed();
        ai.getSafestMove();
        Assert.assertEquals("k", ai.getMove4Test());
    }

    @Test
    public void isThereStreakWorking() {
        Round round = null;
        for (int i = 0; i < 6; i++) {
            round = new Round("s", "s", false);
            RR.addRound(round);
        }
        ai.setRound(round);
        Assert.assertEquals(true, ai.isThereStreak());
    }

    @Test
    public void isThereStreakWorking2() {
        Round round = null;
        for (int i = 0; i < 3; i++) {
            round = new Round("s", "s", false);
            RR.addRound(round);
        }
        round = new Round("p", "s", false);
        RR.addRound(round);
        round = new Round("s", "s", false);
        RR.addRound(round);
        ai.setRound(round);
        Assert.assertEquals(false, ai.isThereStreak());
    }

    @Test
    public void doAINoticeStreak() {
        Round round = null;
        for (int i = 0; i < 6; i++) {
            round = new Round("s", "s", false);
            RR.addRound(round);
        }
        for (int i = 0; i < 3; i++) {
            round = new Round("p", "s", false);
            RR.addRound(round);
        }
        Assert.assertEquals("s", ai.getMove(RR.getLastRound()));
    }

    @Test
    public void countStreakisWorking() {
        Round round = null;

        round = new Round("s", "s", false);
        RR.addRound(round);

        for (int i = 0; i < 3; i++) {
            round = new Round("p", "s", false);
            RR.addRound(round);
        }
        ai.setRound(RR.getLastRound());
        Assert.assertEquals(3, ai.countStreak());
    }

}
