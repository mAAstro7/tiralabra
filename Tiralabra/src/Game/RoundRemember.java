/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * Tietorakenne kierroksien taltiointiin, kaksisuuntainen linkitetty lista Tämä
 * luokka muistaa edellisen kierroksen ja on vaihtoehtoinen tapa toteuttaa
 * linkitetty lista ilman taulukkoa
 */
public class RoundRemember {

    private Round lastRound;
    private int nextIndex;

    public RoundRemember() {
        this.lastRound = null;

        this.nextIndex = 0;
    }

    public void addRound(Round round) {

        //asetetaan uuden olion prev arvoksi edellinen kierros
        round.setPrev(getLastRound());
        //jos edellinen on tyhjä ei tehdä mitään
        if (!(getLastRound() == null)) {
            //asetetaan edellisen round olion next arvoksi uusin round
            getLastRound().setNext(round);
//            System.out.println("lisättiin");
        }
        //asetetaan viimeisin kierros roundRememberiin

        setLastRound(round);
    }

    public Round getLastRound() {
        return lastRound;
    }

    /**
     * Talletetaan viimeisin round muistiin ja lisätään sille indexi
     *
     * @param lastRound on viimeisin round tapahtuma
     */
    public void setLastRound(Round lastRound) {
        this.lastRound = lastRound;
        this.lastRound.setIndex(nextIndex);
        this.nextIndex++;
    }

    /**
     * Poistetaan haluttu kierros muuttammalla sen prev ja next olioiden prev ja
     * next osoittimet osoittamaan toisiinsa. Tämän jälkeen korjataan indexien
     * arvot (-1 poistettavaa kierrosta uusimpiin)
     * @param index poistettava indexi
     */
    public void deleteRoundInIndex(int index) {

        Round deleteRound = this.lastRound;
        while (index != deleteRound.getIndex()) {
            deleteRound = deleteRound.getPrev();
        }
        Round newNext = deleteRound.getNext();
        deleteRound.getPrev().setNext(newNext);
        newNext.setPrev(deleteRound.getPrev());
        newNext.setIndex(newNext.getIndex() - 1);

        while (newNext.getNext() != null) {
            newNext = newNext.getNext();
            newNext.setIndex(newNext.getIndex() - 1);
        }
    }

    public Round getRoundByIndex(int index) {
        Round round = this.lastRound;
        while (index != round.getIndex()) {
            round = round.getPrev();
        }
        return round;
    }
}
