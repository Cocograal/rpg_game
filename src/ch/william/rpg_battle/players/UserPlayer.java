package ch.william.rpg_battle.players;

import ch.william.rpg_battle.weapons.Weapon;

import java.util.ArrayList;

public class UserPlayer extends Player {

    private String name;
    private int exp;


    public UserPlayer(Weapon weapon, String name, int level, int money, ArrayList<String> equipment) {
        this.weapon = weapon;
        this.name = name;
        this.level = level;
        this.money = money;
        this.equipment = equipment;
        resetStats();
        System.out.println("Player successfully initialized");
    }



    public void addExp(int exp) {
        this.exp += exp;
        System.out.println(exp);
        if (this.exp >= expRequiredToNextLevel()) {
            exp =  this.exp - (int) expRequiredToNextLevel();
            level += 1;
            resetStats();
            this.exp = 0;
            System.out.println("You gained a level, you are now level " + level);
            addExp(exp);
        }
    }

    private double expRequiredToNextLevel() {
        double expToNextLevel = Math.pow(level - 1, 2) + 4;
        System.out.println(expToNextLevel);
        return expToNextLevel;
    }
}
