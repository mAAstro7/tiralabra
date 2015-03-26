/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtificialIntelligence;

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
    
    public AITest() {
        
    }
 /**
 * Testataan valitseeko tekoäly siirroksi k, p tai s
 */
        @Test
    public void canAIMakeMoveK() {
    String move = ai.getMove()+"";
    if (move.equals("k") || move.equals("s") || move.equals("p")) {

       assertFalse("".contains(move));
    } else {
        assertFalse("I didnt make k, p or s :(", move.contains(""));
    }
      
    }
}
