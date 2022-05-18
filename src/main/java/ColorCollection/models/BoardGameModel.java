package ColorCollection.models;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

import java.time.LocalDateTime;

/**
 * Class that handles board game model
 */
public class BoardGameModel {
    public static int BOARD_SIZE = 4;
    public int numberOfStones = 0;
    public LocalDateTime startingDateAndTime;

    private ReadOnlyObjectWrapper<Square>[][] board = new ReadOnlyObjectWrapper[BOARD_SIZE][BOARD_SIZE];

    public BoardGameModel() {
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new ReadOnlyObjectWrapper<Square>(Square.EMPTY);
            }
        }
        startingDateAndTime = LocalDateTime.now();
    }

    public ReadOnlyObjectProperty<Square> squareProperty(int i, int j) {
        return board[i][j].getReadOnlyProperty();
    }

    public Square getSquare(int i, int j) {
        return board[i][j].get();
    }

    /**
     * This method handles the player move
     * @param playerModel model of the player
     * @param i row
     * @param j column
     */
    public void move(PlayerModel playerModel,int i, int j) {
        //change the color of the circle
        //check if it goal state
        setSquareColor(playerModel,i,j);
    }

    /**
     * Returns the model converted into a String
     * @return Model converted into a String
     */
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

    /**
     * Returns True if any column of the model contains different color of stones
     * @return True if any column of the model contains different color of stones
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

    /**
     * True if any row of the model contains different color of stones
     * @return True if any row of the model contains different color of stones
     */
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

    /**
     * Returns True if model reaches goal state
     * @return True if model reaches goal state
     */
    public Boolean isGoalState(){
        if(rowGoalCheck() || columnGoalCheck()){
            return true;
        }
        return false;
    }

    /**
     * This method sets the color of the square
     * @param playerModel model of the player
     * @param i row
     * @param j column
     */
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

    /**
     * This method changes the player's turn
     * @param playerModel model of the player
     */
    public void changePlayer(PlayerModel playerModel){
        if(playerModel.getFirstPlayersTurn()){
            playerModel.setFirstPlayersTurn(false);
        }else{
            playerModel.setFirstPlayersTurn(true);
        }
        setNumberOfStones(getNumberOfStones()+1);
    }

    /**
     * Getter method for number of stones
     * @return  number of stones
     */
    public int getNumberOfStones(){
        return numberOfStones;
    }

    /**
     * Setter for Number of Stones
     * @param numberOfStones number of stones
     */
    public void setNumberOfStones(int numberOfStones){
        this.numberOfStones = numberOfStones;
    }
    public static void main(String[] args) {
        var model = new BoardGameModel();
        System.out.println(model);
    }

}
