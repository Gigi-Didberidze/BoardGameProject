package ColorCollection.models;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public class BoardGameModel {
    public static int BOARD_SIZE = 4;

    private ReadOnlyObjectWrapper<Square>[][] board = new ReadOnlyObjectWrapper[BOARD_SIZE][BOARD_SIZE];

    public BoardGameModel() {
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new ReadOnlyObjectWrapper<Square>(Square.EMPTY);
            }
        }
    }

    public ReadOnlyObjectProperty<Square> squareProperty(int i, int j) {
        return board[i][j].getReadOnlyProperty();
    }

    public Square getSquare(int i, int j) {
        return board[i][j].get();
    }

    public void move(PlayerModel playerModel,int i, int j) {
        //change the color of the circle
        //check if it goal state
        setSquareColor(playerModel,i,j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                sb.append(board[i][j].get().ordinal()).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

  /*
    new method goal state (BoardGameModel model){
    check if the board has reached the ending.
    for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                board[i][j].get().ordinal()
    if model.contains (1,2,3,4) {
        return true;
    }
    }
     */
    public boolean columnGoalCheck(){
        int count;
        for(var j = 0; j < BOARD_SIZE ;j++){
            count = 0;
            for(var i = 0 ; i < BOARD_SIZE; i++){
                ReadOnlyObjectWrapper<Square> currentCell = board[i][j];

                if (i==0){
                    ReadOnlyObjectWrapper<Square> nextCell = board[i+1][j];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != nextCell.getValue()){
                        count++;
                    }
                }
                else if (i==1){
                    ReadOnlyObjectWrapper<Square> nextCell = board[i+1][j];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != nextCell.getValue()){
                        count++;
                    }
                }
                else if (i==2){
                    ReadOnlyObjectWrapper<Square> prev1 = board[i-2][j];
                    ReadOnlyObjectWrapper<Square> nextCell = board[i+1][j];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != nextCell.getValue() &&
                            currentCell.getValue() != prev1.getValue()){
                        count++;
                    }
                }
                else if (i==3){
                    ReadOnlyObjectWrapper<Square> prev1 = board[i-2][j];
                    ReadOnlyObjectWrapper<Square> prev2 = board[i-3][j];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != prev1.getValue() && currentCell.getValue() != prev2.getValue()){
                        count++;
                    }
                }
            }
            if(count==4){
                return true;
            }
        }
        return false;
    }

    public boolean rowGoalCheck(){
        int count;
        for(var i = 0; i < BOARD_SIZE ;i++){
            count = 0;
            for(var j = 0 ; j < BOARD_SIZE; j++){
                ReadOnlyObjectWrapper<Square> currentCell = board[i][j];

                if (j==0){
                    ReadOnlyObjectWrapper<Square> nextCell = board[i][j+1];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != nextCell.getValue()){
                        count++;
                    }
                }
                else if (j==1){
                    ReadOnlyObjectWrapper<Square> nextCell = board[i][j+1];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != nextCell.getValue()){
                        count++;
                    }
                }
                else if (j==2){
                    ReadOnlyObjectWrapper<Square> prev1 = board[i][j-2];
                    ReadOnlyObjectWrapper<Square> nextCell = board[i][j+1];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != nextCell.getValue() &&
                            currentCell.getValue() != prev1.getValue()){
                        count++;
                    }
                }
                else if (j==3){
                    ReadOnlyObjectWrapper<Square> prev1 = board[i][j-2];
                    ReadOnlyObjectWrapper<Square> prev2 = board[i][j-3];
                    if(currentCell.getValue() != Square.EMPTY && currentCell.getValue() != prev1.getValue() && currentCell.getValue() != prev2.getValue()){
                        count++;
                    }
                }
            }
            if(count==4){
                return true;
            }
        }
        return false;
    }

    public Boolean isGoalState(){
        if(rowGoalCheck() || columnGoalCheck()){
            return true;
        }
        return false;
    }

    public void setSquareColor(PlayerModel playerModel,int i, int j){
        if (playerModel.getFirstPlayersTurn()){
                board[i][j].set(
                        switch (board[i][j].get()) {
                            case EMPTY -> Square.RED;
                            case RED -> Square.BLUE;
                            case BLUE -> Square.EMPTY;
                            case YELLOW, GREEN -> null;
                        }
                );

        }else if(!playerModel.getFirstPlayersTurn()){
            board[i][j].set(
                    switch (board[i][j].get()) {
                        case EMPTY -> Square.YELLOW;
                        case RED, BLUE -> null;
                        case YELLOW -> Square.GREEN;
                        case GREEN -> Square.EMPTY;
                    }
            );
        }
    }

    public void changePlayer(PlayerModel playerModel){
        if(playerModel.getFirstPlayersTurn()){
            playerModel.setFirstPlayersTurn(false);
        }else{
            playerModel.setFirstPlayersTurn(true);
        }
    }

    public static void main(String[] args) {
        var model = new BoardGameModel();
        System.out.println(model);
    }

}
