package ArtificialIntelligence;

import Game.Round;
import java.util.Random;

/**
 * Luokka tekoälylle
 *
 * @author joonatan
 */
public class AI {

    private Round round;

    private String mostUsed;
    //most used moves % of all moves
    private double mUshareOfMoves;

    /**
     * Luo uuden AI:n ja littaa siirrot k,p ja s char taulukkoon tätä ei vielä
     * käytetä
     */
    public AI() {

    }

    /**
     * Hakee tekoälyn seuraavan siirron Toimii vielä tällä hetkellä randomina
     *
     * @param round viimeisin kierros
     * @return valittu siirto
     */
    public String getMove(Round round) {
        this.round = round;
        //jos haetaan ensimmäisiä siirto, palautetaan painotettuna randomina

        if (getCount() > 3) {
            countMostUsed();
            if (mUshareOfMoves > 65) {
                if (mostUsed.contains("s")) {
                    return "k";
                } else if (mostUsed.contains("k")) {
                    return "p";
                } else {
                    return "s";
                }
            }

        } else {
            Random random = new Random();
            int luku = random.nextInt(100);
            int kivi = 50;
            int sakset = kivi + 25;
            if (luku > kivi) {
                if (luku > sakset) {
                    return "p";
                }
                return "s";
            }
            return "k";
        }

        return "k";
    }

    /**
     * @return vastustajan eniten käyttämä siirto, tasa määriä ei tarvitse
     * huomioida
     */
    public void countMostUsed() {
        Round r = this.round;
        int s = 0;
        int k = 0;
        int p = 0;

        while (r != null) {
            if (r.getPlayer1Move().contains("s")) {
                s++;
            } else if (r.getPlayer1Move().contains("k")) {
                k++;
            } else {
                p++;
            }
            r = r.getPrev();
        }
        
        

        if (s > k) {
            if (s > p) {
                mostUsed = "s";
                mUshareOfMoves = (double) s / (double) (k + p + s) * 100;
            } else {
                mostUsed = "p";
                mUshareOfMoves = (double) p / (double) (s + k + p) * 100;
            }
        } else if (k > p) {
            mostUsed = "k";
            mUshareOfMoves = (double) k / (double) (s + p + k) * 100;
        } else {
            mostUsed = "p";
            mUshareOfMoves = (double) p / (double) (s + k + p) * 100;
        }

    }

    /**
     * @return kierrosten lukumäärä
     */
    public int getCount() {
        int count = 0;
        Round r = this.round;
        if (r == null) {
            return count;
        } else {
            count++;
            while (r.getPrev() != null) {
                count++;
                r = r.getPrev();
            }
            return count;
        }
    }
    
    //getterit luotu testausta huomioiden

    public String getMostUsed() {
        return mostUsed;
    }

    public double getmUshareOfMoves() {
        return mUshareOfMoves;
    }

}
