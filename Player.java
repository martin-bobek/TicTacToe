import java.io.IOException;

/**
 * Represents a player in the game of tic-tac-toe.
 * Contains methods which obtain the next move from the command line and make a play on the board.
 * @author Martin Bobek
 * @version 1.0
 * @since January 30, 2018 
 *
 */
public abstract class Player implements Constants {
	/**
	 * Name of the player.
	 */
	protected String name;
	/**
	 * The board on which the player is playing.
	 */
	protected Board board;
	/**
	 * The current opponent of the player.
	 */
	protected Player opponent;
	/**
	 * The mark which the player is currently playing. Either 'O' or 'X'.
	 */
	protected char mark;
	
	/**
	 * Creates a new player object, assigning a name and mark to the player.
	 * @param name The name of the player.
	 * @param mark The mark which the player plays. Either 'O' or 'X'
	 */
	protected Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	abstract protected boolean play() throws IOException;
	
	abstract protected void makeMove() throws IOException;
	
	/**
	 * Adds an opponent to the player.
	 * @param opponent The opponent in the current game.
	 */
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	/**
	 * Adds the board on which the game will be played.
	 * @param theBoard The board for the current game.
	 */
	public void setBoard(Board theBoard) {
		board = theBoard;
	}
}
