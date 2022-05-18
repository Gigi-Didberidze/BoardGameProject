package ColorCollection.models;

public class PlayerModel {

    private String playerOneName;
    private String playerTwoName;
    private Boolean firstPlayersTurn = true;

    public String getPlayerOneName(){
        return playerOneName;
    }
    public void setPlayerOneName(String newPlayerOneName){
        this.playerOneName = newPlayerOneName;
    }

    public String getPlayerTwoName(){
        return playerTwoName;
    }
    public void setPlayerTwoName(String newPlayerTwoName){
        this.playerTwoName = newPlayerTwoName;
    }

    public Boolean getFirstPlayersTurn(){
        return firstPlayersTurn;
    }

    public void setFirstPlayersTurn(Boolean newSetFirstPlayersTurn){
        this.firstPlayersTurn = newSetFirstPlayersTurn;
    }
}
