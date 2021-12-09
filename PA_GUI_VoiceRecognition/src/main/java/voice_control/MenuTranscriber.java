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

public class MenuTranscriber extends Application {


	Scene sceneMenu;
	Scene sceneTranscriber;
	Scene sceneRec;
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
		Button btnRec = new Button("Rec");
		Button btnBack1 = new Button("Back");
		
		
		
		btnTranscriber.setOnAction(e -> primaryStage.setScene(sceneTranscriber));
		
		btnRec.setOnAction(e -> primaryStage.setScene(sceneRec));
		
		
		
		
		VBox layoutMenu = new VBox(20);     
		layoutMenu.getChildren().addAll(labelMenu, btnTranscriber, btnRec, btnBack1 );
		layoutMenu.setAlignment(Pos.BASELINE_CENTER);
		sceneMenu = new Scene(layoutMenu, 300, 300);
	               
		
			//Exit Button action handler
		btnBack1.setOnAction(e -> {
				if (! Window.isShowing()) {
					btnBack1.setOnAction(evn -> Window.setScene(sceneMenu));		
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
