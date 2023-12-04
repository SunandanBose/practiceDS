Snake and Ladder

Board -> 100 numbers 
some numbers will make you jump
some numbers will make you fall
win on number 100

Dice -> 6 numbers

Players -> 2 players

players roll dice

player move forward based on dice


java

Game {

	LinkedList(Circular) players

	Board 


	play(){
		forEach(players){
			player.rollDice(board);
			//board.getPosition
			//board.broadcast

		}
	}

	listen(){

	}

	playersWon

	main(){
		Board()
		numberOfPlayers = args[1];

		for(numberOfPlayers){
			players.add(player());
		}
		play()
	}
}


Board{
	broadcast(player)
}

Notifier{
	Observer observer

	Notifier(Observer observer)
	{
		this.observer = observer
	}

	broadcast(player){
		observer.notify(player);
	}

}

Observer{
	abstract notify(player)
}

Game implement Observer{
	notify(player){
		//rank logic
	}
}


player can roll dice(get a random value between 1 to 6).
setup board(no snakes and ladder)
first person to reach 100 wins.











