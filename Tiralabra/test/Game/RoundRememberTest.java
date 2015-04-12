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
    public void canIGetLastRound () {
        Round round = new Round("s", "s", false);
        RR.setLastRound(round);
        Assert.assertEquals(round, RR.getLastRound());
      
    }
    
}
