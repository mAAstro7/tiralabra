package ArtificialIntelligence;

import Game.Round;
import Game.RoundRemember;
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
    private RoundRemember RR;
    private StreakCalculator SC;
    private boolean lastRoundHadStreak;
    private int streakCount;
    private AfterLostRoundCalculator ALRC = new AfterLostRoundCalculator();

    /**
     * Luo uuden AI:n ja littaa siirrot k,p ja s char taulukkoon tätä ei vielä
     * käytetä
     */
    public AI() {
        SC = new StreakCalculator();
        RR = new RoundRemember();
        ALRC = new AfterLostRoundCalculator();
    }

    /**
     * Hakee tekoälyn seuraavan siirron eli algoritmeja käyttäen
     *
     * @param round viimeisin kierros
     * @return valittu siirto
     */
    public String getMove(Round round) {
        this.round = round;
        ALRC.update(round);

        if (ALRC.didP1LostLastRound()) {
            if (ALRC.chanceOfChange() > 74) {
                leastUsed = round.getPlayer1Move();
                getSafestMove();
            }
        } else {
            //tarkistetaan ollaanko pelattu yli kaksi kierrosta
            if (getCount() > 2) {
                //tarkistetaan oliko viime kierroksella putki
                if (lastRoundHadStreak) {
                    //jos oli tarkistetaan jatkuiko putki, jos ei jatkunut kasvatetaan laskuria
                    if (!isThereStreak()) {
                        if (streakCount == 4) {
                            SC.increaseFourCount();
                        } else if (streakCount == 3) {
                            SC.increaseTrebleCount();
                        } else if (streakCount == 2) {
                            SC.increaseDoubleCount();
                        }
                    }

                }
                //tarkistetaan onko putki alkanut (esim p1 valinnut kahdesti putkeen k)
                lastRoundHadStreak = isThereStreak();
                if (lastRoundHadStreak) {
                //jos putki on kestäny kaksi siirtoa, valitaan 
                    //turvallisen ja voittavan siirron väliltä randomina   
                    streakCount = countStreak();
                    if (streakCount < 3) {
                        if (SC.getAfterTwo() > 50) {
                            getCounterMove();
                        } else {
                            Random random = new Random();
                            int luku = random.nextInt(100);
                            System.out.println(luku);
                            if (luku > 75) {
                                mostUsed = round.getPlayer1Move();
                                getCounterMove();
                            } else {
                                move = round.getPlayer1Move();
                            }
                        }
                        //jos putki on yli kahden mittainen valitaan aina voittava siirto
                    } else {
                        mostUsed = round.getPlayer1Move();
                        double prob = SC.getProbForSameNext(streakCount);
                        if (prob > 55) {
                            getCounterMove();
                        } else {
                            getSafestMove();
                        }
                    }

                } else {
                    countMostUsed();
                    //jos vihu on käyttänyt yli 65% samaa siirtoa, pelataan tätä vastaan
                    if (mUshareOfMoves > 60) {
                        getCounterMove();
                    } else {
                        countLeastUsed();
                        if (lEshareOfMoves < 20) {
                            getSafestMove();
                        } else {
                            getRandom();
                        }
                    }
                }
            } else {

                //jos on pelattu alle neljä kierrosta, palautetaan siirto painotettuna randomina
                getRandom();
            }
        }
        return move;
    }

    /**
     * Tarkistetaan ovatko kolme viimeistä siirtoa olleet samat
     *
     * @return true/false
     */
    public boolean isThereStreak() {
        Round helpRound = this.round;
        String helpMove = helpRound.getPlayer1Move();
        helpRound = helpRound.getPrev();
        if (!helpMove.contains(helpRound.getPlayer1Move())) {
            return false;
        }
        return true;
    }

     /**
     * @return siirtojen "putken" lkm. esim k,k...k,k
     */
    public int countStreak() {
        Round helpRound = this.round;
        int streak = 0;
        String helpMove = helpRound.getPlayer1Move();
        while (helpMove.contains(helpRound.getPlayer1Move())) {
            streak++;
            if (helpRound.getPrev() != null) {
                helpRound = helpRound.getPrev();
            } else {
                helpRound.setPlayer1Move("stop");
            }

        }
        return streak;
    }

    /**
     * Palautetaan painotettu random (kivellä voittaa aina)
     */
    public void getRandom() {
        Random random = new Random();
        int luku = random.nextInt(100);
        //painotettu random. (kivi 45%) (sakset 30%) (paperi 25%)
        int kivi = 45;
        int sakset = kivi + 30;
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

    /**
     * hakee siirron joka häviää vastustajan vähiten käyttämälle siirrolle
     */
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

    public void setRR(RoundRemember rRemember) {
        this.RR = rRemember;
    }

}
