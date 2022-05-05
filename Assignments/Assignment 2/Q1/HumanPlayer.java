public class HumanPlayer implements Player {
        public void play (TicTacToeGame game) {
		int lvl = game.getLevel();
		do{game.play(Integer.parseInt(Utils.console.readLine())-1);//recoit l'input de l'humain et le joue
		}while (lvl == game.getLevel());
	}
}