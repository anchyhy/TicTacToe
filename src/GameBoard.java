package TB;

import java.util.Arrays;
import java.util.Scanner;

// 1. A entity for the game board
public class GameBoard {
	char [][] board; // character arry
	// 1. Initialize the game board
	public GameBoard() {
		board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			Arrays.fill(board[i], ' ');
		}
	}
	//1. display the gameboard
	public void display() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
				if(j == 0 || j == 1) {
					//1. add the bar between the adjacent element
					System.out.print("|");
				}
			}
			System.out.println();
			//1. add a line between adjacent lines
			System.out.println("-----");
		}
	}
	// 1. also has the function to check if one player is win
	public boolean checkWin() {
		//1. check if the player win in one row, or one column, or one diagonal, go to the tic class.
		return checkRowWin() || checkColWin() || checkDiagonalWin();
	}
	public boolean checkRowWin() {
		for(int i = 0 ;i < 3; i++) {
			if(board[i][0] != ' '  && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}
	public boolean checkColWin() {
		for(int i = 0 ;i < 3; i++) {
			if(board[0][i]!= ' '  && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}
	public boolean checkDiagonalWin() {
		return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[2][2] == board[1][1]) || (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
	}
	// 5. implement the check board is valid function
	public boolean isStillValid() {
		boolean flag = false;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {// 5. if there is one empty element
				if(board[i][j] == ' ') {
					flag = true;
				}
			}
		}
		return flag;
	}
	// 5. implement the move function
	public void toGo(char player) {
		Scanner keyboard = new Scanner(System.in);
		int row, col;
		System.out.println("Player " + player + ", please enter the row number from 1 -3:");
		row = keyboard.nextInt();
		System.out.println("Player " + player + ", please enter the col number from 1 -3:");
		col = keyboard.nextInt();
		while(!isEnteredValid(row - 1, col - 1)) {
			System.out.println("Invalid entering!!! Player " + player + ", please enter again!");
			System.out.println("Player " + player + ", please enter the row number from 1 -3:");
			row = keyboard.nextInt();
			System.out.println("Player " + player + ", please enter the col number from 1 -3:");
			col = keyboard.nextInt();
		}
		canMove(row, col, player);
	}
	public boolean isEnteredValid(int i, int j) {
		if (i < 0 || i >= 3 || j < 0 || j >= 3 || board[i][j] != ' ') {
			return false;
		}
		return true;
	}
	public boolean canMove(int i, int j, char player) {
			board[--i][--j] = player;
			display();
			return true;
	}
}
