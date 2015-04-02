
package Main;

import Game.Round;
import Game.RoundCollector;
import UserInterface.UI;

/**
 *
 * @author joonatan
 */
public class Main {

    

    public static void main(String[] args) {
//        UI kayttoliittyma = new UI();
//        kayttoliittyma.run();
        RoundCollector testi = new RoundCollector();
        testi.increaseSize();
        Round round = new Round();
        testi.put(round);
        System.out.println(testi.toString());
                testi.increaseSize();
        Round roundi = new Round();
                testi.put(roundi);
        System.out.println(testi.toString());
    }
    
}
