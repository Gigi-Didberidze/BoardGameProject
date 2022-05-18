package ColorCollection.models;

/**
 * Class of the model of the player
 */
public class PlayerModel {

    private String playerOneName;
    private String playerTwoName;
    private Boolean firstPlayersTurn = true;

    /**
     * Getter for name of player one
     * @return name of the player number one
     */
    public String getPlayerOneName(){
        return playerOneName;
    }

    /**
     * Setter for name of player one
     * @param newPlayerOneName name of the player number one
     */
    public void setPlayerOneName(String newPlayerOneName){
        this.playerOneName = newPlayerOneName;
    }

    /**
     * Getter for Player two's name
     * @return player two's name
     */
    public String getPlayerTwoName(){
        return playerTwoName;
    }

    /**
     * Setter for Player two's name
     * @param newPlayerTwoName Player two's name
     */
    public void setPlayerTwoName(String newPlayerTwoName){
        this.playerTwoName = newPlayerTwoName;
    }

    /**
     * getter for the First Player's Turn
     * @return Turn of the first player
     */
    public Boolean getFirstPlayersTurn(){
        return firstPlayersTurn;
    }

    /**
     * Setter for the first Player's turn
     * @param newSetFirstPlayersTurn First player's turn
     */
    public void setFirstPlayersTurn(Boolean newSetFirstPlayersTurn){
        this.firstPlayersTurn = newSetFirstPlayersTurn;
    }

}
