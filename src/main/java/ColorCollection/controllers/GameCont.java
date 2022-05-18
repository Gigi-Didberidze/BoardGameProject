package ColorCollection.controllers;

import ColorCollection.models.BoardGameModel;
import ColorCollection.models.PlayerModel;
import ColorCollection.models.ResultModel;
import javafx.application.Platform;
import javafx.beans.binding.ObjectBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class GameCont {
    @FXML
    private GridPane board;

    @FXML
    private Text playerTurnText;

    @FXML
    private Text winnerNameText;

    BoardGameModel model = new BoardGameModel();

    PlayerModel playerModel = new PlayerModel();

    ResultModel resultModel = new ResultModel();
    @FXML
    private void initialize() {
        for (var i = 0; i < board.getRowCount(); i++) {
            for (var j = 0; j < board.getColumnCount(); j++) {
                var square = createSquare(i,j);
                board.add(square, j, i);
            }
        }
        Platform.runLater(
                ()-> {
                    playerTurnText.setText(playerModel.getPlayerOneName() + "'s turn!");
                    winnerNameText.setText("");
                });

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
            resultModel.setPlayerOneName(playerModel.getPlayerOneName());
            resultModel.setPlayerTwoName(playerModel.getPlayerTwoName());
            resultModel.setStartingDateAndTime(model.startingDateAndTime);
            if(playerModel.getFirstPlayersTurn()) {
                resultModel.setWinner(playerModel.getPlayerOneName());
            }else{
                resultModel.setWinner(playerModel.getPlayerTwoName());
            }
            winnerNameText.setText(resultModel.getWinner() + " Wins!!");
            System.out.println(resultModel.getStartingDateAndTime());
        }
        else if(!model.isGoalState() && model.getNumberOfStones() == 11){
            System.out.println("DRAW");
            winnerNameText.setText("Draw!");
        }
    }

    @FXML
    void endTurnPressed(ActionEvent event) {
        //change the player
        if (playerModel.getFirstPlayersTurn()){
            playerTurnText.setText(playerModel.getPlayerTwoName() + "'s Turn!");
        }else{
            playerTurnText.setText(playerModel.getPlayerOneName() + "'s Turn!");
        }
        resultModel.setNumberOfMoves(resultModel.getNumberOfMoves()+1);
        model.changePlayer(playerModel);

    }

}
