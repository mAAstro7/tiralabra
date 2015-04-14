/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * Tietorakenne kierroksien taltiointiin, kaksisuuntainen linkitetty lista
 * 
 * !!!HUOM!!!
 * tätä tietorakennetta ei käytetä
 * !!!HUOM!!!
 * 
 */
public class RoundList {
    private Round[] rounds = new Round[0];
    

    /**
 *
 *  kasvatetaan taulukon kokoa jotta saadaan uusi round olio talletettua
 *  //kesken
 */
   
    
public void increaseSize() {
        Round[] newTable = new Round[this.rounds.length];
        System.arraycopy(this.rounds, 0, newTable, 0, this.rounds.length);
   
    this.rounds = newTable;
  
}
 /**
 *
 *  Lisätään uusi round olio.
 *  //kesken
 */
   
    /**
     * Lisätään uusi round olio.//kesken
     * @param round uusi round olio 
     */
    public void put(Round round) {
    increaseSize();
        for(int i =0;i<this.rounds.length; i++) {
        if (this.rounds == null) {
            this.rounds[i] = round;
            break;
        }
    }
}

    @Override
    public String toString() {
    String roundtoString = "";
        for (Round round : rounds) {

            roundtoString = roundtoString + "\n" + round.toString();
        }
    return roundtoString;
}

}