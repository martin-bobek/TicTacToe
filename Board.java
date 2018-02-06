/**
 * Provides the functionality of a board in the game tick-tack-toe. 
 * Methods are provided to add marks to the board, check the state of 
 * squares on the board, check if there is a winner, and print the board to 
 * the command line.
 * 
 * @author ENSF409 Instructor
 * @version 1.0
 * @since January 29, 2018
 *
 */
public class Board implements Constants {
	/**
	 * A 2D array containing the state of each of the 9 squares on
	 * the board.
	 */
	private char theBoard[][];
	/**
	 * Number of marks played on the board.
	 */
	private int markCount;

	/**
	 * Constructs a new board. A new 3x3 board is generated, with all
	 * the squares initialized to empty (no marks have been played).
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * Gets the mark currently on the board on a particular square.
	 * @param row The row of the square to get.
	 * @param col The column of the square to get.
	 * @return The value of the square. Either ' ' (square is empty), 'X', or 'O'.
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Checks if all the squares have been filled by marks.
	 * @return true if all 9 squares are filled. Otherwise false.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks if player x has won the game.
	 * @return true if player x has won. Otherwise false.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks if player o has won the game.
	 * @return true if player o has won. Otherwise false.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the current state if the board on the command line. Creates a nicely formatted table with three rows and columns, filling
	 * each square with the an empty space or the mark played on that square.
	 */
	public void display() {
		System.out.println();
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds a mark to a square on the board.
	 * @param row Row on which the mark should be added.
	 * @param col Column on which the mark should be added.
	 * @param mark The mark to be placed. Either 'X' or 'O'.
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Resets the board to its original state, with all squares empty.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks to see if there is a line of 3 of a particular mark on the board. 
	 * @param mark The mark being checked.
	 * @return 1 if there is a winning line of 3. Otherwise 0.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Displays on the command line the headers for the columns of the board.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println("|");
	}

	/**
	 * Displays on the command line the separators for the rows in the board.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Creates a line of spaces on the command line inside the rows of the board. One such line is printed between every
	 * mark and row separator.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
