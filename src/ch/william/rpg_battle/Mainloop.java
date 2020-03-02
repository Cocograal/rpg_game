package ch.william.rpg_battle;

import ch.william.rpg_battle.players.AIPlayer;
import ch.william.rpg_battle.players.UserPlayer;
import ch.william.rpg_battle.weapons.Bow;

import java.util.ArrayList;

public class Mainloop {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Bow weapon = new Bow();
        UserPlayer p1 = new UserPlayer(weapon, "Cocograal", 1, 1000, new ArrayList<>());
        AIPlayer AIPlayer = new AIPlayer(1, 10);
        System.out.println(p1.getAttack());
        Game game = new Game(p1, AIPlayer);
        game.start();




    }
}
