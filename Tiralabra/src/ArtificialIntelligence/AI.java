
package ArtificialIntelligence;

import Game.Round;
import java.util.Random;



/**
 * Luokka tekoälylle
 * @author joonatan
 */
 
public class AI {
    
private Round[] rounds;

/**
 * Luo uuden AI:n ja littaa siirrot k,p ja s char taulukkoon
 * tätä ei vielä käytetä
 */
   public AI(){

   }
   
   public void addRound (Round round) {
   
   }
   
   
  
 /**
 * Hakee tekoälyn seuraavan siirron
 * Toimii vielä tällä hetkellä randomina
     * @return valittu siirto
 */ 
   public String getMove() {
       Random random = new Random();
       int luku = random.nextInt(100);
       int kivi = 33;
       int sakset = kivi+33;
       if (luku>kivi) {
           if (luku > sakset) {
               return "p";
           }
           return "s";
       }
       return "k";
   }
    
}
