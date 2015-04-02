/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMove;

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
     * Testataan toimiiko p1 voiton selvitys
     */
    @Test
    public void doInspGetWinner() {
        assertEquals("p1", inspa.checkWhoWins("k", "s"));
    }

    /**
     * Testataan toimiiko p1 tasurin selvitys
     */
    @Test
    public void doInspGetTie() {
        assertEquals("t", inspa.checkWhoWins("s", "s"));
    }

    /**
     * Testataan toimiiko p1 häviön selvitys
     */
    @Test
    public void doInspGetLoser() {
        assertEquals("p2", inspa.checkWhoWins("s", "k"));
    }
}
