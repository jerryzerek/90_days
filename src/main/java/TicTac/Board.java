package TicTac;

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
                fields[i][j] = Field.FLD_EMPTY;
            }
        }
    }

    public void fillField(int x, int y, Field symbol) {
        fields[x][y] = symbol;
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
