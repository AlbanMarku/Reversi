package reversi;

public class Board {
	char player = 'w';
	char otherPlayer = 'b';
	char[][] grid = {{ '.', '.', '.', '.', '.', '.', '.', '.' },{ '.', '.', '.', '.', '.', '.', '.', '.' },{ '.', '.', '.', '.', '.', '.', '.', '.' },{ '.', '.', '.', 'w', 'b', '.', '.', '.' },{ '.', '.', '.', 'b', 'w', '.', '.', '.' },{ '.', '.', '.', '.', '.', '.', '.', '.' },{ '.', '.', '.', '.', '.', '.', '.', '.' },{ '.', '.', '.', '.', '.', '.', '.', '.' }};
	
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
		Board checkSpace = new Board();
		checkSpace.boardCheck();
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
//			winCondition();
		}
		else {
			System.out.println("Not full");
		}
	}

//	public void winCondition() {
//		if (grid[row][col] == '1') {
//			
//		}
//	}




}