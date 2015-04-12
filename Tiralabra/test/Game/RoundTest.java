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
public class RoundTest {

    private Round round = new Round();

    public RoundTest() {

    }

    @Test
    public void canIGetp1Move() {
        round.setPlayer1Move("s");
        Assert.assertEquals("s", round.getPlayer1Move());
    }

    @Test
    public void canIGetAIMove() {
        round.setAIMove("k");
        Assert.assertEquals("k", round.getAIMove());
    }

    @Test
    public void canUTellDidAiwin() {
        round.setWhathappend(true);
        Assert.assertEquals(true, round.getWhathappend());
    }

    @Test
    public void canIgetPrevRound() {
        Round roundi = new Round();
        roundi.setPrev(round);
        Assert.assertEquals(round, roundi.getPrev());
    }

    @Test
    public void canIgetNextRound() {
        Round roundi = new Round();
        round.setNext(roundi);
        Assert.assertEquals(roundi, round.getNext());
    }

    public void canIGetPrevandNextRound() {
        Round nextR = new Round();
        Round prevR = new Round();
        round.setNext(nextR);
        nextR.setPrev(prevR);
        Assert.assertEquals(nextR, round.getNext());
        Assert.assertEquals(prevR, nextR.getPrev());
    }

}
