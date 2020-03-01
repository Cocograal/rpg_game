package ch.william.rpg_battle.players;

import ch.william.rpg_battle.weapons.Weapon;
import java.util.ArrayList;

public abstract class Player {
    protected int level, money, attack, defense, accuracy, speed, health;
    protected Weapon weapon;
    protected ArrayList<String> equipment;

    abstract void changeStats();

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

    public void setHealth(int health) {
        this.health += health;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy += accuracy;
    }
}
