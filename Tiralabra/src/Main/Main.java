package Main;

import Game.Round;
import Game.RoundList;
import UserInterface.UI;

/**
 *
 * @author joonatan
 */

//HELP taulukoille http://ideone.com/8BV9zR
public class Main {

    public static void main(String[] args) {
//        UI kayttoliittyma = new UI();
//        kayttoliittyma.run();
        RoundList testi = new RoundList();
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
