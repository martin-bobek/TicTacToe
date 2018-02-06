import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Creates and holds the objects necessary to run a game of tick-tack-toe. Contains a main function which initiates and runs a game of 
 * tick-tack-toe on the command line.
 * 
 * @author ENSF409 Instructor
 * @version 1.0
 * @since January 29, 2018
 *
 */
public class Game implements Constants {
	/**
	 * The board on which the game is played.
	 */
	private Board theBoard;
	/**
	 * The referee who runs and controls the game play.
	 */
	private Referee theRef;
	
	/**
	 * Constructs a new game object. Creates a new board on which the
	 * game will be played.
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    
    /**
     * Adds a referee to the game, and gets the referee to start the game-play. The function returns once the game finishes
     * @param r The referee who will run the game.
     * @throws IOException Thrown when input from the command line fails.
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /**
     * The main function which initializes and plays a game of tick-tack-toe between two players. It first creates two Player objects, 
     * getting the names of the players from the command line. A board and referee are then created and the game is started. 
     * @param args command line arguments. Not used by this method. 
     * @throws IOException Thrown when input from the command line fails.
     */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
}
