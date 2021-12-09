package voice_control;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author luis
 */

public class GUI_Demos extends Application {


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
	primaryStage.setTitle("Main Menu Scene");
	
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
               
	
		//Exit Button action handler
		btnExit.setOnAction(e -> {
			if (! Window.isShowing()) {
			btnExit.setOnAction(evn -> Window.setScene(sceneMenu));		
			System.out.println("The Process was canceled, thank you for using this speech recognition software");
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
