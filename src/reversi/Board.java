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

		confirmMove = false;

		if (choice1 == 1) {
			validationForValue1();
		}

		if (choice1 == 8) {
			validationForValue8();
		}

		if (choice2 == 1) {
			validationForValue11();
		}

		if (choice2 == 8) {
			validationForValue88();
		}

		if (grid[choice1 - 2][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer(); // Swaps turn.
				boardLayout(); // Updates board.
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 2][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck(); // Checks if move is valid.
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer(); // Swaps turn.
				boardLayout(); // Updates board.
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1 - 1][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("----------");
				System.out.println("Try again");
				System.out.println("----------");
				boardLayout();
				chooseMove();
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
		 * placed.
		 */

		confirmMove = false;

		if (player == 'w' && grid[choice1 - 2][choice2 - 1] == 'b') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1][choice2 - 1] == 'b') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2 - 2] == 'b') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2] == 'b') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 2][choice2 - 1] == 'w') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1][choice2 - 1] == 'w') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2 - 2] == 'w') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2] == 'w') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1 - 2][choice2 - 2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'b') { // up-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2 - 2] == '.') {
						break;
					}
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1 - 2][choice2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'b') { // up-right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2] == '.') {
						break;
					}
					choice1--;
					choice2++;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1][choice2 - 2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 > 0) {
				if (grid[choice1][choice2 - 2] == 'b') { // down-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2 - 2] == '.') {
						break;
					}
					choice1++;
					choice2--;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1][choice2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'b') { // down - right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2] == '.') {
						break;
					}
					choice1++;
					choice2++;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1 - 2][choice2 - 2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'w') { // up-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2 - 2] == '.') {
						break;
					}
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1 - 2][choice2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'w') { // up-right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2] == '.') {
						break;
					}
					choice1--;
					choice2++;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1][choice2 - 2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 > 0) {
				if (grid[choice1][choice2 - 2] == 'w') { // down-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2 - 2] == '.') {
						break;
					}
					choice1++;
					choice2--;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1][choice2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'w') { // down - right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2] == '.') {
						break;
					}
					choice1++;
					choice2++;
				}
			}
		}
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

	public void validationForValue1() {

		confirmMove = false;

		if (grid[choice1][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck1();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test down 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1 - 1][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck1();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test left 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck1();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test right 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("----------");
				System.out.println("Try again");
				System.out.println("----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck1();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test down 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1 - 1][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck1();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test left 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck1();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test right 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		} else {
			System.out.println("nope");
			chooseMove();
		}
	}

	public void endPieceCheck1() {

		confirmMove = false;

		if (player == 'w' && grid[choice1][choice2 - 1] == 'b') { // down
			if (grid[choice1 + 1][choice2 - 1] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1][choice2 - 2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 > 0) {
				if (grid[choice1][choice2 - 2] == 'w') { // down-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2 - 2] == '.') {
						break;
					}
					choice1++;
					choice2--;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1][choice2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'w') { // down - right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2] == '.') {
						break;
					}
					choice1++;
					choice2++;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1][choice2 - 2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 > 0) {
				if (grid[choice1][choice2 - 2] == 'b') { // down-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2 - 2] == '.') {
						break;
					}
					choice1++;
					choice2--;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1][choice2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'b') { // down - right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2] == '.') {
						break;
					}
					choice1++;
					choice2++;
				}
			}
		}
		if (player == 'b' && grid[choice1 - 1][choice2 - 2] == 'w') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}
		if (player == 'b' && grid[choice1][choice2 - 1] == 'w') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}
		if (player == 'w' && grid[choice1 - 1][choice2 - 2] == 'b') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}
		if (player == 'b' && grid[choice1 - 1][choice2] == 'w') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}
		if (player == 'w' && grid[choice1 - 1][choice2] == 'b') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}
	}

	public void validationForValue8() {

		confirmMove = false;

		if (grid[choice1 - 2][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck2();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test up 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1 - 2][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck2();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test up 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck2();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test right 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("----------");
				System.out.println("Try again");
				System.out.println("----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck2();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test right 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("----------");
				System.out.println("Try again");
				System.out.println("----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1 - 1][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck2();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test left 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1 - 1][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck2();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test left 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
	}

	public void endPieceCheck2() {

		confirmMove = false;

		if (player == 'w' && grid[choice1 - 2][choice2 - 1] == 'b') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 2][choice2 - 1] == 'w') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2 - 2] == 'b') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2 - 2] == 'w') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2] == 'w') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2] == 'b') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1 - 2][choice2 - 2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'w') { // up-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2 - 2] == '.') {
						break;
					}
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1 - 2][choice2 - 2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'b') { // up-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2 - 2] == '.') {
						break;
					}
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1 - 2][choice2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'b') { // up-right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2] == '.') {
						break;
					}
					choice1--;
					choice2++;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1 - 2][choice2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'w') { // up-right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2] == '.') {
						break;
					}
					choice1--;
					choice2++;
				}
			}
		}
	}

	public void validationForValue11() {

		confirmMove = false;

		if (grid[choice1 - 1][choice2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck3();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test right 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("----------");
				System.out.println("Try again");
				System.out.println("----------");
				boardLayout();
				chooseMove();
			}
		}
		if (grid[choice1 - 1][choice2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // right
			endPieceCheck3();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test right 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("----------");
				System.out.println("Try again");
				System.out.println("----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck3();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test down 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck3();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test down 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 2][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck3();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				currentPlayer();
				System.out.println("test up1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 2][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck3();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test up1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
	}

	public void endPieceCheck3() {

		confirmMove = false;

		if (player == 'w' && grid[choice1 - 2][choice2 - 1] == 'b') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 2][choice2 - 1] == 'w') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1][choice2 - 1] == 'b') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1][choice2 - 1] == 'w') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2] == 'w') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2] == 'b') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i + 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1 - 2][choice2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'b') { // up-right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2] == '.') {
						break;
					}
					choice1--;
					choice2++;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1 - 2][choice2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'w') { // up-right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2] == '.') {
						break;
					}
					choice1--;
					choice2++;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1][choice2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'b') { // down - right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2] == '.') {
						break;
					}
					choice1++;
					choice2++;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1][choice2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'w') { // down - right
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2] == '.') {
						break;
					}
					choice1++;
					choice2++;
				}
			}
		}
	}

	public void validationForValue88() {

		confirmMove = false;

		if (grid[choice1 - 2][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck4();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test up 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 2][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // up
			endPieceCheck4();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test up 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2 - 2] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck4();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test left 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1 - 1][choice2 - 2] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // left
			endPieceCheck4();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test left 1");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1][choice2 - 1] == 'b' && player == 'w' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck4();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test down 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}

		if (grid[choice1][choice2 - 1] == 'w' && player == 'b' && grid[choice1 - 1][choice2 - 1] == '.') { // down
			endPieceCheck4();
			if (confirmMove == true) {
				grid[choice1 - 1][choice2 - 1] = player;
				flip();
				currentPlayer();
				System.out.println("test down 2");
				boardLayout();
				confirmMove = false;
			} else {
				System.out.println("-----------");
				System.out.println("Try again");
				System.out.println("-----------");
				boardLayout();
				chooseMove();
			}
		}
	}

	public void endPieceCheck4() {

		confirmMove = false;

		if (player == 'w' && grid[choice1 - 2][choice2 - 1] == 'b') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 2][choice2 - 1] == 'w') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i - 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2 - 2] == 'w') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2 - 2] == 'b') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 1][i - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1][choice2 - 1] == 'b') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'w') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1][choice2 - 1] == 'w') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'b') {
					confirmMove = true;
					break;
				} else {
					if (grid[i + 1][choice2 - 1] == '.') {
						break;
					}
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1 - 2][choice2 - 2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'w') { // up-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2 - 2] == '.') {
						break;
					}
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			if (grid[choice1 - 2][choice2 - 2] == 'b') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'b') { // up-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1 - 2][choice2 - 2] == '.') {
						break;
					}
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			if (grid[choice1][choice2 - 2] == 'w') {
				System.out.println("nope");
				chooseMove();
			}
			while (choice1 < 8 && choice2 > 0) {
				if (grid[choice1][choice2 - 2] == 'w') { // down-left
					confirmMove = true;
					break;
				} else {
					if (grid[choice1][choice2 - 2] == '.') {
						break;
					}
					choice1++;
					choice2--;
				}
			}
		}
	}

	public void flip() {

		if (player == 'w' && grid[choice1 - 2][choice2 - 1] == 'b') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i - 1][choice2 - 1] == 'b') {
					grid[i - 1][choice2 - 1] = 'w';
				} else {
					if (grid[i][choice2 - 1] != 'b') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 2][choice2 - 1] == 'w') { // up
			for (int i = choice1 - 1; i > 0; i--) {
				if (grid[i - 1][choice2 - 1] == 'w') {
					grid[i - 1][choice2 - 1] = 'b';
				} else {
					if (grid[i][choice2 - 1] != 'w') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1][choice2 - 1] == 'b') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'w') {
					if (grid[i + 1][choice2 - 1] == 'b') {
						grid[i + 1][choice2 - 1] = 'w';
					}
				} else {
					if (grid[i][choice2 - 1] != 'b') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1][choice2 - 1] == 'w') { // down
			for (int i = choice1 - 1; i < 8; i++) {
				if (grid[i][choice2 - 1] == 'b') {
					if (grid[i + 1][choice2 - 1] == 'w') {
						grid[i + 1][choice2 - 1] = 'b';
					}
				} else {
					if (grid[i][choice2 - 1] != 'w') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2 - 2] == 'w') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'b') {
					if (grid[choice1 - 1][i - 1] == 'w') {
						grid[choice1 - 1][i - 1] = 'b';
					}
				} else {
					if (grid[choice1 - 1][i] != 'w') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2 - 2] == 'b') { // left
			for (int i = choice2 - 1; i > 0; i--) {
				if (grid[choice1 - 1][i] == 'w') {
					if (grid[choice1 - 1][i - 1] == 'b') {
						grid[choice1 - 1][i - 1] = 'w';
					}
				} else {
					if (grid[choice1 - 1][i] != 'b') {
						break;
					}
				}
			}
		}

		if (player == 'w' && grid[choice1 - 1][choice2] == 'b') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'w') {
					if (grid[choice1 - 1][i + 1] == 'b') {
						grid[choice1 - 1][i + 1] = 'w';
					}
				} else {
					if (grid[choice1 - 1][i + 1] != 'b') {
						break;
					}
				}
			}
		}

		if (player == 'b' && grid[choice1 - 1][choice2] == 'w') { // right
			for (int i = choice2 - 1; i < 8; i++) {
				if (grid[choice1 - 1][i] == 'b') {
					if (grid[choice1 - 1][i + 1] == 'w') {
						grid[choice1 - 1][i + 1] = 'b';
					}
				} else {
					if (grid[choice1 - 1][i + 1] != 'w') {
						break;
					}
				}
			}
		}

		if (player == 'w' && confirmMove == false) {
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'w') { // up-left
					if (grid[choice1 - 3][choice2 - 3] == 'b') {
						grid[choice1 - 3][choice2 - 3] = 'w';
					}else {
						if (grid[choice1 - 2][choice2 - 2] != 'b') {
							break;
						}
				} 
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'b') {
			while (choice1 > 0 && choice2 > 0) {
				if (grid[choice1 - 2][choice2 - 2] == 'b') { // up-left
					if (grid[choice1 - 3][choice2 - 3] == 'w') {
						grid[choice1 - 3][choice2 - 3] = 'b';
					} else {
						if (grid[choice1 - 2][choice2 - 2] != 'w') {
							break;
						}
				}
					choice1--;
					choice2--;
				}
			}
		}

		if (player == 'b') {
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'b') { // up-right
					if (grid[choice1 - 3][choice2 + 1] == 'w') {
						grid[choice1 - 3][choice2 + 1] = 'b';
					}else {
						if (grid[choice1 - 2][choice2] != 'w') {
							break;
						}
				} 
					choice1--;
					choice2++;
				}
			}
		}

		if (player == 'w') {
			while (choice1 > 0 && choice2 < 8) {
				if (grid[choice1 - 2][choice2] == 'w') { // up-right
					if (grid[choice1 - 3][choice2 + 1] == 'b') {
						grid[choice1 - 3][choice2 + 1] = 'w';
					} else {
						if (grid[choice1 - 2][choice2] != 'b') {
							break;
						}
					}
					choice1--;
					choice2++;
				}
			}
		}

		if (player == 'b') {
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'b') { // down - right
					if (grid[choice1 + 1][choice2 + 1] == 'w') {
						grid[choice1][choice2] = 'b';
					} else {
						if (grid[choice1][choice2] != 'w') {
							break;
						}
				}
					choice1++;
					choice2++;
				}
			}
		}

		if (player == 'w') {
			while (choice1 < 8 && choice2 < 8) {
				if (grid[choice1][choice2] == 'w') { // down - right
					if (grid[choice1 + 1][choice2 + 1] == 'b') {
						grid[choice1][choice2] = 'w';
					} else {
						if (grid[choice1][choice2] != 'b') {
							break;
						}
				}
					choice1++;
					choice2++;
				}
			}
		}

		if (player == 'w') {
			while (choice1 < 8 && choice2 > 0) {
				if (grid[choice1][choice2 - 2] == 'w') { // down-left
					if (grid[choice1 + 1][choice2 - 3] == 'b') {
						grid[choice1][choice2 - 2] = 'w';
					}else {
						if (grid[choice1][choice2 - 2] != 'b') {
							break;
						}
				} 
					choice1++;
					choice2--;
				}
			}
		}

		if (player == 'b' && confirmMove == false) {
			while (choice1 < 8 && choice2 > 0) {
				if (grid[choice1][choice2 - 2] == 'b') { // down-left
					if (grid[choice1 + 1][choice2 - 3] == 'w') {
						grid[choice1][choice2 - 2] = 'b';
					}else {
						if (grid[choice1][choice2 - 2] != 'w') {
							break;
						}
				} 
					choice1++;
					choice2--;
				}
			}
		}
	}
}
