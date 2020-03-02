package ch.william.rpg_battle;

import ch.william.rpg_battle.players.AIPlayer;
import ch.william.rpg_battle.players.Player;
import ch.william.rpg_battle.players.UserPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private AIPlayer aiPlayer;
    private UserPlayer userPlayer;

    private boolean continueGame;
    private Scanner sc;
    private Random rdm;


    public Game(UserPlayer userPlayer, AIPlayer aiPlayer) {
        this.userPlayer = userPlayer;
        this.aiPlayer = aiPlayer;
        continueGame = true;
        rdm = new Random();
        sc = new Scanner(System.in);

    }

    protected void start() {
        String choice, computerChoice;
        // String[] computerChoices = {"attack", "provoke"};
        String[] computerChoices = {"provoke"};

        do {
            System.out.println("Player health: " + userPlayer.getHealth() + ", computer health: " + aiPlayer.getHealth());
            computerChoice = computerChoices[rdm.nextInt(computerChoices.length)];

            System.out.print("Choose between attack, provoke, flee >>>");
            choice = sc.nextLine();

            if (firstToPlay()) {
                applyChoice(choice, aiPlayer, userPlayer);
                applyChoice(computerChoice, userPlayer, aiPlayer);
            } else {
                applyChoice(computerChoice, userPlayer, aiPlayer);
                applyChoice(choice, aiPlayer, userPlayer);
            }


        } while (userPlayer.isAlive() && aiPlayer.isAlive() && continueGame);

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
                    } else {
                        System.out.println("You missed");
                    }
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
        }
    }
}
