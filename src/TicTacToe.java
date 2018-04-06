package TB;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			// 2. create the entity gameboard
			GameBoard board = new GameBoard();
			// 2. display. 
			board.display();
			// 3. Next is to see how players move in game board.
			// 3. First, we need a variable to show decide who is the next one to move.
			int counter = 1;
			boolean flag = false;
			// 3. Before moving, we need to check if the board is still valid now.
			while(board.isStillValid()) {
				//3. user the counter to decide who is the next one to move. if odd, X move, else O move.
				if(counter % 2 == 1) {
					board.toGo('X');
					//4. after each move, the system need to check if this player is win.,if win, the game is over.
					if(board.checkWin()) {
						System.out.println("X win!");
						flag = true;
						break;
					}
				} else {
					board.toGo('O');
					if(board.checkWin()) {
						System.out.println("O win!");
						flag = true;
						break;
					}
				}
				counter++;
			}
			// 4. if no one win and the board is not valid, the game is over. go to gameboard
			if (!flag) {
			System.out.println("No one win~~");
			}
			System.out.println("Do you want to play again? Y/N");
			if (keyboard.nextLine().toLowerCase().equals("n")) {
				break;
			}
		}
		keyboard.close();
	}

}
