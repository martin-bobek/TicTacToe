import java.io.IOException;

/**
 * An object which runs a tic-tac-toe game to completion. 
 * The object holds two players and a board, and allows the two players to take turns playing until either one wins, or the game finishes in a tie.
 * @author Martin Bobek
 * @version 1.0
 * @since January 30, 2018
 */
public class Referee {
	/**
	 * The player who plays X marks.
	 */
	private Player xPlayer;
	/**
	 * The player who plays O marks.
	 */
	private Player oPlayer;
	/**
	 * The board on which the game is played.
	 */
	private Board board;
	
	/**
	 * Constructs an empty Referee object.
	 */
	public Referee() {}
	
	
	/**
	 * Runs a game of tic-tac-toe to completion. Adds the opponent to each player object, then allows the players to take turns making moves until the game finishes.
	 * @throws IOException Thrown if console input fails.
	 */
	public void runTheGame() throws IOException {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		
		System.out.println("\nReferee started the game...");
		board.display();
		
		while (true) {
			if (xPlayer.play())
				return;
			if (oPlayer.play())
				return;
		}
	}
	
	/**
	 * Adds the board which the game will be played on.
	 * @param board The board used for the game.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Adds the player who will play O marks.
	 * @param oPlayer The O player.
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	/**
	 * Adds the player who will play X marks.
	 * @param xPlayer The X player.
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
}
