package Main;

import java.io.IOException;

import Classes.AlignerDemo;
import Classes.AssistantButton;
import Classes.SpeakerIdentificationDemo;
import Classes.TranscriberDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class MainGUI extends Application  {
	
	//create variables
	Scene myScene;
	Pane container;
	Label lblMessage;
	Button btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit;
	
	private Stage alertWindow;

	@Override
	public void start(Stage myStage) throws Exception {
		
		//Create the buttons
		Button btnTranscriber = new Button("Transcriber");
		Button btnAssistant = new Button("Assistant");
		Button btnSpeaker = new Button("Speaker");
		Button btnAligner = new Button("Aligner");
		Button btnExit = new Button("Exit");

		
		alertWindow = new Stage();
		
		//TranscriberDemo action handler
		btnTranscriber.setTranslateX(20);
		btnTranscriber.setTranslateY(120);
		btnTranscriber.setOnAction(e -> {

			if (! alertWindow.isShowing()) {
			
			Button wakeup = new Button("Wake Up!");
			alertWindow.setScene(myScene);
			wakeup.setOnAction(evt -> alertWindow.notify());
			
			alertWindow.showAndWait();
			try {
				TranscriberDemo.main(null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			}
		});
		
		//AssistantDemo action handler
		btnAssistant.setTranslateX(20);
		btnAssistant.setTranslateY(160);
		btnAssistant.setOnAction(e -> {
		if (! alertWindow.isShowing()) {
					
			//Assistant
			Button wakeup = new Button("Wake Up!");
			alertWindow.setScene(myScene);
			wakeup.setOnAction(evt -> alertWindow.notify());
					
			alertWindow.showAndWait();
			try {
				AssistantButton.main(null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
					
			}
		});
		

		
		//SpeakerIdDemo action handler
		btnSpeaker.setTranslateX(20);
		btnSpeaker.setTranslateY(200);
		btnSpeaker.setOnAction(e -> {
		if (! alertWindow.isShowing()) {
					
			Button wakeup = new Button("Wake Up!");
			alertWindow.setScene(myScene);
			wakeup.setOnAction(evt -> alertWindow.notify());
					
			alertWindow.showAndWait();
			try {
				SpeakerIdentificationDemo.main(null);
			} catch (Exception e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
					
			}
		});
		
		
		//AlignerDemo action handler
		btnAligner.setTranslateX(20);
		btnAligner.setTranslateY(240);
		btnAligner.setOnAction(e -> {
		if (! alertWindow.isShowing()) {
			
			Button wakeup = new Button("Wake Up!");
			alertWindow.setScene(myScene);
			wakeup.setOnAction(evt -> alertWindow.notify());
			
			alertWindow.showAndWait();
			try {
				AlignerDemo.main(null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			}
		});
		
		//Exit action handler
		btnExit.setTranslateX(20);
		btnExit.setTranslateY(280);
		btnExit.setOnAction(e -> {
		if (! alertWindow.isShowing()) {
					
			Button wakeup = new Button("Wake Up!");
			alertWindow.setScene(myScene);
			wakeup.setOnAction(evt -> alertWindow.notify());
					
			alertWindow.showAndWait();
			System.exit(0);
					
					
			}
		});
		
		/*   //AssistantDemo action handler
		btnAssistant.setOnAction(e -> {
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
		btnSpeaker.setOnAction(e -> {
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
		btnAligner.setOnAction(e -> {
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
		btnExit.setOnAction(e -> {
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
		*/
		
		/*btnTranscriber.setOnAction(new EventHandler<ActionEvent>() {
	
			
			@Override
			public void handle(ActionEvent e) {

				lblMessage.setText("Transcriber");
				try {
					TranscriberDemo.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
				


		btnAssistant = new Button("Assistant");
		btnAssistant.setTranslateX(20);
		btnAssistant.setTranslateY(160);
		btnAssistant.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				lblMessage.setText("Assistant");

				try {
					AssistantDemo.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		

		btnSpeaker = new Button("Speaker");
		btnSpeaker.setTranslateX(20);
		btnSpeaker.setTranslateY(200);
		btnSpeaker.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				lblMessage.setText("Speaker");
				try {
					SpeakerIdentificationDemo.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
	
		btnAligner = new Button("Aligner");
		btnAligner.setTranslateX(20);
		btnAligner.setTranslateY(240);
		btnAligner.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				lblMessage.setText("Aligner");
				try {
					AlignerDemo.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			
			*/
			
		
		

		//create label message
		//lblMessage = new Label("Message");
		//lblMessage.setTranslateX(20);
		//lblMessage.setTranslateY(320); 

		
		//Create the new container
		container = new Pane();
		container.getChildren().addAll(btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit);
		
		// Create a new scene and asign within the container
		Scene myScene = new Scene(container);
		
	
		//Asignament propieties to the new stage
		myStage.setTitle("Voice Recognition Demos Menu");
		myStage.setMinWidth(500);
		myStage.setMinHeight(500);
		myStage.setFullScreen(false);
		
		// assignament the scene to the stage
		myStage.setScene(myScene);
		
		//Show the new Stage
		myStage.show();

	}
	
public static void main(String[] args) {
		
		//Execute the application
		Application.launch(args);
	}

}

/*


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewMain extends Application {
	Stage window;
	Stage alertWindow;
	Scene myScene1, myScene2, myScene3, myScene4, myScene5;
	Pane container;
	Label lblMessage;
	Button btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit, btnRec, btnBack, btnDialog, btnDigit, btnBank;	
	

@Override
public void start(Stage myStage) throws Exception {

	window = myStage;

	Label label1 = new Label("Welcome to the Voice Recognition Main Menu");
	
	Button btnTranscriber = new Button("Transcriber");

	btnTranscriber.setOnAction(e -> window.setScene(myScene1));
	
	Button btnAssistant = new Button("Assistant");

	btnAssistant.setOnAction(e -> window.setScene(myScene1));
	
	Button btnSpeaker = new Button("Speaker");

	btnSpeaker.setOnAction(e -> window.setScene(myScene1));
	
	Button btnAligner = new Button("Aligner");

	btnAligner.setOnAction(e -> window.setScene(myScene1));
	
	Button btnExit = new Button("Exit");
	btnAssistant.setTranslateX(20);
	btnAssistant.setTranslateY(280);
	btnExit.setOnAction(e -> window.setScene(myScene1));
	System.exit(0);

	//Layout Main Menu 
	VBox layout1 = new VBox();
	layout1.getChildren().addAll(btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit);
	myScene1 = new Scene(layout1, 600, 600);

	//Layout TranscriberButton
	StackPane layout2 = new StackPane();
	layout2.getChildren().addAll(btnTranscriber, btnRec, btnBack);
		myScene2 = new Scene(layout2, 600, 300);
	
	/*
	
	//Layout TranscriberButton
	StackPane layout2 = new StackPane();
	layout2.getChildren().addAll(btnTranscriber, btnRec, btnBack);
	myScene2 = new Scene(layout2, 600, 300);
	
	//Layout AssistantButton
	StackPane layout3 = new StackPane();
	layout3.getChildren().addAll(btnDigit, btnDialog, btnBank, btnBack);
	myScene3 = new Scene(layout3, 600, 300);
	
	//Layout SpeakerIdButton
	StackPane layout4 = new StackPane();
	layout4.getChildren().addAll(btnExit);
	myScene4 = new Scene(layout4, 600, 300);
	
	//Layout AlignerButton
	StackPane layout5 = new StackPane();
	layout5.getChildren().addAll(btnExit);
	myScene5 = new Scene(layout5, 600, 300);
	
	.................................................
	
	
	window.setScene(myScene1);
	window.setTitle("Voice Recognition Main Menu");
	window.show();
	
	//Show the new Stage
	myStage.show();

	
}
public static void main(String[] args) {
launch(args);
} */
