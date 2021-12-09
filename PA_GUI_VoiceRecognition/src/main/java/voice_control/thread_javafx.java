package voice_control;

import java.io.IOException;

import Classes.AlignerDemo;
import Classes.AssistantButton;
import Classes.SpeakerIdentificationDemo;
import Classes.TranscriberDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import voice_control.MenuTranscriber;

/**
 * @author luis
 */

public class thread_javafx extends Application {

	private LiveSpeechRecognizer recognizer;
	boolean active = true;
    private static Button btnTest, btnTest2, btnTranscriber1, btnBack1, btnExit;
    Scene sceneGui, sceneTr, sceneAl;
	protected String voiceCommand;
	private Stage primaryStage;
    
    public static void main(String[] args) {
        
    	launch(args);
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
           // System.out.println(result.getHypothesis());
            
            if (voiceCommand.equalsIgnoreCase("Wake Up")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
            	active=true;
                System.out.println("_____________________________________________________________ ");
				System.out.println("                                                              ");
				System.out.println("               Voice Recognition Demos Menu                   ");
				System.out.println("_____________________________________________________________ ");
				System.out.println("                                                              ");
				thread_javafx th = new thread_javafx();
				th.btnTest.setOnAction(e -> {
	    			if (! primaryStage.isShowing()) {
	    			th.btnTest.setOnAction(evn -> primaryStage.setScene(sceneTr));		
	    			

	    		}
	    	});
				
				
            

            } else if(voiceCommand.equalsIgnoreCase("Exit")) {
            	System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("                                                              ");
				System.out.println("Thanks for using the VoiceRecognition App, See you soon, bye!.");
				System.out.println("                                                              ");
				System.out.println("_____________________________________________________________ ");
				System.exit(0);

            }
            
            if(active==true) {
            	
                //TranscriberDemo
        		if (voiceCommand.equalsIgnoreCase("Transcriber")) {
        			System.out.println("                                                              ");
        			System.out.println("Voice Command is " + voiceCommand);
        			System.out.println("                                                              ");
        			System.out.println("you have selected the option 1: Transcriber");
        			//TranscriberDemo.main(null);
        			thread_javafx th = new thread_javafx();
        			th.sceneTr.getOnMouseClicked();
        			//sceneTr.getOnMouseDragOver();
        		
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
				
  	}	


    
    @Override
    public void start(Stage primaryStage) {
    	
    
        primaryStage.setTitle("demos_3btn");
        
        Stage Window = new Stage();
        
        //Scene 1 - GUI 
        Label labelGui = new Label("GUI-Menu");
        btnTest = new Button();
        btnTest.setText("Transcriber");
        
        
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
    	

    		//Exit Button action handler
    		btnExit.setOnAction(e -> {
    			if (! Window.isShowing()) {
    			btnExit.setOnAction(evn -> Window.setScene(sceneGui));		
    			System.exit(0);

    		}
    	});
    	
    	
    	primaryStage.setScene(sceneGui);
    	primaryStage.show();
    	
    	
    	
    	
    	Task<Void> controller = new Task<Void>() {
    		   @Override protected Void call() throws Exception {
    			   try {
       	            Thread.sleep(5000);
       	        } catch (InterruptedException e) {
       	        }
       	        return null;
    		   }
    		};
    		 
    		controller.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
        	    @Override
        	    public void handle(WorkerStateEvent event) {
        	
        	    	if (! Window.isShowing()) {
        	    		
        	    		
        	    		
        	    		thread_javafx fx = new thread_javafx();
        	    		try {
							fx.InitVoice();
							
	                    	
	                   
	                    	
	                    	
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        	    	}
        	    }
        	});
    		
    		new Thread(controller).start();
        	primaryStage.show();
        }
    }
    	
