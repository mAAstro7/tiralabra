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

            assertFalse("".contains(move));
        } else {
            assertFalse("I didnt make k, p or s :(", move.contains(""));
        }
    }

    @Test
    public void isMostUsedWorking() {
        Round round = new Round("k", "s", false);
        Round round2 = new Round("k", "p", false);
        Round round3 = new Round("k", "k", false);
        Round round4 = new Round("k", "p", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        RR.addRound(round4);
        ai.getMove(RR.getLastRound());
        Assert.assertEquals("k", ai.getMostUsed() );
    }
    
        @Test
    public void isMostUsedShareOfMovesCorrect() {
        Round round = new Round("k", "s", false);
        Round round2 = new Round("k", "p", false);
        Round round3 = new Round("k", "k", false);
        Round round4 = new Round("s", "p", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        RR.addRound(round4);
        ai.getMove(RR.getLastRound());
        Assert.assertEquals(75, (int)ai.getmUshareOfMoves());
    }
    
            @Test
    public void iShouldGetP() {
        Round round = new Round("k", "s", false);
        Round round2 = new Round("k", "p", false);
        Round round3 = new Round("k", "k", false);
        Round round4 = new Round("k", "p", false);
        Round round5 = new Round("k", "p", false);
        RR.addRound(round);
        RR.addRound(round2);
        RR.addRound(round3);
        RR.addRound(round4);
        RR.addRound(round5);
        ai.getMove(RR.getLastRound());
        Assert.assertEquals("p", ai.getMove(RR.getLastRound()));
    }
}
