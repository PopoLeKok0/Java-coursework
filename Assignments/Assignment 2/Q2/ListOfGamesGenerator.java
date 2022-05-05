import java.util.LinkedList;

public class ListOfGamesGenerator {
	

   /**
	* generates all different games for the specified
	* parameters. Each game is recorded only once. 
	* once a game is finished, it is not extended further
	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
    * @return
    * a list of lists of game instances, ordered by levels
  	*/
	public static LinkedList<LinkedList<TicTacToeGame>> generateAllGames(int lines, int columns, int winLength){

		TicTacToeGame Default = new TicTacToeGame(lines,columns,winLength);
		LinkedList<TicTacToeGame> lvl1 = new LinkedList<TicTacToeGame>();
		LinkedList<LinkedList<TicTacToeGame>> main = new LinkedList<LinkedList<TicTacToeGame>>();
		main.add(lvl1);
		lvl1.add(Default);

		boolean ended = false;
		while (!ended){
			LinkedList<TicTacToeGame> leDernier = main.getLast();
			LinkedList<TicTacToeGame> newlvl = new LinkedList<TicTacToeGame>();
			ended = true;
			for (int i=0; i<leDernier.size();i++){
				TicTacToeGame board = leDernier.get(i);
				if (board.getGameState() == GameState.PLAYING){
					ended = false;
					for (int j=0; j<lines*columns;j++){
						if (board.valueAt(j)==CellValue.EMPTY){
							TicTacToeGame newBoard = new TicTacToeGame(board, j);
							boolean copie = newlvl.contains(newBoard);
							if (!copie){
								newlvl.add(newBoard);
							}
						}
					}
				}
			}
			if (!ended){
				main.add(newlvl);
			}
		}

		return main;
	}
}