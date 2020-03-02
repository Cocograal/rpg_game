package ch.william.rpg_battle.players;


import ch.william.rpg_battle.weapons.Bow;
import ch.william.rpg_battle.weapons.Sword;
import ch.william.rpg_battle.weapons.Weapon;

import java.util.Random;

public class AIPlayer extends Player {
    protected Weapon[] weaponList = {new Bow(), new Sword()};


    public AIPlayer(int levelMin, int LevelMax) {
        Random rdm = new Random();
        weapon = weaponList[rdm.nextInt(weaponList.length)];
        level = rdm.nextInt(LevelMax - levelMin) + levelMin - 2;
        System.out.println("Level : " + level);

        attack = 5 + 3*level + weapon.getAttack();
        defense = 5 + 3*level + weapon.getDefense();
        accuracy = 30 + 3*level + weapon.getAccuracy();
        speed = 10 + 3*level + weapon.getSpeed();
        health = 500000 + 3*level;

        System.out.println("Bot successfully initialized");

    }
}
