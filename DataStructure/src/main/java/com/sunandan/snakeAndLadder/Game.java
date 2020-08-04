package com.sunandan.snakeAndLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {

    LinkedList<Player> players = new LinkedList<Player>();

    List<Player> playerRanking = new ArrayList<>();

    Board board = new Board();

    void emulate(int numberOfPlayers) {
        System.out.println("Game has started with : " + numberOfPlayers + " players");
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }
        play();
    }

    private void play() {
        int count = 0;
        while (playerRanking.size() < players.size()) {
            players.get(count % players.size()).rollDice(board);
            count++;
        }

    }

    public static void main(String[] args) {
        int numberOfPlayers = Integer.parseInt(args[0]);
        new Game().emulate(numberOfPlayers);
    }


}
