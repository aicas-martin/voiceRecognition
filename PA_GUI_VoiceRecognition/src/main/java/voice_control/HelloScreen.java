package voice_control;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author luis
 */

public class HelloScreen {
    private TextField textField ;
    private VBox view ;

    public HelloScreen() {
        Label label = new Label("Name:");
        textField = new TextField();
        HBox hBox = new HBox(10, label,textField);
        hBox.setAlignment(Pos.CENTER);
        Button button = new Button("Show User Input In Console");

        // On click, close the window:
        button.setOnAction( e -> view.getScene().getWindow().hide());

        view = new VBox(10, hBox, button);
        view.setAlignment(Pos.CENTER);
    }

    public String getMessage() {
        return textField.getText();
    }

    public Parent getView() {
        return view ;
    }
}
