public class ComputerRandomPlayer extends Utils implements Player{

    public void play(TicTacToeGame game){
        if(game.getGameState() != GameState.PLAYING){
            System.out.println("the game is not currently playable.");
        }else{boolean played = false;
            while (!played){
                int valeur;
                valeur = generator.nextInt(game.columns*game.lines);
                if ((valeur < (game.columns * game.lines))  && (valeur >= 0) && (game.valueAt(valeur) == CellValue.EMPTY)){
                    played = true;
                    game.play(valeur);
                }

                else if (game.getGameState() != GameState.PLAYING){
                    break;
                }
            }
        }    
    }   
}