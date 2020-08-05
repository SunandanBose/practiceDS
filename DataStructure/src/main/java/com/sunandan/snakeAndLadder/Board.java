package com.sunandan.snakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private Notifier notifier;

    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders = new HashMap<>();

    Board(Notifier notifier, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.notifier = notifier;
        this.snakes = snakes;
        this.ladders = ladders;
    }


    public int getNextPosition(int prevPosition, int diceValue, Player player) {
        Integer finalValue = prevPosition + diceValue;
        if (snakes.get(finalValue) != null) {
            System.out.println("OOPs!!!! Snake as bit you");
            return snakes.get(finalValue);
        }
        if (ladders.get(finalValue) != null){
            System.out.println("Yipee!!!! You found a ladder");
            return ladders.get(finalValue);
        }
        if (finalValue == 100) {
            notifier.broadcast(player);
            return 100;
        }
        if (finalValue > 100)
            return prevPosition;
        return prevPosition + diceValue;
    }
}
