import java.io.IOException;

public class RandomPlayer extends Player {

  public RandomPlayer(String name, char mark) {

    super(name, mark);
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
