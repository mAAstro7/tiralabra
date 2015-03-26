
package UserInterface;

import Player.Player;
import ArtificialIntelligence.AI;
import java.util.Scanner;

/**
 * Luokka käyttöliittymälle
 * @author joonatan
 */
public class UI {
    
    private AI botti = new AI();
    private Player player1 = new Player();
    private Player player2 = new Player();
    
    public UI () {
        
       
    }
    
    public void run() {
        createPlayers();
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
        String siirto2 = botti.getSiirto()+"";
    }
    
    
}
