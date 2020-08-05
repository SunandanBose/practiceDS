package com.sunandan.snakeAndLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game implements  Observer{

    private LinkedList<Player> players = new LinkedList<Player>();
    private List<Player> playerRanking = new ArrayList<>();

    private Board board ;
    private int numberOfPlayers;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.board = new Board(new Notifier(this));
    }


    void emulate(Dice dice) {
        System.out.println("Game has started with : " + numberOfPlayers + " players");
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player"+i,dice));
        }
        play();
    }

    private void play() {
        int count = 0;
        while (playerRanking.size() < players.size()) {
            count++;
            players.get(count % players.size()).rollDice(board);
        }

    }

    public static void main(String[] args) {
        int numberOfPlayers = Integer.parseInt(args[0]);
        Dice dice = new Dice();
        Game game = new Game(numberOfPlayers);
        game.emulate(dice);
    }


    @Override
    public void notify(Player player) {
        playerRanking.add(player);
    }
}
