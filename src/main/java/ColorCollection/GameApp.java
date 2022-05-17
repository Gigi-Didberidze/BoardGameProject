package ColorCollection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: LAVENDER");
        Text text = new Text("Color Collection Board Game");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        text.setFill(Color.BLACK);
        root.getChildren().add(text);
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Color Collection");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
