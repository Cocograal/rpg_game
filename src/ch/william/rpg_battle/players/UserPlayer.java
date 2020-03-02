package ch.william.rpg_battle.players;

import ch.william.rpg_battle.weapons.Weapon;

import java.util.ArrayList;

public class UserPlayer extends Player {

    private String name;


    public UserPlayer(Weapon weapon, String name, int level, int money, ArrayList<String> equipment) {
        this.weapon = weapon;
        this.name = name;
        this.level = level;
        this.money = money;
        this.equipment = equipment;

        attack = 5 + weapon.getAttack();
        defense = 5 + weapon.getDefense();
        accuracy = 30 + weapon.getAccuracy();
        speed = 10 + weapon.getSpeed();
        health = 50 + 3*level;

        System.out.println("Player successfully initialized");
    }
}
