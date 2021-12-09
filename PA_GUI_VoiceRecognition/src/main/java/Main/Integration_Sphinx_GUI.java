package Main;

import java.io.IOException;

import Classes.AlignerButton;
import Classes.AssistantButton;
import Classes.SpeakerIdentificationButton;
import Classes.TranscriberButton;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author luis
 */


public class Integration_Sphinx_GUI extends Application {
	
	//create variables
	Scene myScene;
	Pane container;
	Label lblMessage;
	Button btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit, btnRec, btnBack;

  	LiveSpeechRecognizer recognizer;
  	Stage windows;

  	boolean active = false;
  	public void InitMenu() throws Exception {
	        
	    //Configuration Object
	    Configuration configuration = new Configuration();
		 
	    // Set path to the acoustic model.
	    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
	    // Set path to the language model (vocabulary model).
	    configuration.setDictionaryPath("resources/assistant/2729.dic");
	    configuration.setLanguageModelPath("resources/assistant/2729.lm");

	    
		try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            System.out.println(e);
        }
         
        //Start speech recognition 
        startSpeechRecognition();
        
}
    
  	public void startSpeechRecognition() throws Exception {
        
  		
  		
        //Start Recognition Process (The boolean parameter clears the previous cache if true)
        recognizer.startRecognition(true);
        
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognizer.getResult()) != null) {
        	
            //Get the recognized speech
            String voiceCommand = result.getHypothesis();
            
            //System.out.println(result.getHypothesis());
            

            if (voiceCommand.equalsIgnoreCase("Wake Up")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
            	active=true;
            	Application.launch();
            	

            } else if(voiceCommand.equalsIgnoreCase("Sleep")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
            	active=false;
                System.out.println("I'm going to sleep, but if you need me, wake me up, see you later!");

            } else if(voiceCommand.equalsIgnoreCase("Exit")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				active=false;
				System.out.println("                                                              ");
				System.out.println("Thanks for using the VoiceRecognition App, See you soon, bye!.");
				System.out.println("                                                              ");
				System.out.println("_____________________________________________________________ ");
				break;

            }     
        }
  	}

	@Override
	public void start(Stage myStage) throws Exception {


            //System.out.println(result.getHypothesis());
        	
			//TranscriberDemo Button
			Button btnTranscriber = new Button("Transcriber");
			btnTranscriber.setTranslateX(20);
			btnTranscriber.setTranslateY(120);
			
			//AssistantDemo Button
			Button btnAssistant = new Button("Assistant");
			btnAssistant.setTranslateX(20);
			btnAssistant.setTranslateY(160);
			
			//SpeakerIdDemo Button
			Button btnSpeaker = new Button("Speaker");
			btnSpeaker.setTranslateX(20);
			btnSpeaker.setTranslateY(200);
			
			//AlignerDemo Button
			Button btnAligner = new Button("Aligner");
			btnAligner.setTranslateX(20);
			btnAligner.setTranslateY(240);
			
			//Exit Button
			Button btnExit = new Button("Exit");
			btnExit.setTranslateX(20);
			btnExit.setTranslateY(280);
			
			Stage Window = new Stage();
			
			//Transcriber Button action handler
				btnTranscriber.setOnAction(e -> {
					if (! Window.isShowing()) {
					btnTranscriber.setOnAction(evn -> Window.setScene(myScene));
					try {
						TranscriberButton.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
				});
		
				
				//Assistant Button action handler
				btnAssistant.setOnAction(e -> {
					if (! Window.isShowing()) {
					btnAssistant.setOnAction(evn -> Window.setScene(myScene));
					try {
						AssistantButton.main(null);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					}
				});
				
				//SpeakerId Button action handler
				btnSpeaker.setOnAction(e -> {
					if (! Window.isShowing()) {
					btnSpeaker.setOnAction(evn -> Window.setScene(myScene));
					try {
						SpeakerIdentificationButton.main(null);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					}
				});
				
				//Aligner Button action handler
				btnAligner.setOnAction(e -> {
					if (! Window.isShowing()) {
					btnAligner.setOnAction(evn -> Window.setScene(myScene));
					try {
						AlignerButton.main(null);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					}
				});
				
				//Exit Button action handler
   				btnExit.setOnAction(e -> {
   					if (! Window.isShowing()) {
   					btnExit.setOnAction(evn -> Window.setScene(myScene));		
   					System.exit(0);

					}
				});
   				
   				
   		//Layout1
   		VBox layout1 = new VBox();
   		layout1.setAlignment(Pos.BASELINE_CENTER);
   		layout1.getChildren().addAll(btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit);
   		myScene = new Scene(layout1, 600, 600);	
   		
   		//Layout2
   		//VBox layout2 = new VBox();
   		//layout2.getChildren().addAll(btnTranscriber, btnRec, btnBack);
   		//myScene2 = new Scene(layout2, 600, 600);
				
		//Create the new container
		//container = new Pane();
		//container.getChildren().addAll(btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit);
		
		// Create a new scene and assign within the container
		//Scene myScene = new Scene(container);
		
	
		//Assignment properties to the new stage
		//myStage.setTitle("Voice Recognition Demos Menu");
		//myStage.setMinWidth(500);
		//myStage.setMinHeight(500);

		//myStage.setFullScreen(false);
		
		// Assignment the scene to the stage
		myStage.setScene(myScene);
		
		//Show the new Stage
		myStage.show();

	}
		
	
	public static void main(String[] args) {

		/*Execute the recognition before the launch
		ButtonsMenu bm = new ButtonsMenu();
		try {
			bm.InitDemo();
		} catch (Exception e) {
			e.printStackTrace(); */
			
		//Execute the application
		launch(args);
		
		}
	
	}

