package ch.william.rpg_battle;

import ch.william.rpg_battle.gametypes.ConsoleGame;
import ch.william.rpg_battle.players.AIPlayer;
import ch.william.rpg_battle.players.UserPlayer;
import ch.william.rpg_battle.weapons.Bow;

import java.util.ArrayList;

public class Mainloop {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Bow weapon = new Bow();
        UserPlayer p1 = new UserPlayer(weapon, "Cocograal", 1, 1000, new ArrayList<>());
        ConsoleGame game = new ConsoleGame(p1);
        game.start();

    }
}
