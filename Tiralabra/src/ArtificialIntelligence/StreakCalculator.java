/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtificialIntelligence;

/**
 * Luokka joka hoitaa siirtoputkien (esim k,k,k,k,?) jatkumis todennäköisyyden
 * laskennan.
 */
public class StreakCalculator {

    //laskee todennäköisyyden 2x putken jatkuvan
    private double afterTwo;
    //laskee todennäköisyyden 3x putken jatkuvan
    private double afterThree;
    //laskee todennäköisyyden 4x putken jatkuvan
    private double afterFour;
    //muistaa monta kertaa on tullut 2x putki
    private int countDoubles;
    //muistaa monta kertaa on tullut 3x putki
    private int countTrebles;
    //muistaa monta kertaa on tullut 4x putki
    private int countFour;

    public StreakCalculator() {
        this.afterTwo = 0;
        this.afterThree = 0;
        this.afterFour = 0;
        this.countDoubles = 0;
        this.countFour = 0;
        this.countTrebles = 0;
    }

    /**
     * Metodi palauttaa todennäköisyyden että putki jatkuu.
     *
     * @param count putken määrä
     */
    public double getProbForSameNext(int count) {
        //jos putki on yli 5 palautetaan aina 100%
        if (count > 5) {
            return 100;
            //jos putki on yli 4 palautetaan aina 100% ja kasvatetaan todennäköisyyttä neljän putkelle
        } else if (count > 4) {
            increaseFour();
            return 100;
            //jos putki on yli 3 kasvatetaan todennäköisyyttä kolmen putkelle
        } else if (count > 3) {
            increaseTreble();
            //tämän jälkeen tarkastetaan onko neljänputksita tarpeeksi otantaa
            //jos kyllä niin palautetaan laskettu todennäköisyys muuten 100%
            if (countFour > 2) {
                return getAfterFour();
            } else {
                return 100;
            }
            //sama logiikka kuin yllä
        } else if (count > 2) {
            increaseDouble();
            if (countTrebles > 3) {
                return getAfterThree();
            } else {
                return 100;
            }
        } else {
            //sama logiikka kuin yllä
            if (countDoubles > 2) {
                return getAfterTwo();
            }
            //palautetaan 0 jo
            return 0;
        }
    }

    public void increaseDouble() {
        this.countDoubles++;
        this.afterTwo++;
    }

    public void increaseTreble() {
        this.countTrebles++;
        this.afterThree++;
    }

    public void increaseFour() {
        this.countFour++;
        this.afterFour++;
    }

    public void increaseDoubleCount() {
        this.countDoubles++;

    }

    public void increaseTrebleCount() {
        this.countTrebles++;
    }

    public void increaseFourCount() {
        this.countFour++;
    }

    public double getAfterTwo() {
        if (afterTwo == 0) {
            return 0;
        } else {
            return afterTwo / countDoubles;
        }

    }

    public double getAfterThree() {
        if (afterThree == 0) {
            return 0;
        } else {
            return afterThree / countTrebles;
        }

    }

    public double getAfterFour() {
        if (afterFour == 0) {
            return 0;
        } else {
            return afterFour / countFour;
        }

    }

}
