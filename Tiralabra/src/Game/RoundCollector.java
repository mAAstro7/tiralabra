/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * Tietorakenne kierroksien taltiointiin,
 */
public class RoundCollector {
    private Round[] rounds = new Round[0];


public void increaseSize() {
    Round[] newTable = new Round[this.rounds.length+1];
    this.rounds = newTable;
    System.out.println(newTable.length);
}

public void put(Round round) {
    
    this.rounds[0] = round;
}

public String toString() {
    String roundtoString = "";
    for (int i = 0; i<rounds.length; i++) {
        System.out.println(rounds[i].toString())                    ;
        roundtoString = roundtoString + "\n" + rounds[i].toString();
    }
    return roundtoString;
}

}