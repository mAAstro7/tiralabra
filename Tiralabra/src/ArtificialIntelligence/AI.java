
package ArtificialIntelligence;

import java.util.Random;



/**
 * Luokka tekoälylle
 * @author joonatan
 */
 
public class AI {
private char[] siirrot;


/**
 * Luo uuden AI:n ja littaa siirrot k,p ja s char taulukkoon
 */
   public AI(){
       this.siirrot = new char[]{'k', 'p', 's'};
   }
  
 /**
 * Hakee tekoälyn seuraavan siirron
 */ 
   public char getSiirto() {
       Random random = new Random();
       int luku = random.nextInt(100);
       int kivi = 33;
       int sakset = kivi+33;
       int papaeri = sakset+33;
       if (luku>kivi) {
           if (luku > sakset) {
               return 'p';
           }
           return 's';
       }
       return 'k';
   }
    
}
