package reversi;

import java.util.Scanner;

public class Board {
	char player = 'w';
	char[][] grid = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'w', 'b', '.', '.', '.' },
			{ '.', '.', '.', 'b', 'w', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };

	public static void main(String[] args) {
		Board myObject = new Board();
		myObject.boardLayout();
	}

	public void boardLayout() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println("");
		}
		boardCheck();
		chooseMove();
	}

	public void boardCheck() {
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
		int choice1;
		int choice2;
		Scanner userNumbers = new Scanner(System.in);
		System.out.println("number1");
		choice1 = userNumbers.nextInt();
		Scanner userNumbers2 = new Scanner(System.in);
		System.out.println("number2");
		choice2 = userNumbers2.nextInt();
		grid[choice1 - 1][choice2 - 1] = player;
		currentPlayer();
		boardLayout();
		userNumbers.close();
		userNumbers2.close();
	}

	public void currentPlayer() {
		if (player == 'w') {
			player = 'b';
		} else {
			player = 'w';
		}
	}
	
	public void validMove() {
		
	}
}