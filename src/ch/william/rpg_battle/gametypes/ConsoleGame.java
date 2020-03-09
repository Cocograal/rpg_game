package ch.william.rpg_battle.gametypes;

import ch.william.rpg_battle.players.AIPlayer;
import ch.william.rpg_battle.players.Player;
import ch.william.rpg_battle.players.UserPlayer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleGame extends Game {

    public ConsoleGame(UserPlayer userPlayer) {
        this.userPlayer = userPlayer;
        continueGame = true;
        rdm = new Random();
        sc = new Scanner(System.in);
    }

    public void start() {
        aiPlayer = new AIPlayer(1, 10);
        userPlayer.resetStats();
        String choice, computerChoice;
        String[] computerChoices = {"attack", "provoke"};
//        String[] computerChoices = {"provoke"};

        do {
            System.out.println("Player health: " + userPlayer.getHealth() + ", computer health: " + aiPlayer.getHealth());
            computerChoice = computerChoices[rdm.nextInt(computerChoices.length)];
            choice = waitForInput();
            applyChoicesOnPlayers(choice, computerChoice);
            addExpToPlayer();
        } while (userPlayer.isAlive() && aiPlayer.isAlive() && continueGame);
        System.out.print("Would you like to have another match? ");
        choice = sc.nextLine();
        if (choice.equals("yes"))
            start();
    }

    private void addExpToPlayer() {
        if (!aiPlayer.isAlive()) {
            userPlayer.addExp((aiPlayer.getLevel() + 1) * 10);
        }
    }

    private void applyChoicesOnPlayers(String choice, String computerChoice) {
        if (firstToPlay()) {
            applyChoice(choice, aiPlayer, userPlayer);
            applyChoice(computerChoice, userPlayer, aiPlayer);
        } else {
            applyChoice(computerChoice, userPlayer, aiPlayer);
            applyChoice(choice, aiPlayer, userPlayer);
        }
    }

    private String waitForInput() {
        String choice;
        do {
            System.out.print("Choose between attack, provoke, flee >>>");
            choice = sc.nextLine();
        } while (!choicesList.contains(choice));
        return choice;
    }

    private boolean firstToPlay() {
        if (userPlayer.getSpeed() > aiPlayer.getSpeed())
            return true;
        else if (userPlayer.getSpeed() == aiPlayer.getSpeed()) {
            if (rdm.nextInt(2) == 1)
                return true;
        }
        return false;
    }

    private void applyChoice(String choice, Player opponent, Player actualPlayer) {
        if (actualPlayer.isAlive()) {
            boolean hasHit = actualPlayer.hasHitTheTarget();
            switch (choice) {
                case "attack":
                    if (hasHit) {
                        System.out.println("You attacked");
                        opponent.damage(actualPlayer.getAttack());
                    } else
                        System.out.println("You missed");
                    break;
                case "provoke":
                    System.out.println("You provoked the ennemy");
                    opponent.changeStats("accuracy", -5);
                    break;
                case "flee":
                    System.out.println("You fled");
                    continueGame = false;
                    break;
            }
            System.out.println("\n");
        }
    }
}
