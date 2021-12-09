package voice_control;


import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;

import Classes.AlignerDemo;
import Classes.AssistantButton;
import Classes.DialogDemo;
import Classes.DigitDemo;
import Classes.SpeakerIdentificationDemo;
import Classes.TranscriberDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import voice_control.MenuTranscriber;

/**
 * @author luis
 */


public class Ambulance extends Application {
    Task copyWorker;
    private LiveSpeechRecognizer recognizer;
	boolean active = true;
    Scene sceneStart;
    Scene sceneDemos;
	Scene sceneTranscriber;
	Scene sceneAssistant;
	Scene sceneSpeaker;
	Scene sceneAligner;
	Button btnTest;
	Button btnTranscriber;
	Button btnTranscriber1;
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
	Button btnExit1;
	Stage windows;

	protected String voiceCommand;
	protected Object primaryStage;
	
    public static void main(String[] args) {
        Application.launch(args);
    }
    
public void InitVoice(Object primaryStage) throws Exception {
        
	    //Configuration Object
	    Configuration configuration = new Configuration();
		 
	    // Set path to the acoustic model.
	    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
	    // Set path to the language model (vocabulary model).
	    configuration.setDictionaryPath("resources/assistant/2729.dic");
	    configuration.setLanguageModelPath("resources/assistant/2729.lm");
		
	    
	    
		System.out.println("_______________________________________________________________________________________________ ");
	    System.out.println("                                                              ");
	    System.out.println("   Welcome to the Speech Recognition Project      		  ");
	    System.out.println("_______________________________________________________________________________________________");
	    System.out.println("                                                              ");
		System.out.println("   This is a program that executes specific actions through real time speech recognition");
		System.out.println("_______________________________________________________________________________________________ ");
		System.out.println("                                                              ");
		System.out.println("   To continue, please choose one of the voice commands and follow the respective instructions: ");
		System.out.println("_______________________________________________________________________________________________ ");
		System.out.println("                                     						  ");
		System.out.println("  'Wake Up'- This command allows you to initialize the voice recognition in real time                            ");
		System.out.println("  'Exit'- Through this command the navigation process is canceled and the program is exited.                              ");
		System.out.println("                                                              ");
		System.out.println("_______________________________________________________________________________________________");
	

	    
		try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            System.out.println(e);
        }
         
