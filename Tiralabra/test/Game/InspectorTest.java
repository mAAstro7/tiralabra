/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Inspector;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Jomppa
 */
public class InspectorTest {

    private Inspector inspa = new Inspector();

    public InspectorTest() {

    }

    /**
     * Testataan toimiiko PaperOverRock metodi
     */
    @Test
    public void doesPaperWinRock() {
        assertEquals(true, inspa.PaperOverRock("p", "k"));
    }

    /**
    * Testataan toimiiko RockOverScissors metodi
     */
    @Test
    public void doesRockWinScissors() {
        assertEquals(true, inspa.RockOverScissors("k", "s"));
    }

    /**
     * Testataan toimiiko ScissorsOverPaper metodi
     */
    @Test
    public void doesScissorsWinPaper() {
        assertEquals(true, inspa.ScissorsOverPaper("s", "p"));
    }
    
    /**
     * Testataan toimiiko didAIwin metodi
     */
    @Test
    public void doesAIreallyWin() {
        assertEquals(true, inspa.didAIwin("p", "s"));
    }
}
