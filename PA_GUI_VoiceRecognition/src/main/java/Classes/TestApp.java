package Classes;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestApp extends Application {

private LiveSpeechRecognizer recognizer;
boolean active = true;
Scene scene1, scene2;

@Override
public void init() throws Exception {
	//Configuration Object
    Configuration configuration = new Configuration();
	 
    // Set path to the acoustic model.
    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    // Set path to the language model (vocabulary model).
    configuration.setDictionaryPath("resources/assistant/2729.dic");
    configuration.setLanguageModelPath("resources/assistant/2729.lm");
    recognizer = new LiveSpeechRecognizer(configuration);
}


@Override
public void start(Stage primaryStage) {
        
primaryStage.setTitle("Demo");

//Scene 1
Label label1= new Label("Transcriber Menu");
Button button1= new Button("Transcriber");
button1.setOnAction(e -> primaryStage.setScene(scene2));   
VBox layout1 = new VBox(20);     
layout1.getChildren().addAll(label1, button1);
scene1= new Scene(layout1, 300, 250);

//Scene 2
Label label2= new Label("Transcriber is Running..");
Button button2= new Button("Back");
button2.setOnAction(e -> primaryStage.setScene(scene1));
VBox layout2= new VBox(20);
layout2.getChildren().addAll(label2, button2);
scene2= new Scene(layout2,300,250);

Task<Void> sleeper = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return null;
    }
};

sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    @Override
    public void handle(WorkerStateEvent event) {
button1.setOnAction(e -> primaryStage.setScene(scene2));
    }
});

new Thread(sleeper).start();
               
      
primaryStage.setScene(scene1);
primaryStage.show();
}

public static void main(String[] args) {
launch(args);
}
    
}