
package UserInterface;

import Player.Player;
import ArtificialIntelligence.AI;
import GameMove.Inspector;
import java.util.Scanner;

/**
 * Luokka käyttöliittymälle
 * @author joonatan
 */
public class UI {
    
    private AI botti = new AI();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Inspector inspa = new Inspector();
    
    public UI () {
        
       
    }
    
 /**
 * Suorittaa ohjelman
 */
    public void run() {
        Scanner lukija = new Scanner(System.in);
        createPlayers();
        int  i =0;
        //Tässä vaiheessa voi pelata seitsemän siirron testipelejä
        while (i<7) {
            System.out.println(getScores());
            System.out.println("Choose your move: k,p,s");
            String siirto1 = lukija.next();
            while (!siirto1.equals("k") && !siirto1.equals("s") && !siirto1.equals("p")) {
            System.out.println("Choose better, remember: k,p,s");
            siirto1 = lukija.next();
            }
            
            String siirto2 = botti.getMove()+"";
            String voittaja = inspa.checkWhoWins(siirto1, siirto2);
            System.out.println(player1.getName()+" chooses " + siirto1 + " and " + player1.getName()+" chooses "+ siirto2);
            
            if (voittaja.contains("p1")) {
                System.out.println("Winner is " + player1.getName());
                player1.addPoint();
            } else if (voittaja.contains("p2")) {
                System.out.println("Winner is " + player2.getName());
                player2.addPoint();
            }
            i++;
            
        }
        
        System.out.println(getScores());
    }
    
  /**
 * Palauttaa pelaajien toString joka kertoo nimen ja pistemäärän
 */
    public String getScores() {
        
        return player1.toString() +"  "+ player2.toString();
    }
    
 /**
 * Luo pelaajan ja antaa pelaajalle mahdollisuuden nimetä itsensä ja vastustajan
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
    
    public void makeMove() {
        Scanner lukija = new Scanner(System.in);
        String siirto = lukija.nextLine();
        String siirto2 = botti.getMove()+"";
    }
    
    
}
