package game;

import java.util.Random;

public abstract class Creature {
    protected final String name;
    protected final int attack;
    protected final int defense;
    protected final int maxHealth;
    protected int health;
    protected final int minDamage;
    protected final int maxDamage;
    protected boolean isAlive;
    private final Random random = new Random();
    private final Dice dice = new Dice();

    public Creature(int attack, int defense, int health, int maxDamage, int minDamage, String name) throws IllegalArgumentException {
        if ((attack < 1) || (attack > 30)) {
            throw new IllegalArgumentException("Значение Атаки существа - это целое число от 1 до 30.");
        }

        if ((defense < 1) || (defense > 30)) {
            throw new IllegalArgumentException("Значение Защиты существа - это целое число от 1 до 30.");
        }

        if (health < 0) {
            throw new IllegalArgumentException("Значение Здоровья существа - это натуральное число от 0 до N.");
        }

        if ((minDamage <= 0) || (maxDamage <= 0) || (maxDamage < minDamage)) {
            throw new IllegalArgumentException("Значение Урона существа - это диапазон натуральных чисел.");
        }

        this.attack = attack;
        this.health = health;
        maxHealth = health;
        this.defense = defense;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        isAlive = true;
        this.name = name;
    }

    public void attack(Creature target) {
        int modifier = attack - target.getDefense() + 1;

        boolean success = dice.rollSuccess(modifier);

        if (success) {
            target.takeDamage(getRandomDamage());

            System.out.println("Существо " + target.getName() + " было атаковано Существом " + getName() + ". Теперь здоровье " + target.getName() + " равно " + target.getHealth());

            if (!target.isAlive()) {
                System.out.println("Существо " + target.getName() + " было убито Существом " + getName());
                return;
            }

            if (target instanceof Player) {
                if (target.health < target.maxHealth - target.maxHealth * 0.3) {
                    if (((Player) target).heal()) {
                        System.out.println("Герой " + target.getName() + " исцелился");
                    }
                }
            }
        }
    }

    public int getRandomDamage() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health <= 0) isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }
}
