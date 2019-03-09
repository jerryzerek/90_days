package TicTac;

import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

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

    public void fillField (int x, int y, Sign symbol) {
        ticTacBoard.fillField(x, y, symbol);
    }

    public Board getTicTacBoard() {
        return ticTacBoard;
    }

    public boolean checkRows (int x, Sign symbol) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            if (ticTacBoard.getField(x, i).getSign() != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumns(int y, Sign symbol) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            if (ticTacBoard.getField(i, y).getSign() != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfOneInRowIsEmpty() {
        int counterOfEmptyFields = 0;
        int counterOfCircles = 0;
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (ticTacBoard.getField(1, j).getSign() == Sign.SGN_EMPTY) {
                    counterOfEmptyFields++;
                }
                if (ticTacBoard.getField(1, j).getSign() == Sign.SGN_CRICLE){
                    counterOfCircles++;
                }
            }
        return (counterOfEmptyFields == 1 && counterOfCircles == 2);
    }



    public boolean checkLeftDiagonal(Sign symbol) {
        if (ticTacBoard.getField(2,0).getSign() != symbol ||
            ticTacBoard.getField(1,1).getSign() != symbol ||
            ticTacBoard.getField(0,2).getSign() != symbol) {
            return false;
        }
        return true;
    }

    public boolean checkRightDiagonal(Sign symbol) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            if (ticTacBoard.getField(i,i).getSign() != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal (int x, int y, Sign symbol) {
        if ((x + y) % 2 !=0) {
            return false;
        }

        return checkLeftDiagonal(symbol) || checkRightDiagonal(symbol);
    }

    public boolean isWinner(int x, int y, Sign symbol) {
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
                if (ticTacBoard.getField(i, j).getSign() == Sign.SGN_EMPTY){
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
