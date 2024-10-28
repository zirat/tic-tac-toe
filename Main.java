import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * TODO
 *  1. Fix game crash when all field are taken and there is no winner
 *
 */

public class Main {
    public static String [] playersCoordinates;

    public static void main(String [] args) {
        GameField gameField = new GameField();
        Game game = new Game(gameField);
        game(game);
    }

    public static void game(Game game) {
        GameField gameField = new GameField();
        int exitCode = 0;
        gameField.printHintField();
        // while (!game.gameOver(gameField)) {
        while (exitCode != -1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
            try {
                System.out.println("Enter position:");
                playersCoordinates = reader.readLine().split(" ");

                // checking player's answer
                // ask player until coordinates are correct
                while ( !game.checkPlayerAnswer(playersCoordinates) ||
                        !gameField.checkEmptyField(Integer.parseInt(playersCoordinates[0]), Integer.parseInt(playersCoordinates[1]))) {
                    System.out.println("Bad position");
                    System.out.println("Enter position:");
                    playersCoordinates = reader.readLine().split(" ");
                }

                // set player's symbol X on position x,y
                gameField.setFieldPosition(Integer.parseInt(playersCoordinates[0]), Integer.parseInt(playersCoordinates[1]), "X");
                gameField.printCurrentField();

                // wait 1 second to imitate computer's thinking of next step
                TimeUnit.SECONDS.sleep(1);

                // compute next computer step depending on already taken positions
                int [] computedCoordinates = game.computeNextTurn(gameField);
                // computer's next turn/step
                gameField.setFieldPosition(computedCoordinates[0], computedCoordinates[1], "O");
                gameField.printCurrentField();

                // check if gameOver
                if (Objects.equals(game.gameOver(gameField), "X")) {
                    System.out.println("You win! Go dance!");
                    exitCode = -1;
                } else if (Objects.equals(game.gameOver(gameField), "O")) {
                    System.out.println("You lose, Andrey Kan! Go cry to mommy, you silly 4ck!");
                    exitCode = -1;
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
