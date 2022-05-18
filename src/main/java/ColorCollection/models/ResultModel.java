package ColorCollection.models;

import java.time.LocalDateTime;

public class ResultModel {
    private String playerOneName;
    private String playerTwoName;
    private String winner;
    private Integer numberOfMoves = 0;
    private LocalDateTime startingDateAndTime;

    public String getPlayerOneName(){
        return playerOneName;
    }
    public void setPlayerOneName(String name){
        this.playerOneName = name;
    }
    public String getPlayerTwoName(){
        return playerTwoName;
    }
    public void setPlayerTwoName(String name){
        this.playerTwoName = name;
    }
    public String getWinner(){
        return winner;
    }
    public void setWinner(String name){
        this.winner = name;
    }
    public Integer getNumberOfMoves(){
        return numberOfMoves;
    }
    public void setNumberOfMoves(int i){
        this.numberOfMoves = i;
    }
    public LocalDateTime getStartingDateAndTime(){
        return startingDateAndTime;
    }
    public void setStartingDateAndTime(LocalDateTime dt){
        this.startingDateAndTime = dt;
    }
}
