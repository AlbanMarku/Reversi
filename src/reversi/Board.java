package reversi;

import java.util.Scanner;
import java.io.*;

public class Board {
	int choice1;// row value from user
	int choice2;// col value from user
	char player = 'w';
	boolean confirmMove = false;
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

		if (grid[choice1 - 2][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck();
			if (confirmMove = true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer(); // Swaps turn.
				System.out.println("test up 2");
				boardLayout(); // Updates board.
				confirmMove = false;
			}
		}

		else if (grid[choice1][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test down 2");
				boardLayout();
				confirmMove = false;
			}
		}

		else if (grid[choice1 - 1][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test left 2");
				boardLayout();
				confirmMove = false;
			}
		}

		else if (grid[choice1 - 1][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test right 2");
				boardLayout();
				confirmMove = false;
			}
		}

		else if (grid[choice1 - 2][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck(); //Checks if move is valid.
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer(); // Swaps turn.
				System.out.println("test up1");
				boardLayout(); // Updates board.
				confirmMove = false;
			}
		}

		else if (grid[choice1][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test down 1");
				boardLayout();
				confirmMove = false;
			}
		}

		else if (grid[choice1 - 1][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test left 1");
				boardLayout();
				confirmMove = false;
			}
		}

		else if (grid[choice1 - 1][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test right 1");
				boardLayout();
				confirmMove = false;
			}
		}

		else {
			System.out.println("nope");// If invalid it will say nope and go back for the user to try again.
			chooseMove();
		}
	}

	public void endPieceCheck() {
		/**
		 * Checks to see if there is a piece that is the same colour of the piece being
		 * placed. This method doesn't work. Place a 'w' piece at by typing 6,4. Then
		 * place a 'b' piece by typing 6,3. The piece is placed even though there is no
		 * other 'b' piece on that row. That shouldn't happen.
		 */

		if (player == 'w' && grid[choice1 - 2][choice2 - 1] == 'b') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
				} else {
					System.out.println("Not valid up");
				}
			}
		}

		if (player == 'w' && grid[choice1][choice2 - 1] == 'b') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
				} else {
					System.out.println("Not valid down");
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2 - 2] == 'b') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
				} else {
					System.out.println("Not valid left");
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2] == 'b') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
				} else {
					System.out.println("Not valid right");
				}
			}
		}

		if (player == 'b' && grid[choice1 - 2][choice2 - 1] == 'w') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
				} else {
					System.out.println("Not valid up b");
				}
			}
		}

		if (player == 'b' && grid[choice1][choice2 - 1] == 'w') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'b') {
					System.out.println("testy");
					confirmMove = true;
				} else {
					System.out.println("Not valid down b");
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2 - 2] == 'w') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'b') {
					System.out.println("test");
					confirmMove = true;
				} else {
					System.out.println("Not valid left b");
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2] == 'w') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
				} else {
					System.out.println("Not valid right b");
				}
			}
		}

//		else {
//			if (player == 'b') {
//				for (int i = choice1 - 1; i > 0; i--) {
//					for (int x = choice2 - 1; x > 0; x--) {
//						if (grid[i][x] == 'b') {
//							confirmMove = true;
//						}
//					}
//				}
//			}
//		}
	}

	public void saveGame() {

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