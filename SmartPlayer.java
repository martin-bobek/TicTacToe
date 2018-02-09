import java.io.IOException;

public class SmartPlayer extends BlockingPlayer {

  SmartPlayer(String name, char mark) {
		super(name, mark);
	}

  @Override
  protected void makeMove() throws IOException {

    for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
        if(testForWin(row, col)) {
          board.addMark(row, col ,mark);
          return;
        }
      }
    }
    super.makeMove();
  }


  protected boolean testForWin(int row, int col) {

    if (board.getMark(row, col) != SPACE_CHAR)
			return false;
		return (super.checkColumn(col, mark) || super.checkRow(row, mark) ||
				super.checkForwardDiagonal(row, col, mark) ||
        super.checkBackDiagonal(row, col, mark));
	}
}
