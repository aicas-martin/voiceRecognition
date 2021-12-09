package Classes;


import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUImenuDemos extends Application {

	LiveSpeechRecognizer recognizer;
	boolean active = false;
	Scene sceneMenu;
	Scene sceneTranscriber;
	Scene sceneAssistant;
	Scene sceneSpeaker;
	Scene sceneAligner;
	Button btnTranscriber;
	Button btnAssistant;
	Button btnSpeaker;
	Button btnSpeaker1;
	Button btnAligner;
	Button btnAligner1;
	Button btnRec;
	Button btnDigit;
	Button btnDialog;
	Button btnBank;
	Button btnBack1;
	Button btnBack2;
	Button btnBack3;
	Button btnExit;
	Stage windows;
	 
	@Override
	public void start(Stage primaryStage) throws Exception {

	//Main Menu Container	
	primaryStage.setTitle("GUI Voice Recognition Main Menu");
	
	Stage Window = new Stage();
	
	//Scene 1 - Main Menu ---------------------
	Label labelMenu= new Label("Main Menu");
	Button btnTranscriber = new Button("Transcriber");
	Button btnAssistant = new Button("Assistant");
	Button btnSpeaker= new Button("SpeakerId");
	Button btnAligner= new Button("Aligner");
	Button btnExit = new Button("Exit");
	
	
	
	btnTranscriber.setOnAction(e -> primaryStage.setScene(sceneTranscriber));
	
	btnAssistant.setOnAction(e -> primaryStage.setScene(sceneAssistant));
	
	btnSpeaker.setOnAction(e -> primaryStage.setScene(sceneSpeaker));
	
	btnAligner.setOnAction(e -> primaryStage.setScene(sceneAligner));
	
	
	VBox layoutMenu = new VBox(20);     
	layoutMenu.getChildren().addAll(labelMenu, btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit );
	layoutMenu.setAlignment(Pos.BASELINE_CENTER);
	sceneMenu = new Scene(layoutMenu, 300, 300);
               
	//Scene 2 - TranscriberButton ------------------------
	Label labelTranscriber= new Label("TranscriberDemo Menu");
	
	//TranscriberDemo
	Button btnTranscriber1 = new Button("TranscriberDemo");
	btnTranscriber1.setOnAction(e -> {
		if (! Window.isShowing()) {
			btnTranscriber1.setOnAction(evn -> Window.setScene(sceneTranscriber));
			
		try {
			TranscriberDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//RecDemo
	Button btnRec= new Button("RecDemo");
	btnRec.setOnAction(e -> {
		if (! Window.isShowing()) {
			btnRec.setOnAction(evn -> Window.setScene(sceneTranscriber));
		try {
			//RecDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
	Button btnBack1= new Button("Back");
	btnBack1.setOnAction(e -> primaryStage.setScene(sceneMenu));
	
	VBox layoutTranscriber= new VBox(20);
	layoutTranscriber.getChildren().addAll(labelTranscriber, btnTranscriber1, btnRec, btnBack1 );
	layoutTranscriber.setAlignment(Pos.BASELINE_CENTER);
	sceneTranscriber= new Scene(layoutTranscriber,300,300);

	//Scene 3 - AssistantButton ------------------------
	Label labelAssistant= new Label("AssistantButton");
	//DigitDemo
	Button btnDigit= new Button("DigitDemo");
	btnDigit.setOnAction(e -> {
		if (! Window.isShowing()) {
			btnDigit.setOnAction(evn -> Window.setScene(sceneAssistant));
		try {
			DigitDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	
	Button btnDialog= new Button("DialogDemo");
	btnDialog.setOnAction(e -> {
		if (! Window.isShowing()) {
			btnDialog.setOnAction(evn -> Window.setScene(sceneAssistant));
		try {
			DialogDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	Button btnBank= new Button("BankDemo");
	btnBank.setOnAction(e -> {
		if (! Window.isShowing()) {
			btnBank.setOnAction(evn -> Window.setScene(sceneAssistant));
		try {
			//BankDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
		Button btnBack2= new Button("Back");
		btnBack2.setOnAction(e -> primaryStage.setScene(sceneMenu));
	VBox layoutAssistant= new VBox(20);
	layoutAssistant.getChildren().addAll(labelAssistant, btnDialog, btnDigit, btnBank, btnBack2);
	layoutAssistant.setAlignment(Pos.BASELINE_CENTER);
	sceneAssistant= new Scene(layoutAssistant,300,300);

	//Scene 4 - SpeakerIdButton
	Label labelSpeaker= new Label("SpeakerIdButton");
	
	//SpeakerIdDemo
	Button btnSpeaker1= new Button("SpeakerId");
	btnSpeaker1.setOnAction(e -> {
		if (! Window.isShowing()) {
			btnSpeaker1.setOnAction(evn -> Window.setScene(sceneSpeaker));
		try {
			SpeakerIdentificationDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
	Button btnBack3= new Button("Back");
	btnBack3.setOnAction(e -> primaryStage.setScene(sceneMenu));
	VBox layoutSpeaker= new VBox(20);
	layoutSpeaker.getChildren().addAll(labelSpeaker, btnSpeaker1, btnBack3);
	layoutSpeaker.setAlignment(Pos.BASELINE_CENTER);
	sceneSpeaker= new Scene(layoutSpeaker,300,300);

	//Scene 5 - AlignerButton
	Label labelAligner= new Label("AlignerButton");

	//AlignerDemo
	Button btnAligner1= new Button("AlignerDemo");
	btnAligner1.setOnAction(e -> {
		if (! Window.isShowing()) {
			btnAligner1.setOnAction(evn -> Window.setScene(sceneAligner));
		try {
			AlignerDemo.main(null);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
	Button btnBack4= new Button("Back");
	btnBack4.setOnAction(e -> primaryStage.setScene(sceneMenu));
	VBox layoutAligner= new VBox(20);
	layoutAligner.getChildren().addAll(labelAligner, btnAligner1, btnBack4);
	layoutAligner.setAlignment(Pos.BASELINE_CENTER);
	sceneAligner= new Scene(layoutAligner,300,300);
 

		//Exit Button action handler
		btnExit.setOnAction(e -> {
			if (! Window.isShowing()) {
			btnExit.setOnAction(evn -> Window.setScene(sceneMenu));		
			System.exit(0);

		}
	});
		
		primaryStage.setScene(sceneMenu);
		
		primaryStage.show();
		
	}
	
	  	
		public static void main(String[] args) throws Exception {
			
			//GUI	
			launch();
			
	    }

		}


