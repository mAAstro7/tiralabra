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
    //most used round
    private String mostUsed;
    //most used moves % of all moves
    private double mUshareOfMoves;
    //least used move;
    private String leastUsed;
    //least used move % of all moves;
    private double lEshareOfMoves;
    private String move;

    /**
     * Luo uuden AI:n ja littaa siirrot k,p ja s char taulukkoon tätä ei vielä
     * käytetä
     */
    public AI() {

    }

    /**
     * Hakee tekoälyn seuraavan siirron eli algoritmeja käyttäen
     *
     * @param round viimeisin kierros
     * @return valittu siirto
     */
    public String getMove(Round round) {
        this.round = round;
        if (getCount() > 2) {
            if (isThereStreak()) {
                mostUsed = round.getPlayer1Move();
                getCounterMove();
            } else {
                countMostUsed();
                //jos vihu on käyttänyt yli 65% samaa siirtoa, pelataan tätä vastaan
                if (mUshareOfMoves > 65) {
                    getCounterMove();
                } else {
                    countLeastUsed();
                    if (lEshareOfMoves < 25) {
                        getSafestMove();
                    } else {
                        getRadnom();
                    }
                }
            }
        } else {

            //jos on pelattu alle neljä kierrosta, palautetaan siirto painotettuna randomina
            getRadnom();
        }
        return move;
    }

    /**
     * Tarkistetaan ovatko kolme viimeistä siirtoa olleet samat
     */
    public boolean isThereStreak() {
        Round helpRound = this.round;
        String move = helpRound.getPlayer1Move();
            helpRound = helpRound.getPrev();
            if (!move.contains(helpRound.getPlayer1Move())) {
                return false;
        }
        return true;
    }

    /**
     * Palautetaan painotettu random (kivellä voittaa aina)
     */
    public void getRadnom() {
        Random random = new Random();
        int luku = random.nextInt(100);
        int kivi = 40;
        int sakset = kivi + 35;
        System.out.println(luku);
        if (luku > kivi) {
            if (luku > sakset) {
                move = "p";
            } else {
                move = "s";
            }
        } else {
            move = "k";
        }

    }

    /**
     * Hakee siirron joka voittaa vastustajan eniten käyttämän siirron
     */
    public void getCounterMove() {
        if (mostUsed.contains("s")) {
            move = "k";
        } else if (mostUsed.contains("k")) {
            move = "p";
        } else {
            move = "s";
        }
    }

    public void getSafestMove() {
        if (leastUsed.contains("s")) {
            move = "p";
        } else if (leastUsed.contains("k")) {
            move = "s";
        } else {
            move = "k";
        }
    }

    /**
     * lasketaan vastustajan vähiten käytetty siirto ja sen käyttö %
     */
    public void countLeastUsed() {
        int s = 0;
        int k = 0;
        int p = 0;

        Round helpRound = this.round;
        while (helpRound != null) {
            if (helpRound.getPlayer1Move().contains("s")) {
                s++;
            } else if (helpRound.getPlayer1Move().contains("k")) {
                k++;
            } else {
                p++;
            }
            helpRound = helpRound.getPrev();
        }

        if (s < k) {
            if (s > p) {
                leastUsed = "p";
                lEshareOfMoves = (double) p / (double) (k + p + s) * 100;
            } else {
                leastUsed = "s";
                lEshareOfMoves = (double) s / (double) (s + k + p) * 100;
            }
        } else if (k < p) {
            leastUsed = "k";
            lEshareOfMoves = (double) k / (double) (s + p + k) * 100;
        } else {
            leastUsed = "p";
            lEshareOfMoves = (double) p / (double) (s + k + p) * 100;
        }

    }

    /**
     * lasketaan vastustajan eniten käytetty siirto ja sen käyttö %
     */
    public void countMostUsed() {
        Round helpRound = this.round;
        int s = 0;
        int k = 0;
        int p = 0;

        while (helpRound != null) {
            if (helpRound.getPlayer1Move().contains("s")) {
                s++;
            } else if (helpRound.getPlayer1Move().contains("k")) {
                k++;
            } else {
                p++;
            }
            helpRound = helpRound.getPrev();
        }

        //lasketaan eniten käytetyn siirron % osuus kaikista siirroista
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

    public String getLeastUsed() {
        return leastUsed;
    }

    public double getlEshareOfMoves() {
        return lEshareOfMoves;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public String getMove4Test() {
        return this.move;
    }

}
