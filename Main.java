import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String playerAnswer;

    public static void main(String [] args) {
        GameField gameField = new GameField();
        Game game = new Game(gameField);
        System.out.println("Hint");
        gameField.setFieldPosition(1, 0, "X");
        gameField.setFieldPosition(1, 1, "X");
        gameField.setFieldPosition(1, 2, "X");

        gameField.printHintField();
        gameField.printCurrentField();

        System.out.println("Rows:" + gameField.checkEqualRows());
        System.out.println("Columns: " + gameField.checkEqualColumns());
        //System.out.println(game.checkGameOver());
    }

    public static void game() {
        GameField gameField = new GameField();
        int exitCode = 2;
        while (exitCode != -1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
            try {
                playerAnswer = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            exitCode--;
        }
    }
}
