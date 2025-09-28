package game;

public class Player extends Creature {
    private int healsLeft = 4;

    public Player(int attack, int defense, int health, int maxDamage, int minDamage, String name) throws IllegalArgumentException {
        super(attack, defense, health, maxDamage, minDamage, name);
    }

    public boolean heal() {
        if (healsLeft <= 0) return false;

        health += (int) (maxHealth * 0.3);
        healsLeft--;

        return true;
    }
}
