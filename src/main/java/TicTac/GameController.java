package TicTac;

public class GameController {
    private Board ticTacBoard;


    public GameController() {
        ticTacBoard = new Board();
    }

    public void startGame() {
        ticTacBoard = new Board();
    }

    public Field getField(int x, int y) {
        return ticTacBoard.getField(x, y);
    }

    public void fillField (int x, int y, Field symbol) {
        ticTacBoard.fillField(x, y, symbol);
    }

    public boolean checkRows (int x, Field symbol) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            if (ticTacBoard.getField(x, i) != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumns(int y, Field symbol) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            if (ticTacBoard.getField(i, y) != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkLeftDiagonal(Field symbol) {
        if (ticTacBoard.getField(2,0) != symbol ||
            ticTacBoard.getField(1,1) != symbol ||
            ticTacBoard.getField(0,2) != symbol) {
            return false;
        }
        return true;
    }

    public boolean checkRightDiagonal(Field symbol) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            if (ticTacBoard.getField(i,i) != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal (int x, int y, Field symbol) {
        if ((x + y) % 2 !=0) {
            return false;
        }

        return checkLeftDiagonal(symbol) || checkRightDiagonal(symbol);
    }

    public boolean isWinner(int x, int y, Field symbol) {
        if (checkRows(x, symbol) || checkColumns(y, symbol) || checkDiagonal(x, y, symbol)) {
            endGame();
            return true;
        } else {
            return false;
        }
    }

    public boolean isAllFieldsFilled() {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for(int j = 0; j < Board.BOARD_SIZE; j++) {
                if (ticTacBoard.getField(i, j) == Field.FLD_EMPTY){
                    return false;
                }
            }
        }
        endGame();
        return true;

    }

    public void endGame() {
        ticTacBoard.block();
    }

    public boolean isGameEnded() {
        return ticTacBoard.isBlocked();
    }

}
