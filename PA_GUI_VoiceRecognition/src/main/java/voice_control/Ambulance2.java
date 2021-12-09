package voice_control;


import javafx.concurrent.Task;

import java.io.IOException;

import Classes.AlignerDemo;
import Classes.AssistantButton;
import Classes.SpeakerIdentificationDemo;
import Classes.TranscriberDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import voice_control.GUI_Demos;
import voice_control.MenuTranscriber;

/**
 * @author luis
 */


public class Ambulance2 extends Application {
    Task copyWorker;
    private LiveSpeechRecognizer recognizer;
	boolean active = false;
    private static Button btnTest, btnTest2, btnTranscriber1, btnBack1, btnExit;
    Scene sceneGui, sceneTr;
    Stage windows;
    
    protected String voiceCommand;
	protected Stage primaryStage;
    public static void main(String[] args) {
        Application.launch(args);
    }
    
public void InitVoice() throws Exception {
        
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
        startSpeechRecognition1();
        
}
    
  	public void startSpeechRecognition1() throws Exception {
        
  		
  		
        //Start Recognition Process (The boolean parameter clears the previous cache if true)
        recognizer.startRecognition(true);
        
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognizer.getResult()) != null) {
        	
            //Get the recognized speech
            String voiceCommand = result.getHypothesis();
            
            System.out.println(result.getHypothesis());
            
            
            if (voiceCommand.equalsIgnoreCase("Wake Up")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				active=true;
            	Ambulance2 gui = new Ambulance2();
            	//copyWorker.setOnRunning(null);
            	//gui.primaryStage.setScene(null);
            	gui.copyWorker.getState().wait(300);
            	gui.sceneTr.getOnMouseClicked();
            	//return;
            	
            	
            	
            	//MenuPrincipal.launch(null);
            			
            		
            	

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
			//TranscriberDemo.main(null);
			
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
        primaryStage.setTitle("demos_3btn");
        
        Stage Window = new Stage();
        
        //Scene 1 - GUI 
        Label labelGui = new Label("GUI-Menu");
        btnTest = new Button();
        btnTest.setText("Start");
        
        
        btnExit = new Button();
        btnExit.setText("Exit");
        
        btnTest.setOnAction(e -> primaryStage.setScene(sceneTr));
    	
       

        
        VBox layoutGui = new VBox(20);     
        layoutGui.getChildren().addAll(labelGui, btnTest, btnExit);
        layoutGui.setAlignment(Pos.BASELINE_CENTER);
    	sceneGui = new Scene(layoutGui, 300, 300);
        
    	//Scene 2 - TranscriberButton ------------------------
    	Label labelTranscriber= new Label("TranscriberDemo Menu");
    	
    	//TranscriberDemo
    	Button btnTranscriber1 = new Button("TranscriberDemo");
    	btnTranscriber1.setOnAction(e -> {
    		if (! Window.isShowing()) {
    			btnTranscriber1.setOnAction(evn -> Window.setScene(sceneGui));
    			
    		try {
    			TranscriberDemo.main(null);
    		} catch (Exception e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		
    		}
    	});
    	
    	//Back to the main menu
    	Button btnBack1= new Button("Back");
    	btnBack1.setOnAction(e -> primaryStage.setScene(sceneGui));
    	
    	VBox layoutTranscriber= new VBox(20);
    	layoutTranscriber.getChildren().addAll(labelTranscriber, btnTranscriber1, btnBack1 );
    	layoutTranscriber.setAlignment(Pos.BASELINE_CENTER);
    	sceneTr = new Scene(layoutTranscriber,300,300);
    	
    	

    	btnTest.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	btnTest.setDisable(true);
                
            	btnExit.setDisable(false);
                copyWorker = createWorker();

                
                
               
                copyWorker.messageProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        System.out.println(newValue);
                    }
                });

                new Thread(copyWorker).start();
            }
        });
    	
    	
    	//Start Button action handler
    	btnTest.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	btnTest.setDisable(false);
           
            	Ambulance2 tjfx = new Ambulance2();
        		try {
					tjfx.InitVoice();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
            }
        });
        
      //Exit Button action handler
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	btnTest.setDisable(false);
           
                System.out.println("The Process was canceled, thank you for using this speech recognition software");
                System.exit(0);
            }
        });

    		
    		primaryStage.setScene(sceneGui);
        	primaryStage.show();
  	}
 
    public Task createWorker() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(100);
                    updateMessage("voice recognition will start");
                    Ambulance2 tjfx = new Ambulance2();
            		tjfx.InitVoice();
                    //updateProgress(i + 1, 10);
                    
                    
                }
                return Thread.getDefaultUncaughtExceptionHandler();

            }
            
        };
    }  
}
