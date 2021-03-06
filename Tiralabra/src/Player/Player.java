
package Player;

/**
 * Luokka pelaajan luontiin, normaalist setterit ja getterit
 */
public class Player {
    
    private String name;
    private int points;
    

    public Player() {
        this.name = "";
        this.points = 0;
 
    }
    
    public void addPoint() {
        this.points ++;
    }

    public String getName() {
        return name;
    }

    public void setName(String nimi) {
        this.name = nimi;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    @Override
    public String toString() {
        return this.name + " scores: " + this.points;
    }
 
}
