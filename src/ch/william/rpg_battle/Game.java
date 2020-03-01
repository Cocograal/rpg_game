package ch.william.rpg_battle;

import ch.william.rpg_battle.players.ComputerPlayer;
import ch.william.rpg_battle.players.Player;
import ch.william.rpg_battle.players.RealPlayer;

import java.util.Random;
import java.util.Scanner;

public class Game {
    ComputerPlayer computerPlayer;
    RealPlayer realPlayer;

    boolean continueGame;

    public Game(RealPlayer realPlayer, ComputerPlayer computerPlayer) {
        this.realPlayer = realPlayer;
        this.computerPlayer = computerPlayer;
    }

    protected void start() {
        Scanner sc = new Scanner(System.in);
        Random rdm = new Random();
        String choice, computerChoice;
        String[] computerChoices = {"attack", "provoke"};
        continueGame = true;
        do {
            computerChoice = computerChoices[rdm.nextInt(computerChoices.length)];

            System.out.print("Choose between attack, provoke, flee >>>");
            choice = sc.nextLine();

            if (firstToPlay()) {
                applyChoice(choice, computerPlayer);
                applyChoice(computerChoice, realPlayer);
            } else {
                applyChoice(computerChoice, realPlayer);
                applyChoice(choice, computerPlayer);
            }

            System.out.println("Player health: " + realPlayer.getHealth() + ", computer health: " + computerPlayer.getHealth());
        } while (realPlayer.getHealth() > 0 && computerPlayer.getHealth() > 0);

    }

    private boolean firstToPlay() {
        if (realPlayer.getSpeed() > computerPlayer.getSpeed())
            return true;
        else if (realPlayer.getSpeed() == computerPlayer.getSpeed()) {
            Random rdm = new Random();
            if (rdm.nextInt(2) == 1)
                return true;
        }
        return false;
    }

    private void applyChoice(String choice, Player character) {
        if (character.getHealth() > 0) {
            switch (choice) {
                case "attack":
                    System.out.println("You attacked");
                    character.setHealth(-(character.getAttack()));
                    break;
                case "provoke":
                    System.out.println("You provoked the ennemy");
                    character.setAccuracy(-5);
                    break;
                case "flee":
                    System.out.println("You fled");
                    continueGame = false;
                    break;
            }
        }
    }
}
