/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Jomppa
 */
public class PlayerTest {
    private Player p1 = new Player();
    
    public PlayerTest () {
        p1.setName("Matti");
        
    }
/**
 * Testataan toimiiko getName
 */
    @Test
    public void isNameRight() {
        assertEquals("Matti" , p1.getName());
    }
    
 /**
 * Testataan toimiiko pisteiden kasvatus
 */
   @Test
    public void pointsAreGrowing() {
        p1.addPoint();
        assertEquals(1 , p1.getPoints());
    }
}
