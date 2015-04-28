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

    public int length() {
        return lastRound.getIndex() + 1;
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
     *
     * @param index poistettava indexi
     */
    public void deleteRoundInIndex(int index) {

        if (index > 0 && index <= length()-1) {
            Round deleteRound = this.lastRound;
            while (index != deleteRound.getIndex()) {
                deleteRound = deleteRound.getPrev();
            }
            Round newNext = deleteRound.getNext();
            deleteRound.getPrev().setNext(newNext);
            newNext.setPrev(deleteRound.getPrev());

        } else {
            Round firsInList = getRoundByIndex(0);
            Round lastInList = firsInList.getNext();
            lastInList.setPrev(null);

        }
        fixIndexAfterDelete(index);

    }

    /**
     * Korjatan indexit osoittamaan oikein
     *
     * @param deletedindex poistettu indexi joka on tällä hetkellä tyhjä
     */
    public void fixIndexAfterDelete(int deletedIndex) {
        int uusiIndexi = 0;
        for (int i = 0; i < length(); i++) {
            if (i == deletedIndex) {
            } else {
                Round round = getRoundByIndex(i);
                round.setIndex(uusiIndexi);
                System.out.println(round.getIndex());
                uusiIndexi++;
            }

        }
    }

    /**
     * Palautetaan halutusta indexistä round olio
     *
     * @param index palautettava indexi
     */
    public Round getRoundByIndex(int index) {
        Round round = this.lastRound;
        while (index != round.getIndex()) {
            round = round.getPrev();
        }
        return round;
    }
}
