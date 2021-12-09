package voice_control;


import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Classes.AlignerDemo;
import Classes.AssistantButton;
import Classes.DialogDemo;
import Classes.DigitDemo;
import Classes.SpeakerIdentificationDemo;
import Classes.ThreadVoice;
import Classes.TranscriberDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
 
/**
 * @author luis
 */

public class JavaFXDemo extends Application {
	
	
	boolean active = false;
	Scene scene;
	Scene sceneStart;
    Scene sceneDemos;
	Scene sceneTranscriber;
	Scene sceneAssistant;
	Scene sceneSpeaker;
	Scene sceneAligner;
	Button btn;
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
	private Thread voiceThread;
	private Thread guiThread;
	private LiveSpeechRecognizer recognizer;


	/*
   @Override
   public void start(Stage primaryStage) {
       

	 
	      Button btn = new Button("Text");
	      Button btnTest = new Button("Demos");
	      Button btnExit1 = new Button("Exit");
	      
	      btn.setOnAction(e -> btnClick());
	      btnTest.setOnAction(e -> primaryStage.setScene(sceneDemos));
	      
	      btnExit1.setOnAction(e -> {
	  			if (! primaryStage.isShowing()) {
	  			btnExit1.setOnAction(en -> primaryStage.setScene(scene));		
	  			System.exit(0);

	  		}
	  	});
	  	
	      VBox main = new VBox(20);     
	      main.getChildren().addAll( btn, btnTest, btnExit1);
	      main.setAlignment(Pos.BASELINE_CENTER);
	      scene = new Scene(main, 300, 300);

         // Demos Scene
           
            Button btnTranscriber = new Button("Transcriber");
         	Button btnAssistant = new Button("Assistant");
         	Button btnSpeaker= new Button("SpeakerId");
         	Button btnAligner= new Button("Aligner");
         	Button btnBack2 = new Button("Back");
         	
         	
         	
         	btnTranscriber.setOnAction(e -> primaryStage.setScene(sceneDemos));
         	
         	btnAssistant.setOnAction(e -> primaryStage.setScene(sceneDemos));
         	
         	btnSpeaker.setOnAction(e -> primaryStage.setScene(sceneDemos));
         	
         	btnAligner.setOnAction(e -> primaryStage.setScene(sceneDemos));
         	
      		btnBack2.setOnAction(e -> primaryStage.setScene(scene));
         	
         	VBox demos = new VBox(20);     
         	demos.getChildren().addAll(btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnBack2 );
         	demos.setAlignment(Pos.BASELINE_CENTER);
         	sceneDemos = new Scene(demos, 300, 300);
         	
         	primaryStage.setTitle("Voice Recognition Demo");
            primaryStage.setScene(scene);
            primaryStage.show();
   */
	
