package com.sunandan.snakeAndLadder;

public class Notifier {

    Observer observer;

    public Notifier(Observer observer) {
        this.observer = observer;

    }

    void broadcast(Player player){
        observer.notify(player);
    }

}
