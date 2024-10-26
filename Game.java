public class Game {
    GameField gameField;

    public Game(GameField gameField) {
        this.gameField = gameField;
    }
    /*
    public boolean checkGameOver() {
        for (int i = 0; i < gameField.; i++) {

        }
        return false;
    }*/

    public boolean checkPlayerAnswer (String [] playerAnswer) {
        return playerAnswer.length == 2 &&
                checkCoordinate(Integer.parseInt(playerAnswer[0])) &&
                checkCoordinate(Integer.parseInt(playerAnswer[0]));
    }

    private boolean checkCoordinate(int c) {
        return c == 0 || c == 1 || c == 2;
    }
}
