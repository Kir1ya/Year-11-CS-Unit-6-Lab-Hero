import java.util.Random;

public class Hero {

    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String toString() {
        return "Hero{" + "name='" + name + "'" + ", hitPoints=" + hitPoints + '}';
    }

    public void attack(Hero opponent) {
        Random attackHelper = new Random();
        double attackOutcome = attackHelper.nextDouble();

        if (attackOutcome < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            hitPoints -= 10;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    public void fightUntilTheDeathHelper(Hero opponent) {
        while (hitPoints != 0 && opponent.hitPoints != 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\t" + opponent + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int [] wins = new int [2];
        for (int i = 0; i < n; i++) {
            fightUntilTheDeathHelper(opponent);
            if (hitPoints == 0) {
                wins[0] ++;
                senzuBean();
            }
            else if (opponent.hitPoints == 0) {
                wins [1] ++;
                opponent.senzuBean();
            }
        }
        return wins;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);
        String winner;
        if (wins[0] > wins[1]) {
            winner = name;
        }
        else if (wins[1] > wins[0]) {
            winner = opponent.name;
        }
        winner = "";
        String t =  name + ": " + wins[0] + " wins" + "\n" + opponent + ": "+  wins[1] + " wins" + "\n";

        if (winner.equals(opponent.name)) {
            t += opponent.name + " wins!";
        }
        else if (winner.equals(name)){
            t += name + " wins!";
        }
        else t+= "OMG! It was actually a draw!";
        return t;
    }
    public void dramaticFightToTheDeath(Hero opponent) {
        for(int i = 2; i>0; i--) {
            attack(opponent);
            if (hitPoints < opponent.hitPoints) {
                i = hitPoints;
            }
            else i = opponent.hitPoints;
            System.out.println(name + ": " + hitPoints + "\t" + opponent + ": " + opponent.hitPoints);
        }
        if (opponent.hitPoints == 0) {
            System.out.println(opponent + " wins!");
        }
        else System.out.println(name + " wins!");
    }
}