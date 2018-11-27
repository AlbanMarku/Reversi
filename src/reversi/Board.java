package reversi;

import java.util.Scanner;
import java.io.*;

public class Board {
	int choice1;// row value from user
	int choice2;// col value from user
	char player = 'w';
	/**
	 * Creating board
	 */
	char[][] grid = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'w', 'b', '.', '.', '.' },
			{ '.', '.', '.', 'b', 'w', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };

	public static void main(String[] args) {
		Board myObject = new Board();
		/**
		 * Calling the board to be made
		 */
		myObject.boardLayout();
	}

	public void boardLayout() {
		/**
		 * Drawing the board.
		 */
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println("");
		}
		/**
		 * Calling to check if the board is full and then to ask user for a move.
		 */
		boardCheck();
		chooseMove();
	}

	public void boardCheck() {
		/**
		 * Displays if the board is full. Will be used to determine if the game is over
		 * later.
		 */
		boolean full = true;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (grid[row][col] == '.') {
					full = false;
				}
			}
		}
		if (full == true) {
			System.out.println("full");
		} else {
			System.out.println("Not full");
		}
	}

	public void chooseMove() {
		/**
		 * User inputs 2 numbers. Number 1 is row, 2 is col.
		 */
		Scanner userNumbers = new Scanner(System.in);
		System.out.println("number1");
		choice1 = userNumbers.nextInt();
		Scanner userNumbers2 = new Scanner(System.in);
		System.out.println("number2");
		choice2 = userNumbers2.nextInt();
		/**
		 * After the numbers are entered, the valid move method is called to see if the
		 * move is legal.
		 */
		validMove();
		userNumbers.close();
		userNumbers2.close();
	}

	public void currentPlayer() {
		/**
		 * Swaps player each turn.
		 */
		if (player == 'w') {
			System.out.println("------");
			System.out.println("b turn");
			System.out.println("------");
			player = 'b';
		} else {
			System.out.println("------");
			System.out.println("w turn");
			System.out.println("------");
			player = 'w';
		}
	}

	public void validMove() {
		
		if (grid[choice1 - 2][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // up
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer(); // Swaps turn.
			boardLayout(); // Updates board.
		}

		if (grid[choice1][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // down
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 1][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // left
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 1][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // right
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 2][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // up-left
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 2][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // up-right
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // down-left
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.' ) { // down-right
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}
		
		if (grid[choice1 - 2][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // up
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer(); // Swaps turn.
			boardLayout(); // Updates board.
		}

		if (grid[choice1][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // down
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 1][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // left
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 1][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // right
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 2][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // up-left
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1 - 2][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // up-right
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // down-left
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		if (grid[choice1][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.' ) { // down-right
			grid[choice1 - 1][choice2 - 1] = player;

			currentPlayer();
			boardLayout();
		}

		else {
			System.out.println("nope");// If invalid it will say nope and go back for the user to try again.
			chooseMove();
		}
	}

	public void saveGame() {
		/**
		 * I'm trying to save the grid if players want to play another time. Doesn't
		 * work right now. The file it creates is blank.
		 */
		FileOutputStream outputStream;
		PrintWriter printWriter = null;

		try {

			outputStream = new FileOutputStream("saveGame");
			printWriter = new PrintWriter(outputStream);

			do {
				printWriter.println(grid);
			} while (outputStream != null);

		} catch (Exception e) {
			System.out.println("error");
		}
	}
}