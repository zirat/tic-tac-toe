import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    GameField gameField;

    public Game(GameField gameField) {
        this.gameField = gameField;
    }

    /*
    * TODO
    *  1. Refactor dis $hit
    * */
    public String gameOver(GameField gameField) {
        if (gameField.checkWinForSymbol("X")) {
            return "X";
        } else if (gameField.checkWinForSymbol("O")) {
            return "O";
        } else {
            return " ";
        }
    }

    public boolean checkPlayerAnswer (String [] playerAnswer) {
        return playerAnswer.length == 2 &&
                checkCoordinate(Integer.parseInt(playerAnswer[0])) &&
                checkCoordinate(Integer.parseInt(playerAnswer[0]));
    }

    private boolean checkCoordinate(int c) {
        return c == 0 || c == 1 || c == 2;
    }

    public int[] computeNextTurn(GameField gameField) {
        String [][] field = gameField.getField();
        List <Integer> freeXCoordinates = new ArrayList<>();
        List <Integer> freeYCoordinates = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (gameField.checkEmptyField(i, j)) {
                    freeXCoordinates.add(i);
                    freeYCoordinates.add(j);
                }
            }
        }
        /*
        * TODO
        *  1. Refactor - use pairs of coordinates, not different lists*/
        int randomPair = random.nextInt(freeXCoordinates.size());
        return new int[]{freeXCoordinates.get(randomPair), freeYCoordinates.get(randomPair)};
    }
}
