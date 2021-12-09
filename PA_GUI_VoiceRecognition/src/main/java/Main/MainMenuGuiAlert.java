package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author luis
 */

public class MainMenuGuiAlert extends Application {

	Scene myScene;
	Pane container;
	Label lblMessage;
	Button transcriber, assistant, speaker, aligner, Exit, doTranscriber, doSpeaker, doAligner, rec, digit, bank, dialog, back;	
	
private Stage alertWindow;

@Override
public void start(Stage myStage) {

//Create the buttons
Button transcriber = new Button("Transcriber");
Button assistant = new Button("Assistant");
Button speaker = new Button("Speaker");
Button aligner = new Button("Aligner");
Button exit = new Button("Exit");


alertWindow = new Stage();

//TranscriberDemo action handler
transcriber.setOnAction(e -> {
if (! alertWindow.isShowing()) {
	
	//Transcriber
	Button doTranscriber = new Button("Transcriber");
	Scene scene = new Scene(new StackPane(doTranscriber), 250, 250);
	alertWindow.setScene(scene);
	doTranscriber.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	//Rec
	Button rec= new Button("Rec");
	Scene scene1 = new Scene(new StackPane(rec), 250, 250);
	alertWindow.setScene(scene1);
	rec.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	//Back to the main menu
	Button back = new Button("Back");
	Scene scene2 = new Scene(new StackPane(back), 250, 250);
	alertWindow.setScene(scene2);
	back.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	}
	});

//AssistantDemo action handler
assistant.setOnAction(e -> {
if (! alertWindow.isShowing()) {
	
	//Digit numbers
	Button digit = new Button("Digit");
	Scene scene = new Scene(new StackPane(digit), 250, 250);
	alertWindow.setScene(scene);
	digit.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	//Bank account
	Button  bank = new Button("Bank");
	Scene scene1 = new Scene(new StackPane(bank), 250, 250);
	alertWindow.setScene(scene1);
	bank.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	//Dialog & Instructions
	Button  dialog = new Button("Dialog");
	Scene scene2 = new Scene(new StackPane(dialog), 250, 250);
	alertWindow.setScene(scene2);
	dialog.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	//Back to the main menu
	Button back = new Button("Back");
	Scene scene3 = new Scene(new StackPane(back), 250, 250);
	alertWindow.setScene(scene3);
	back.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();

}
});

//SpeakerIdDemo action handler
speaker.setOnAction(e -> {
if (! alertWindow.isShowing()) {
	
	//SpeakerIdentification
	Button doSpeaker = new Button("SpeakerId");
	Scene scene = new Scene(new StackPane(doSpeaker), 250, 250);
	alertWindow.setScene(scene);
	doSpeaker.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	//Back to the main menu
	Button back = new Button("Back");
	Scene scene1 = new Scene(new StackPane(back), 250, 250);
	alertWindow.setScene(scene1);
	back.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	}
	});

//AlignerDemo action handler
aligner.setOnAction(e -> {
if (! alertWindow.isShowing()) {
	
	//Aligner
	Button doAligner = new Button("Aligner");
	Scene scene = new Scene(new StackPane(doAligner), 250, 250);
	alertWindow.setScene(scene);
	doAligner.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	//Back to the main menu
	Button back = new Button("Back");
	Scene scene1 = new Scene(new StackPane(back), 250, 250);
	alertWindow.setScene(scene1);
	back.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	
	}
	});

//AlignerDemo action handler
exit.setOnAction(e -> {
if (! alertWindow.isShowing()) {
	

	//Back to the main menu
	Button ok = new Button("Ok");
	Scene scene = new Scene(new StackPane(ok), 250, 250);
	alertWindow.setScene(scene);
	ok.setOnAction(evt -> alertWindow.hide());
	alertWindow.showAndWait();
	System.exit(0);
	
	}
	});


Scene scene = new Scene(new StackPane(transcriber), 400, 400);
myStage.setScene(scene);
myStage.show();

}

public static void main(String[] args) {
launch(args);
}
}
