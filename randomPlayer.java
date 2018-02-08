import java.io.IOException;

public class randomPlayer extends Player {

  public randomPlayer(String name, char mark) {

    super(name, mark);
  }


  @Override
  protected boolean play() throws IOException {


    if (board.xWins()) {
			if (mark == LETTER_X)
				System.out.println("\nTHE GAME IS OVER: " + name + " is the winner!");
			else
				System.out.println("\nTHE GAME IS OVER: " + opponent.name + " is the winner!");
		}
		else if (board.oWins()) {
			if (mark == LETTER_O)
				System.out.println("\nTHE GAME IS OVER: " + name + " is the winner!");
			else
				System.out.println("\nTHE GAME IS OVER: " + opponent.name + " is the winner!");
		}
		else if (board.isFull())
			System.out.println("\nTHE GAME IS OVER: The game is a tie!");
		else {
			makeMove();
			board.display();
			return false;
		}
		return true;
	}

  @Override
  protected void makeMove() throws IOException{

		int row = 0, col = 0;
    RandomGenerator rand = new RandomGenerator();
    while(true) {
      row = rand.discrete(0, 2);
      col = rand.discrete(0, 2);
      if (board.getMark(row, col) == ' ') {
        board.addMark(row, col, mark);
        return;
      }
    }
  }
}
