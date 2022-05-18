package ColorCollection.controllers;

import ColorCollection.models.BoardGameModel;
import ColorCollection.models.PlayerModel;
import javafx.beans.binding.ObjectBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class GameCont {
    @FXML
    private GridPane board;

    BoardGameModel model = new BoardGameModel();

    PlayerModel playerModel = new PlayerModel();
    @FXML
    private void initialize() {
        for (var i = 0; i < board.getRowCount(); i++) {
            for (var j = 0; j < board.getColumnCount(); j++) {
                var square = createSquare(i,j);
                board.add(square, j, i);
            }
        }
    }

    private StackPane createSquare(int i, int j) {
        var square = new StackPane();
        square.getStyleClass().add("square");
        var piece = new Circle(50);

        piece.fillProperty().bind(
                new ObjectBinding<Paint>() {
                    {
                        super.bind(model.squareProperty(i, j));
                    }
                    @Override
                    protected Paint computeValue() {
                        return switch (model.squareProperty(i, j).get()) {
                            case EMPTY -> Color.TRANSPARENT;
                            case RED -> Color.RED;
                            case BLUE -> Color.BLUE;
                            case YELLOW -> Color.YELLOW;
                            case GREEN -> Color.GREEN;
                        };
                    }
                }
        );
        square.getChildren().add(piece);
        square.setOnMouseClicked(this::handleMouseClick);
        return square;
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        var square = (StackPane) event.getSource();
        var row = GridPane.getRowIndex(square);
        var col = GridPane.getColumnIndex(square);
        //System.out.printf("Click on square (%d,%d)%n", row, col);
        model.move(playerModel, row, col);
        System.out.println(model.toString());
        if(model.isGoalState()){
            System.out.println("WIN");
        }
    }

    @FXML
    void endTurnPressed(ActionEvent event) {
        //change the player
        model.changePlayer(playerModel);
    }

}
