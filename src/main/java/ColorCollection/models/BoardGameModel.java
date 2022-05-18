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

    public void move(int i, int j) {
        //change the color of the circle
        //check if it goal state
        board[i][j].set(
                switch (board[i][j].get()) {
                    case EMPTY -> Square.RED;
                    case RED -> Square.BLUE;
                    case BLUE -> Square.YELLOW;
                    case YELLOW -> Square.GREEN;
                    case GREEN -> Square.EMPTY;
                }
        );
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
    new method{
    check which players turn it is if its player one only allow red and blue
    if its player two only allow yellow and green
    board[i][j].set(
                switch (board[i][j].get()) {
                    case EMPTY -> Square.RED;
                    case RED -> Square.BLUE;
                    case BLUE -> Square.YELLOW;
                    case YELLOW -> Square.GREEN;
                    case GREEN -> Square.EMPTY;
                }
        );
        using this
    }

    new method goal state (BoardGameModel model){
    check if the board has reached the ending.
    for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                board[i][j].get().ordinal()
    if model.contains (1,2,3,4) {
        return true;
    }
    }

    new method change player(PlayerModel playerModel){
        if (playermode.getfirstplayer == true){
        playermodel."setfirsplay" = false;
        }else
        playermodel."setfirsplay" = true;


    }
     */
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
