package ch.william.rpg_battle.weapons;

public abstract class Weapon {
    public int attack, defense, accuracy, speed, price;
    abstract void weaponFeature();

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getAccuracy() {
        return accuracy;
    }
    public int getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }
}
