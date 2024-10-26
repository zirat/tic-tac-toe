import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Main {
    public static String [] playersCoordinates;

    public static void main(String [] args) {
        GameField gameField = new GameField();
        Game game = new Game(gameField);
        game(game);
    }

    public static void game(Game game) {
        GameField gameField = new GameField();
        int exitCode = 2;
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
                // set computer's symbol O on position random(x), random(y) except the already taken positions
                // first option
                // try random x y, until checkEmptyField() returns true and then set symbol on position
                // not implemented

                // second option
                // compute empty positions and choose right x y

                int [] computedCoordinates = game.computeNextTurn(gameField);
                gameField.setFieldPosition(computedCoordinates[0], computedCoordinates[1], "O");
                gameField.printCurrentField();
                System.out.println(gameField.checkEqualRows());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            exitCode--;
        }
    }
}
