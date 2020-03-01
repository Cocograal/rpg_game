package ch.william.rpg_battle;

import ch.william.rpg_battle.players.ComputerPlayer;
import ch.william.rpg_battle.players.RealPlayer;
import ch.william.rpg_battle.weapons.Bow;

import java.util.ArrayList;

public class Mainloop {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Bow weapon = new Bow();
        RealPlayer p1 = new RealPlayer(weapon, "Cocograal", 1, 1000, new ArrayList<>());
        ComputerPlayer computerPlayer = new ComputerPlayer(1, 3);
        System.out.println(p1.getAttack());
        Game game = new Game(p1, computerPlayer);
        game.start();




    }
}
