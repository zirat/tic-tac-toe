import java.util.Objects;

public class GameField {

    private final String[][] hintField;

    private final String[][] field;

    public GameField() {
        int FIELD_X = 3;
        int FIELD_Y = 3;
        this.field = new String[FIELD_X][FIELD_Y];
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = " ";
            }
        }
        this.hintField = new String[FIELD_X][FIELD_Y];
        for (int i = 0; i < hintField.length; i++) {
            for (int j = 0; j < hintField[1].length; j++) {
                hintField[i][j] = i+1 + ":" + String.valueOf(j+1);
            }
        }
    }

    public void setFieldPosition(int x, int y, String symbol){
        this.field[x][y] = symbol;
    }

    public boolean checkEmptyField(int x, int y) {
        return Objects.equals(field[x][y], " ");
    }

    public void printCurrentField(){
       this.print(this.field);

    }

    public void printHintField() {
        print(this.hintField);
    }

    public void print(String[][]table){
        int lineLength = table[0][0].length() * 3 + 6;
        printLine(lineLength);
        for (String[] strings : table) {
            System.out.print("| ");
            for (int symbolPosition = 0; symbolPosition < table[0].length; symbolPosition++) {
                System.out.print(strings[symbolPosition]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        printLine(lineLength);
    }

    public void printLine(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public boolean checkEqualRows() {
        for (int i = 0; i < field.length; i++) {
            if (    !Objects.equals(field[i][0], " ") &&
                    Objects.equals(field[i][0], field[i][1]) &&
                    Objects.equals(field[i][1], field[i][2])    ) {
                System.out.println(field[i][0] + " = " + field[i][1] + " = " + field[i][2]);
                return true;
            }
        }
        return false;
    }

    public boolean checkEqualColumns(){
        for (int i = 0; i < field.length; i++) {
            if (    !Objects.equals(field[0][i], " ") &&
                    Objects.equals(field[0][i], field[1][i]) &&
                    Objects.equals(field[1][i], field[2][i])    ) {
                System.out.println(field[0][i] + " = " + field[1][i] + " = " + field[2][i]);
                return true;
            }
        }
        return false;
    }

    public boolean checkEqualDiagonals() {
        return false;
    }

    public String[][] getField() {
        return this.field;
    }
}
