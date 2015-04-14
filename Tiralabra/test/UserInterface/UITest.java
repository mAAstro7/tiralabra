/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Jomppa
 */
public class UITest {

    private UI ui = new UI();

    public UITest() {       
        
    }
    
    @Test
    public void isMyMoveCorrect() {
        assertEquals(true, ui.correctMove("k"));
    }
    
        @Test
    public void isMyMoveBad() {
        assertEquals(false, ui.correctMove("y"));
    }
    
            @Test
    public void canIStop() {
        assertEquals(true, ui.letsStop("stop"));
    }
}


