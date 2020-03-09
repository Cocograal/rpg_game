package ch.william.rpg_battle.players;

import ch.william.rpg_battle.weapons.Weapon;

import java.util.List;
import java.util.Random;

public class Player {

    protected int level, money, attack, defense, accuracy, speed, health;
    protected Weapon weapon;
    protected List<String> equipment;
    protected Random rdm = new Random();

    public void changeStats(String stat, int statChange) {
        switch (stat) {
            case "attack":
                attack += statChange;
                break;
            case "defense":
                defense += statChange;
                break;
            case "accuracy":
                if(accuracy + statChange > 0)
                    accuracy += statChange;
                else
                    System.out.println("Accuracy cannot go lower.");
                break;
            case "speed":
                speed += statChange;
                break;
            case "health":
                health += statChange;
                break;
        }
    }

    public void resetStats() {
        attack = 5 + 3*level + weapon.getAttack();
        defense = 5 + 3*level + weapon.getDefense();
        accuracy = 30 + 3*level + weapon.getAccuracy();
        speed = 10 + 3*level + weapon.getSpeed();
        health = 50 + 3*level;
    }

    public void damage(int damage) {
        System.out.println(damage);
        health -= damage;
    }

    public boolean isAlive() {
        if (health <= 0)
            return false;
        return true;
    }

    public boolean hasHitTheTarget() {
        if (rdm.nextInt(accuracy) > accuracy/3 + 3)
            return true;
        return false;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLevel() {
        return level;
    }
}
