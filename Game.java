public class Game {
    GameField gameField;

    public Game(GameField gameField) {
        this.gameField = gameField;
    }


    public boolean gameOver(GameField gameField) {
        return gameField.checkEqualRows() || gameField.checkEqualColumns() || gameField.checkEqualDiagonals();
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
        int [] nextTurn = new int[2];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (gameField.checkEmptyField(i, j)) {
                    nextTurn[0] = i;
                    nextTurn[1] = j;
                    return nextTurn;
                }
            }
        }
        return nextTurn;
    }
}