        //Start speech recognition 
        startSpeechRecognition1(windows);
        
}
    
  	private void startSpeechRecognition1(Stage windows) {
	// TODO Auto-generated method stub
	
}

	public void startSpeechRecognition1() throws Exception {
        
  		Ambulance gui = new Ambulance();
  		 Stage windows = null;
        //Start Recognition Process (The boolean parameter clears the previous cache if true)
        recognizer.startRecognition(true);
        
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognizer.getResult()) != null) {
        	
            //Get the recognized speech
            String voiceCommand = result.getHypothesis();
            
            System.out.println(result.getHypothesis());
            
            
            if (voiceCommand.equalsIgnoreCase("wake up")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				active=true;

				
				btnTest.setOnAction(e -> windows.setScene(sceneDemos));
				 
            		
            	

            } else if(voiceCommand.equalsIgnoreCase("Exit")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				active=false;
				
				System.out.println("                                                              ");
				System.out.println("Thanks for using the VoiceRecognition App, See you soon, bye!.");
				System.out.println("                                                              ");
				System.out.println("_____________________________________________________________ ");
				System.exit(0);

            }
				
        }
  			
  	if(active==true) {
  		
        //TranscriberDemo
		if (voiceCommand.equalsIgnoreCase("Transcriber")) {
			System.out.println("                                                              ");
			System.out.println("Voice Command is " + voiceCommand);
			System.out.println("                                                              ");
			System.out.println("you have selected the option 1: Transcriber");

			//gui.sceneTr.addEventHandler(null, null);
	
		
		
		//AssistantDemo
		} else if (voiceCommand.equalsIgnoreCase("Assistant")) {
			System.out.println("                                                              ");
			System.out.println("Voice Command is " + voiceCommand);
			System.out.println("                                                              ");
			System.out.println("you have selected the option 2: Assistant");
			AssistantButton.main(null);
		
		//SpeakerIdDemo	
		} else if (voiceCommand.equalsIgnoreCase("Speaker")) {
			System.out.println("                                                              ");
			System.out.println("Voice Command is " + voiceCommand);
			System.out.println("                                                              ");
			System.out.println("you have selected the option 3: SpeakerId");
			SpeakerIdentificationDemo.main(null);

		//AlignerDemo
		} else if (voiceCommand.equalsIgnoreCase("Aligner")) {
			System.out.println("                                                              ");
			System.out.println("Voice Command is " + voiceCommand);
			System.out.println("                                                              ");
			System.out.println("you have selected the option 4: Aligner");
			AlignerDemo.main(null);
			
		//Exit the programm
		} else if (voiceCommand.equalsIgnoreCase("exit")) {
			System.out.println("                                                              ");
			System.out.println("Voice Command is " + voiceCommand);
			System.out.println("                                                              ");
			System.out.println("you have selected the option 5: Exit..                        ");
			System.out.println("_____________________________________________________________ ");
			System.out.println("                                                              ");
			System.out.println("Thanks for using the VoiceRecognition App, See you soon, bye!.");
			System.out.println("                                                              ");
			System.out.println("_____________________________________________________________ ");
			System.exit(0);
			}
		
        }	
        
  	}
    
  	
    
  	public void start(Stage primaryStage) {
        
  		//Start Container
  		primaryStage.setTitle("Start the App");
        
        Stage Window = new Stage();
        
        //Scene 0 - Start_GUI 
        Label labelGui = new Label("GUI-Menu");
        Button btnTest = new Button("Start");
        Button btnExit1 = new Button("Exit");
        
        
        btnTest.setOnAction(e -> primaryStage.setScene(sceneDemos));
        
      //Exit Button action handler
		btnExit1.setOnAction(e -> {
			if (! Window.isShowing()) {
			btnExit1.setOnAction(evn -> Window.setScene(sceneDemos));		
			System.exit(0);
            System.out.println("The Process was canceled, thank you for using this speech recognition software");

		}
	});
    	
        VBox layoutGui = new VBox(20);     
        layoutGui.getChildren().addAll(labelGui, btnTest, btnExit1);
        layoutGui.setAlignment(Pos.BASELINE_CENTER);
        sceneStart = new Scene(layoutGui, 300, 300);
        
    	//Main Menu Container	
    	primaryStage.setTitle("GUI Voice Recognition Main Menu");
    	
    	
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
    	sceneDemos = new Scene(layoutMenu, 300, 300);
                   
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
    	btnBack1.setOnAction(e -> primaryStage.setScene(sceneDemos));
    	
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
    		btnBack2.setOnAction(e -> primaryStage.setScene(sceneDemos));
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
    	btnBack3.setOnAction(e -> primaryStage.setScene(sceneDemos));
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
    	btnBack4.setOnAction(e -> primaryStage.setScene(sceneDemos));
    	VBox layoutAligner= new VBox(20);
    	layoutAligner.getChildren().addAll(labelAligner, btnAligner1, btnBack4);
    	layoutAligner.setAlignment(Pos.BASELINE_CENTER);
    	sceneAligner= new Scene(layoutAligner,300,300);
     

    		//Exit Button action handler
    		btnExit.setOnAction(e -> {
    			if (! Window.isShowing()) {
    			btnExit.setOnAction(evn -> Window.setScene(sceneDemos));		
    			System.out.println("The Process was canceled, thank you for using this speech recognition software");
    			System.exit(0);
                

    		}
    	});
    	
    	

    	btnTest.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	btnTest.setDisable(true);
                
            	btnExit1.setDisable(false);
                copyWorker = createWorker();

                
                
               
                //copyWorker.messageProperty().addListener(new ChangeListener<String>() {
                    //public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        //System.out.println(newValue);
                    //}
                //});

                new Thread(copyWorker).start();
            }
        });
      //Exit Button action handler
        btnExit1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	btnTest.setDisable(false);
            	System.out.println("The Process was canceled, thank you for using this speech recognition software");
                System.exit(0);
                
            }
        });
    		

    		
    		primaryStage.setScene(sceneStart);
        	primaryStage.show();
  	}
    
    public Task createWorker() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(2000);
                    updateMessage("voice recognition will start");
                
                    Ambulance h = new Ambulance();
                    h.startSpeechRecognition1();
                    
                    updateProgress(i + 1, 10);
                }
                return null;
            }
            
        };
    }
    
    
    
    
}
