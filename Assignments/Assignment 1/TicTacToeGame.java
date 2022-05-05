/**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToeGame {

// FINISH THE VARIABLE DECLARATION
   /**
	* The board of the game, stored as a one dimension array.
	*/
	private CellValue[] board;

   /**
	* level records the number of rounds that have been
	* played so far.
	*/
	private int level = 0;

   /**
	* gameState records the current state of the game.
	*/
	private GameState gameState = GameState.PLAYING;


   /**
	* lines is the number of lines in the grid
	*/
	private int lines;

   /**
	* columns is the number of columns in the grid
	*/
	private int columns;


   /**
	* sizeWin is the number of cell of the same type
	* that must be aligned to win the game
	*/
	private int sizeWin;

   /**
	* default constructor, for a game of 3x3, which must
	* align 3 cells
	*/
	public TicTacToeGame(){
		lines =columns= sizeWin= 3;

		board = new CellValue[9];
		for (int i=0; i<board.length; i++){
			//initialise des empty cells
			board[i] = CellValue.EMPTY;
		}

	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game. 3 cells must
	* be aligned.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
  	*/
	public TicTacToeGame(int lines, int columns){

		this.lines = lines; this.columns = columns; sizeWin = 3;

		//Set up 
		board = new CellValue[lines*columns];
		for (int i=0; i<board.length; i++){
			// initialise des empty cells
			board[i] = CellValue.EMPTY;
		}

	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game, as well as
	* the number of cells that must be aligned to win.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
  	*/
	public TicTacToeGame(int lines, int columns, int sizeWin){
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;

		//fait le set up 
		board = new CellValue[lines*columns];

		// initialise les cells pour qu'ils deviennent EMPTY
		for (int i=0; i<board.length; i++){
			board[i] = CellValue.EMPTY;
		}
	}



   /**
	* getter for the variable lines
	* @return
	* 	the value of lines
	*/
	public int getLines(){

		return this.lines;

	}

   /**
	* getter for the variable columns
	* @return
	* 	the value of columns
	*/
	public int getColumns(){

		return this.columns;

	}

   /**
	* getter for the variable level
	* @return
	* 	the value of level
	*/
	public int getLevel(){

		return this.level;

	}

  	/**
	* getter for the variable sizeWin
	* @return
	* 	the value of sizeWin
	*/
	public int getSizeWin(){

		return this.sizeWin;

	}

   /**
	* getter for the variable gameState
	* @return
	* 	the value of gameState
	*/
	public GameState getGameState(){

		return gameState;

	}

   /**
	* returns the cellValue that is expected next,
	* in other word, which player (X or O) should
	* play next.
	* This method does not modify the state of the
	* game.
	* @return
    *  the value of the enum CellValue corresponding
    * to the next expected value.
  	*/
	public CellValue nextCellValue(){
		if(level%2==0){
			return CellValue.X;
		} else {
			return CellValue.O;
		}
	}

   /**
	* returns the value  of the cell at
	* index i.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
   	* @param i
    *  the index of the cell in the array board
    * @return
    *  the value at index i in the variable board.
  	*/
	public CellValue valueAt(int i) {
		if (i>=(lines*columns)){
			System.out.println("Erreur: indexe invalide");
			return null;
		} else {
			return board[i];
		}

	}

   /**
	* This method is called when the next move has been
	* decided by the next player. It receives the index
	* of the cell to play as parameter.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
	* If the chosen cell is not empty, an error message is
	* printed out. The behaviour is then unspecified
	* If the move is valide, the board is updated, as well
	* as the state of the game.
	* To faciliate testing, is is acceptable to keep playing
	* after a game is already won. If that is the case, the
	* a message should be printed out and the move recorded.
	* the  winner of the game is the player who won first
   	* @param i
    *  the index of the cell in the array board that has been
    * selected by the next player
  	*/
	public void play(int i) {


		if (i>=(lines*columns)){
			System.out.println("The value should be between 1 and "+(lines*columns));
			return;
		}
		if (board[i] != CellValue.EMPTY) {
			System.out.println("Cell is not empty, try again");
			return;
      } else {
			board[i] = nextCellValue();
			level++;
		}
		if (gameState == GameState.PLAYING) {
			setGameState(i);
		}
	}

   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set in
	* the method play(int i)
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (i.e. the game was playing). Therefore, it only needs to 
	* check if playing at index i has concluded the game, and if
	* set the oucome correctly
	* 
   	* @param i
    *  the index of the cell in the array board that has just 
    * been set
  	*/


	private void setGameState(int i){
		if (setGameStateHelper(i)) {
			if (board[i] == CellValue.X) {
				gameState = GameState.XWIN;
				return;
			}
			else if (level == board.length) {
			   gameState = GameState.DRAW;
		   }
			else {
				gameState = GameState.OWIN;
				return;
			}
			
		}
   }

	/**
	 * A helper method that determines if the game state
	 * 
	 * @param i, the index of the cell in the array board that has just been set
	 * @return whether or not the play won the game
	 */

	private boolean setGameStateHelper(int i) {
		return findWinner(i,i,-1,-columns+1);
	}

   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	* 
   	* @return
    *  String representation of the game
  	*/
  	public String toString(){
		String ch="";
		for (int i=0; i<lines; i++){
			for (int k=0; k<columns; k++){
				switch(board[i*columns+k]){
					case O:
						ch+=" O ";
						break;
					case X:
						ch+=" X ";
						break;
					case EMPTY:
						ch+="   ";
						break;
				}
				if (((k+1)%columns!=0)){
					ch+="|";
				}else{
					ch+="\n";
				}
			}
			if (i<lines-1){
				ch+="---";
				for (int j=0; j<columns-1; j++){
					ch+="----";
				}
			}
			ch+="\n";
		}
		return ch;
	}
   public boolean findWinner(int a, int i, int counter, int increment) {
	   if ((a < 0)||(a >= board.length)||(board[a] != board[i])) {
			//Pour trouver le 1er indexe
			if (increment>0) {
				//trouve la win condition
				if (counter>=sizeWin) {
					return true;
				}
				//for horizontal checking
				if (increment==columns+1) {
					return findWinner(i,i,-1,-1);
				}
				//cas finale du check horizontal
				if (increment==1) {
					return false;
				}
				return findWinner(i,i,-1,-increment-1);
			}
			//check du 1er indexe avec un increment positif
			return findWinner(i,i,counter,-increment);
		}
		//récursivité
		return findWinner(a+increment,i,++counter,increment);
	}
}