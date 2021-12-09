package voice_control;



import java.io.IOException;
import Classes.AlignerDemo;
import Classes.AssistantButton;
import Classes.SpeakerIdentificationDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author luis
 */

public class MyButton extends Button {

    public MyButton() {
        Button button = new Button();
        button.setText("Say 'Hello World'");
        button.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });
    

    }
    
    
    public class ButtonBuilder {

        public Button crearBoton1() {
            Button button = new Button();
            button.setText("Say 'Hello World'");
            button.setOnAction((ActionEvent event) -> {
                System.out.println("Hello World!");
            });
            return button;
        }

        public Button crearBotonMuestraTexto(String text) {
            Button button = new Button();
            button.setText("Say '" + text + "'");
            button.setOnAction((ActionEvent event) -> {
                System.out.println(text);
            });
            return button;
        }
    }
}
