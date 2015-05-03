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
        boolean moveOn;
        boolean stop = false;
        //Peli pyörii kunnes kirjoitetaan "stop"
        while (!stop) {
            System.out.println(getScores());
            System.out.println("Choose your move: k,p,s");
            System.out.println("'stop' stops");
            String siirto1 = lukija.next();
            //tarkistetaan onko "siirto1" stop
            stop = letsStop(siirto1);
            //tarkistetaan onko siirto1 legit (k,p,s)
            moveOn = correctMove(siirto1);
            //jos siirto ei ole stop, tai kps, pyydetään tekemään uusi siirto
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
     * Pisteiden hakuun
     *
     * @return Palauttaa pelaajien toString joka kertoo nimen ja pistemäärän
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
        String move2 = botti.getMove(roundRemember.getLastRound()) + "";
        //haetaan boolean muuttujaan tulos inspector luokalta, voittaako botti
        boolean didBotWin = inspa.didAIwin(move1, move2);
        System.out.println(player1.getName() + " chooses " + move1 + " and " + player2.getName() + " chooses " + move2);
        if (move1.contains(move2)) {
            System.out.println("Its a tie");
        } else if (didBotWin) {
            System.out.println("Winner is " + player2.getName());
            System.out.println("");
            player2.addPoint();
        } else {
            System.out.println("Winner is " + player1.getName());
            System.out.println("");
            player1.addPoint();
        }
        Round round = new Round(move1, move2, didBotWin);
        
        //lisätään uusin round olio muistiin
        roundRemember.addRound(round);
        botti.setRR(roundRemember);
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

    /**
     * Palauttaa true jos käyttäjä on antanut komennon stop
     *
     * @param komento pelaajan antanu komento/siirto(stop, k,p,s)
     * @return true/false
     */
    public boolean letsStop(String komento) {
        return komento.contains("stop");

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
