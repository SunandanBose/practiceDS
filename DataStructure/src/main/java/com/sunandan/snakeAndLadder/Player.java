package com.sunandan.snakeAndLadder;

public class Player {

    private String name;

    private int position = 0;

    private Dice dice;

    public Player(String name, Dice dice) {
        this.name = name;
        this.dice = dice;
    }

    public void rollDice(Board board) {
        int result = dice.roll();
        System.out.println(result);
    }


}
