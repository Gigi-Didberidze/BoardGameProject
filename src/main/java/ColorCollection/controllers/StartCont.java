package ColorCollection.controllers;

import ColorCollection.controllers.GameCont;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartCont {
    @FXML
    TextField playerOneTF;
    @FXML
    TextField playerTwoTF;
    @FXML
    Button playBtn;
    @FXML
    Label missingPlayersLabel;
    @FXML
    FXMLLoader fxmlLoader = new FXMLLoader();

    @FXML
    public void handlePlayButton(ActionEvent actionEvent) throws IOException {
        if(playerTwoTF.getText().isBlank() || playerOneTF.getText().isBlank()){
            missingPlayersLabel.setText("Please Enter both Player names");
        }
        else{
            GameCont controller = new GameCont();
            controller.playerModel.setPlayerOneName(playerOneTF.getText());
            controller.playerModel.setPlayerTwoName(playerTwoTF.getText());
            fxmlLoader.setLocation(this.getClass().getClassLoader().getResource("ui.fxml"));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    public void openSheet(ActionEvent actionEvent) throws IOException {
    }
}
