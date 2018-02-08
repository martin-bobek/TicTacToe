import java.io.IOException;

public class BlockingPlayer extends RandomPlayer {
	BlockingPlayer(String name, char mark) {
		super(name, mark);
	}
	
	@Override
	protected void makeMove() throws IOException{
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (testForBlocking(row, col)) {
					board.addMark(row, col, mark);
					return;
				}
			}
		}
		super.makeMove();
	}
	
	protected boolean testForBlocking(int row, int col) {
		if (board.getMark(row, col) != SPACE_CHAR)
			return false;
		return (checkColumn(col, opponent.mark) || checkRow(row, opponent.mark) || 
				checkForwardDiagonal(row, col, opponent.mark) || checkBackDiagonal(row, col, opponent.mark)); 
	}
	
	protected boolean checkColumn(int col, char mark) {
		int spaces = 0, marks = 0;
		for (int row = 0; row < 3; row++) {
			if (board.getMark(row, col) == SPACE_CHAR)
				spaces++;
			else if (board.getMark(row, col) == mark)
				marks++;
		}
		return (marks == 2 && spaces == 1);
	}
	
	protected boolean checkRow(int row, char mark) {
		int spaces = 0, marks = 0;
		for (int col = 0; col < 3; col++) {
			if (board.getMark(row, col) == SPACE_CHAR)
				spaces++;
			else if (board.getMark(row, col) == mark)
				marks++;
		}
		return (marks == 2 && spaces == 1);
	}
	
	protected boolean checkForwardDiagonal(int row, int col, char mark) {
		if (row + col != 2)
			return false;
		int spaces = 0, marks = 0;
		for (int i = 0; i < 3; i++) {
			if (board.getMark(i, 2 - i) == SPACE_CHAR)
				spaces++;
			else if (board.getMark(i, 2 - i) == mark)
				marks++;
		}
		return (marks == 2 && spaces == 1);
	}
	
	protected boolean checkBackDiagonal(int row, int col, char mark) {
		if (row != col)
			return false;
		int spaces = 0, marks = 0;
		for (int i = 0; i < 3; i++) {
			if (board.getMark(i, i) == SPACE_CHAR)
				spaces++;
			else if (board.getMark(i, i) == mark)
				marks++;
		}
		return (marks == 2 && spaces == 1);
	}
}
