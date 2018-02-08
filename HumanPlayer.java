import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, char mark) {
		super(name, mark);
	}

	/**
	 * Asks the player where the next mark should be placed and adds it to the board. If the player enters invalid input, they are asked to re-enter it until a mark has been placed.
	 * @throws IOException Thrown when text input from console fails.
	 */
	@Override
	protected void makeMove() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String response;
		int row = 0, col = 0;
		boolean successful;

		do {
			do {
				successful = true;
				System.out.print("\n" + name + ", in what row should your next " + mark + " be placed? ");
				response = input.readLine().trim();
				try {
					row = Integer.parseInt(response);
					if (row < 0 || row > 2)
						successful = false;
				} catch (Exception e) {
					successful = false;
				}
				if (!successful)
					System.out.printf("Invalid input entered!");
			} while(!successful);

			do {
				successful = true;
				System.out.print("\n" + name + ", in what column should your next " + mark + " be placed? ");
				response = input.readLine().trim();
				try {
					col = Integer.parseInt(response);
					if (col < 0 || col > 2)
						successful = false;
				} catch (Exception e) {
					successful = false;
				}
				if (!successful)
					System.out.print("Invalid input entered!");
			} while(!successful);

			if (board.getMark(row, col) != ' ') {
				System.out.println("Cannot place mark since the specified square is not empty!");
				successful = false;
			}
		} while(!successful);

		board.addMark(row, col, mark);
	}
}
