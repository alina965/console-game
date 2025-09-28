package game;

public class Monster extends Creature {
    public Monster(int attack, int defense, int health, int maxDamage, int minDamage, String name) throws IllegalArgumentException {
        super(attack, defense, health, maxDamage, minDamage, name);
    }
}
