package com.sunandan.snakeAndLadder;

public class Board {

    private Notifier notifier;

    Board(Notifier notifier) {
        this.notifier = notifier;
    }


    public int getNextPosition(int prevPosition, int diceValue, Player player) {
        if(prevPosition+diceValue == 100) {
            notifier.broadcast(player);
            return 100;
        }
        if (prevPosition + diceValue > 100)
            return prevPosition;
        return prevPosition + diceValue;
    }
}
