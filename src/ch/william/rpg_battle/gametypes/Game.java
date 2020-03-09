package ch.william.rpg_battle.gametypes;

import ch.william.rpg_battle.players.AIPlayer;
import ch.william.rpg_battle.players.UserPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {
    protected AIPlayer aiPlayer;
    protected UserPlayer userPlayer;
    protected String[] choicesArray = {"attack", "provoke", "flee"};
    protected List<String> choicesList = Arrays.asList(choicesArray);

    protected boolean continueGame;
    protected Scanner sc;
    protected Random rdm;
    public abstract void start();
}
