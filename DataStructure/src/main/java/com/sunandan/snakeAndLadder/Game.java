package com.sunandan.snakeAndLadder;

import java.util.*;

public class Game implements  Observer{

    private LinkedList<Player> players = new LinkedList<Player>();
    private List<Player> playerRanking = new ArrayList<>();

    private Board board ;
    private int numberOfPlayers;

    public Game(int numberOfPlayers, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.numberOfPlayers = numberOfPlayers;
        this.board = new Board(new Notifier(this), snakes, ladders);
    }


    void emulate(Dice dice) {
        System.out.println("Game has started with : " + numberOfPlayers + " players");
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player"+(i+1),dice));
        }
        play();
    }

    private void play() {
        int count = 0;
        while (playerRanking.size() != 1) {
            count++;
            players.get(count % players.size()).rollDice(board);
            if(count % players.size() == 0){
                players.forEach(System.out::println);
            }
        }
        System.out.println("Player Won : "+playerRanking.get(0));

    }

    public static void main(String[] args) {
        //TODO: game should not contain snake and ladder
        //TODO: snake and ladder should be random
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(12,5);
        snakes.put(34,13);
        snakes.put(44,17);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(6,45);
        ladders.put(14,53);
        ladders.put(24,97);
        int numberOfPlayers = Integer.parseInt(args[0]);
        Dice dice = new Dice();
        Game game = new Game(numberOfPlayers,snakes,ladders);
        game.emulate(dice);
    }


    @Override
    public void notify(Player player) {
        playerRanking.add(player);
    }
}