	  @Override
	  public void start(Stage primaryStage) throws UnsupportedAudioFileException, IOException, LineUnavailableException, Exception {
		//Start Container
			primaryStage.setTitle("Start the App");
	      
	      
	      
	      //Scene 0 - Start_GUI 
	      Label labelGui = new Label("GUI-Menu");
	      Button btnTest = new Button("Start");
	      Button btnExit1 = new Button("Exit");
	      
	      
	      btnTest.setOnAction(e -> primaryStage.setScene(sceneDemos));
	      
	    //Exit Button action handler
			btnExit1.setOnAction(e -> {
				if (! primaryStage.isShowing()) {
				btnExit1.setOnAction(evn -> primaryStage.setScene(sceneStart));		
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
	  	Button btnExit2 = new Button("Back");
	  	
	  	
	  	
	  	btnTranscriber.setOnAction(e -> primaryStage.setScene(sceneTranscriber));
	  	
	  	btnAssistant.setOnAction(e -> primaryStage.setScene(sceneAssistant));
	  	
	  	btnSpeaker.setOnAction(e -> primaryStage.setScene(sceneSpeaker));
	  	
	  	btnAligner.setOnAction(e -> primaryStage.setScene(sceneAligner));
	  	
	  	btnExit2.setOnAction(evn -> primaryStage.setScene(sceneStart));
	  	
	  	
	  	VBox layoutMenu = new VBox(20);     
	  	layoutMenu.getChildren().addAll(labelMenu, btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit2 );
	  	layoutMenu.setAlignment(Pos.BASELINE_CENTER);
	  	sceneDemos = new Scene(layoutMenu, 300, 300);
	                 
	  	//Scene 2 - TranscriberButton ------------------------
	  	Label labelTranscriber= new Label("TranscriberDemo Menu");
	  	
	  	//TranscriberDemo
	  	Button btnTranscriber1 = new Button("TranscriberDemo");
	  	btnTranscriber1.setOnAction(e -> {
	  		if (! primaryStage.isShowing()) {
	  			btnTranscriber1.setOnAction(evn -> primaryStage.setScene(sceneTranscriber));
	  			
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
	  		if (! primaryStage.isShowing()) {
	  			btnRec.setOnAction(evn -> primaryStage.setScene(sceneTranscriber));
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
	  		if (! primaryStage.isShowing()) {
	  			btnDigit.setOnAction(evn -> primaryStage.setScene(sceneAssistant));
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
	  		if (! primaryStage.isShowing()) {
	  			btnDialog.setOnAction(evn -> primaryStage.setScene(sceneAssistant));
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
	  		if (! primaryStage.isShowing()) {
	  			btnBank.setOnAction(evn -> primaryStage.setScene(sceneAssistant));
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
	  		if (! primaryStage.isShowing()) {
	  			btnSpeaker1.setOnAction(evn -> primaryStage.setScene(sceneSpeaker));
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
	  		if (! primaryStage.isShowing()) {
	  			btnAligner1.setOnAction(evn -> primaryStage.setScene(sceneAligner));
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
	   

	 
	  		
	  //btnExit1.setOnAction(evn -> primaryStage.setScene(sceneStart));

	  		
	  	
	    
	  		primaryStage.setScene(sceneStart);
	  		primaryStage.show();
            
            //GUI Thread
         	guiThread = new Thread(new Runnable() {

                @Override
                public void run() {
             	   JavaFXDemo v = new JavaFXDemo();
                    try {
                    	 v.init();
                         
     			} catch (Exception e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}


                }
            });
       guiThread.start();
            
       //Voice Thread
       voiceThread = new Thread(new Runnable() {

           @Override
           public void run() {
        	   JavaFXDemo v = new JavaFXDemo();
               try {
				v.InitDemos(primaryStage);;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


           }
       });
       voiceThread.start();
   }
   
   public void btnClick() {
       
	   System.out.println("This is a Test");
   }
   
   public void sceneClick(Stage primaryStage,LiveSpeechRecognizer recognizer) {
	   JavaFXDemo v = new JavaFXDemo();
	   btnTest.setOnAction(e -> primaryStage.setScene(sceneDemos));
	  
   }
   
   //Voice Thread
   public void startVoice(Stage primaryStage ,LiveSpeechRecognizer recognizer) {
       System.out.println("Running Now...");
       voiceThread.start();
   }

   public void pauseVoice(Stage primaryStage, LiveSpeechRecognizer recognizer) throws InterruptedException {
       System.out.println("Paused Now...");
       voiceThread.wait();
   }

   public void resumeVoice(Stage primaryStage, LiveSpeechRecognizer recognizer) {
       System.out.println("Resuming Now...");
       voiceThread.notify();
   }
   

public static void main(String[] args) {
       launch(args);
   }
   
   public void InitDemos(Stage primaryStage) throws Exception {
       
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


	    
		try {
           recognizer = new LiveSpeechRecognizer(configuration);
       } catch (IOException e) {
           System.out.println(e);
       }
        
       //Start speech recognition 
		startSpeechRecognition(primaryStage, null);
       
   }
   
	private void startSpeechRecognition(Stage primaryStage, String voiceCommand) throws IOException  {
	// TODO Auto-generated method stub
		   //Start Recognition Process (The boolean parameter clears the previous cache if true)
	      recognizer.startRecognition(true);
	      
	      //Creating SpeechResult object
	      SpeechResult result;

	      //Check if recognizer recognized the speech
	      while ((result = recognizer.getResult()) != null) {
	      	
	          //Get the recognized speech
	          String voiceCommand1 = result.getHypothesis();
	          
	          System.out.println(result.getHypothesis());
	          
	          
	          if (voiceCommand1.equalsIgnoreCase("Wake up")) {
	        	  
	        	  JavaFXDemo gui = new JavaFXDemo();
	        	  System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand1);
					System.out.println("                                                              ");
					active=true;
					try {
						ThreadVoice.sleep(2000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					gui.sceneDemos.getOnMouseClicked();
					
					

	          } else if(voiceCommand1.equalsIgnoreCase("Exit")) {
	          	System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand1);
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
			if (voiceCommand.equalsIgnoreCase("wake up")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 1: Transcriber");

				//primaryStage.setScene(sceneDemos);
		
			
				//wakeup
			} else if (voiceCommand.equalsIgnoreCase("Wake Up")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				//System.out.println("you have selected the option 2: Assistant");
				//AssistantButton.main(null);
				btnTest.setOnAction(e -> primaryStage.setScene(sceneDemos));
			
			//AssistantDemo
			} else if (voiceCommand.equalsIgnoreCase("Assistant")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 2: Assistant");
		
			//SpeakerIdDemo	
			} else if (voiceCommand.equalsIgnoreCase("Speaker")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 3: SpeakerId");
				

			//AlignerDemo
			} else if (voiceCommand.equalsIgnoreCase("Aligner")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 4: Aligner");
				
				
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
