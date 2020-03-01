package ch.william.rpg_battle.players;

import ch.william.rpg_battle.weapons.Weapon;

import java.util.ArrayList;

public class RealPlayer extends Player {
    Weapon weapon;
    String name;


    public RealPlayer(Weapon weapon, String name, int level, int money, ArrayList<String> equipment) {
        this.weapon = weapon;
        this.name = name;
        this.level = level;
        this.money = money;
        this.equipment = equipment;

        attack = 5 + weapon.attack;
        defense = 5 + weapon.defense;
        accuracy = 30 + weapon.accuracy;
        speed = 10 + weapon.speed;
        health = 50 + 3*level;

        System.out.println("Player successfully initialized");
    }

    protected void changeStats() {

    }
}
