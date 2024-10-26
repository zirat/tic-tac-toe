import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String [] playerAnswer;

    public static void main(String [] args) {
        GameField gameField = new GameField();
        Game game = new Game(gameField);
        game(game);
    }

    public static void game(Game game) {
        GameField gameField = new GameField();
        int exitCode = 2;
        gameField.printHintField();
        while (exitCode != -1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
            try {
                System.out.println("Enter position:");
                playerAnswer = reader.readLine().split(" ");
                while (!game.checkPlayerAnswer(playerAnswer)) {
                    System.out.println("Bad position");
                    System.out.println("Enter position:");
                    playerAnswer = reader.readLine().split(" ");
                }
                gameField.setFieldPosition(Integer.parseInt(playerAnswer[0]), Integer.parseInt(playerAnswer[1]), "X");
                gameField.printCurrentField();
                System.out.println(gameField.checkEqualRows());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            exitCode--;
        }
    }
}
