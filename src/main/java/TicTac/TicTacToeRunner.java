package TicTac;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;
import java.util.stream.Collectors;


public class TicTacToeRunner extends Application {
    GameController controller = new GameController();
    Cell[][] cell = new Cell[3][3];
    private Label statusMsg = new Label("X must play");
    GridPane pane;

    public void runNewGame() {
        pane.getChildren().removeAll(pane.getChildren().stream()
                .filter(child -> !child.getTypeSelector().equals("Button") && !child.getTypeSelector().equals("Label"))
                .collect(Collectors.toList()));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell(i, j, this);
                pane.add(cell[i][j], i, j);
            }
        }
        controller.startGame();
        statusMsg.setText("X must play");
    }


    public void start(Stage primaryStage) throws Exception {
        pane = new GridPane();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell(i, j, this);
                pane.add(cell[i][j], i, j);
            }
        }

        Button button = new Button("New game");
        button.setOnAction(e -> runNewGame());

        pane.add(button, 1,3);
        pane.add(statusMsg, 0,3);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);


        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("TicTao");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Cell extends Pane {
        private int x;
        private int y;
        private TicTacToeRunner runner;

        public Cell(int x, int y, TicTacToeRunner runner) {
            setStyle("-fx-border-color: black");
            this.setPrefSize(300, 300);
            this.setOnMouseClicked(e -> handleClick());
            this.x = x;
            this.y = y;
            this.runner = runner;
        }

        public void handleClick() {
            if (runner.controller.getField(x, y).getSign() == Sign.SGN_EMPTY && !controller.isGameEnded()) {
                drawX();
                if (runner.controller.isWinner(x, y, Sign.SGN_CROSS)) {
                    statusMsg.setText("Player with X won!");
                    return;
                } else if (runner.controller.isAllFieldsFilled()) {
                    statusMsg.setText("Draw!");
                    return;
                }

                Random random = new Random();
                int randomNumber = random.nextInt(runner.controller.getTicTacBoard().getListOfEmptyFields().size());
                int xCoor = runner.controller.getTicTacBoard().getListOfEmptyFields().get(randomNumber).getX();
                int yCoor = runner.controller.getTicTacBoard().getListOfEmptyFields().get(randomNumber).getY();
                if (runner.controller.checkIfOneInRowIsEmpty()) {
                    int y = runner.controller.getTicTacBoard().getListOfEmptyFields().stream()
                            .filter(n -> n.getX() == 1)
                            .findAny().get().getY();
                    runner.cell[1][y].drawY();
                    if (runner.controller.isWinner(1, y, Sign.SGN_CRICLE)) {
                        statusMsg.setText("Player with O won!");
                        return;
                    }
                    return;
                }

                runner.cell[xCoor][yCoor].drawY();



                if (runner.controller.isWinner(xCoor, yCoor, Sign.SGN_CRICLE)) {
                    statusMsg.setText("Player with O won!");
                    return;
                }
            }
        }

        public void drawX() {
            Line line1 = new Line(10,10, this.getWidth() - 10, this.getHeight() - 10);
            line1.endXProperty().bind(this.widthProperty().subtract(10));
            line1.endYProperty().bind(this.heightProperty().subtract(10));

            Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
            line2.endXProperty().bind(this.widthProperty().subtract(10));
            line2.startYProperty().bind(this.heightProperty().subtract(10));

            getChildren().addAll(line1, line2);
            runner.controller.fillField(x, y, Sign.SGN_CROSS);
        }

        public void drawY() {
            Ellipse ellipse = new Ellipse(this.getWidth()/2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
            ellipse.centerXProperty().bind(this.widthProperty().divide(2));
            ellipse.centerYProperty().bind(this.heightProperty().divide(2).subtract(2));
            ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
            ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));

            getChildren().addAll(ellipse);
            runner.controller.fillField(x, y, Sign.SGN_CRICLE);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
