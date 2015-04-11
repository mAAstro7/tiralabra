package UserInterface;

import Player.Player;
import ArtificialIntelligence.*;
import Game.Inspector;
import Game.Round;
import Game.RoundRemember;
import java.util.Scanner;

/**
 * Luokka käyttöliittymälle
 *
 * @author joonatan
 */
public class UI {

    private AI botti;
    private Player player1;
    private Player player2;
    private Inspector inspa;
    private RoundRemember roundRemember;

    public UI() {
        this.botti = new AI();
        this.player1 = new Player();
        this.player2 = new Player();
        this.inspa = new Inspector();
        this.roundRemember = new RoundRemember();
    }

    /**
     * Suorittaa ohjelman
     */
    public void run() {
        Scanner lukija = new Scanner(System.in);
        createPlayers();
        boolean moveOn = false;
        boolean stop = false;
        //Peli pyörii kunnes kirjoitetaan "stop"
        while (!stop) {
            System.out.println(getScores());
            System.out.println("Choose your move: k,p,s");
            System.out.println("'stop' stops");
            String siirto1 = lukija.next();
            stop = letsStop(siirto1);
            moveOn = correctMove(siirto1);
            while (!moveOn && !stop) {
                System.out.println("Choose better, remember: k,p,s");
                siirto1 = lukija.next();
                stop = letsStop(siirto1);
                moveOn = correctMove(siirto1);
            }
            if (!stop) {
                System.out.println("");
                runRound(siirto1);
            }

        }

        System.out.println(getScores());

    }

    /**
     * Palauttaa pelaajien toString joka kertoo nimen ja pistemäärän
     *
     * @return kierroksen to String
     */
    public String getScores() {

        return player1.toString() + "  " + player2.toString();
    }

    /**
     * Suorittaa pelikierroksen loppuun Botti valitsee siirtonsa ja voittava
     * pelaaja saa pisteen
     *
     * @param move1 Pelaajan siirto
     */
    public void runRound(String move1) {

        String move2 = botti.getMove() + "";
        boolean didBotWin = inspa.didAIwin(move1, move2);
        System.out.println(player1.getName() + " chooses " + move1 + " and " + player2.getName() + " chooses " + move2);
        if (move1.contains(move2)) {
            System.out.println("Its a TIEEE!!!1");
        } else if (didBotWin) {
            System.out.println("Winner is " + player2.getName());
            player2.addPoint();
        } else {
            System.out.println("Winner is " + player1.getName());
            player1.addPoint();
        }
        Round round = new Round(move1, move2, didBotWin);
        round.setPrev(roundRemember.getLastRound());
        if (!(roundRemember.getLastRound() == null)) {
            roundRemember.getLastRound().setNext(round);
            System.out.println("lisättiin");
        }
        roundRemember.setLastRound(round);
    }

    /**
     * Tarkistaa onko pelaajan tekemä siirto oikein (k,p,s)
     *
     * @param siirto on pelaajan tekemä siirto
     * @return true/false riippuen onko siirto oikein
     */
    public boolean correctMove(String siirto) {

        if (!siirto.equals("k") && !siirto.equals("s") && !siirto.equals("p")) {
            return false;

        } else {
            return true;
        }
    }

    public boolean letsStop(String siirto) {
        return siirto.contains("stop");

    }

    /**
     * Luo pelaajan ja antaa pelaajalle mahdollisuuden nimetä itsensä ja
     * vastustajan
     *
     */
    public void createPlayers() {
        System.out.println("Name yourself: ");
        Scanner lukija = new Scanner(System.in);
        String name = lukija.nextLine();
        player1.setName(name);
        System.out.println("Name your enemy: ");
        String name2 = lukija.nextLine();
        player2.setName(name2);

    }

}
