package ColorCollection.models;

import java.time.LocalDateTime;

/**
 * Class for the model of the Results
 */
public class ResultModel {
    private String playerOneName;
    private String playerTwoName;
    private String winner;
    private Integer numberOfMoves = 0;
    private LocalDateTime startingDateAndTime;

    /**
     * Getter the player one's name
     * @return the player number one's name
     */
    public String getPlayerOneName(){
        return playerOneName;
    }

    /**
     * Setter for the Player one's name
     * @param name name of the Player one
     */
    public void setPlayerOneName(String name){
        this.playerOneName = name;
    }

    /**
     * Getter for the player two's name
     * @return player two's name
     */
    public String getPlayerTwoName(){
        return playerTwoName;
    }

    /**
     * Setter for the player two's name
     * @param name Player two's name
     */
    public void setPlayerTwoName(String name){
        this.playerTwoName = name;
    }

    /**
     * Getter method for the winner
     * @return winner
     */
    public String getWinner(){
        return winner;
    }

    /**
     * Setter method for the winner
     * @param name name of the winner
     */
    public void setWinner(String name){
        this.winner = name;
    }

    /**
     * Getter method for the number of moves played
     * @return number of moves
     */
    public Integer getNumberOfMoves(){
        return numberOfMoves;
    }

    /**
     * Setter for the Number of Moves played
     * @param i number of moves
     */
    public void setNumberOfMoves(int i){
        this.numberOfMoves = i;
    }

    /**
     * Getter method for the DateAndTime
     * @return DateAndTime
     */
    public LocalDateTime getStartingDateAndTime(){
        return startingDateAndTime;
    }

    /**
     * Setter method for the DateAndTIme
     * @param dt date and time
     */
    public void setStartingDateAndTime(LocalDateTime dt){
        this.startingDateAndTime = dt;
    }
}
