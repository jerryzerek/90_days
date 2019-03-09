package TicTac;

import java.util.ArrayList;
import java.util.List;

public class Board {
    Field[][] fields;
    private boolean blocked;
    public static final int BOARD_SIZE = 3;


    public Board() {
        fields = new Field[BOARD_SIZE][BOARD_SIZE];
        clean();
    }

    public void clean () {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j =0; j < BOARD_SIZE; j++) {
                fields[i][j] = new Field(i, j, Sign.SGN_EMPTY);
            }
        }
    }

    public List<Field> getListOfEmptyFields() {
        List<Field> listOfEmptyFields = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (fields[i][j].getSign() == Sign.SGN_EMPTY) {
                    listOfEmptyFields.add(new Field(i, j, Sign.SGN_EMPTY));
                }
            }
        }
        return listOfEmptyFields;
    }


    public void fillField(int x, int y, Sign symbol) {
        fields[x][y] = new Field(x, y, symbol);
    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }

    public void block() {
        blocked = true;
    }

    public boolean isBlocked() {
        return blocked;
    }
}
