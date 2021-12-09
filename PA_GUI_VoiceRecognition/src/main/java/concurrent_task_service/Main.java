package concurrent_task_service;

import java.io.IOException;
import concurrent_task_service.AlignerDemo;
import concurrent_task_service.AssistantDemo;
import concurrent_task_service.TranscriberDemo;
import concurrent_task_service.SpeakerIdentificationDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author luis san martin
 */

public class Main extends Application {
	
	
	boolean active = false;
	Scene sceneStart;
    Scene sceneDemos;
	Scene sceneTranscriber;
	Scene sceneAssistant;
	Scene sceneSpeaker;
	Scene sceneAligner;
	public Button btnTranscriber;
	public Button btnTranscriber1;
	public Button btnAssistant;
	public Button btnAssistant1;
	public Button btnSpeaker;
	public Button btnSpeaker1;
	public Button btnAligner;
	public Button btnAligner1;
	public Button btnBack1;
	public Button btnBack2;
	public Button btnBack3;
	public Button btnBack4;
	public Button btnExit;
	public Button btnTest;
	private Thread voiceThread;
	private LiveSpeechRecognizer recognizer;
	Stage primaryStage_;

	@Override
	  public void start(Stage primaryStage) throws IOException,  Exception {
		primaryStage_ = primaryStage;
		//Start Container
		
			primaryStage.setTitle("Voice Recognition");

	      //Scene 0 - Start_GUI 
	      Label labelGui = new Label("InitMenu");
	      btnTest = new Button("Demos");

	      btnTest.setOnAction(e -> test(primaryStage));

	      VBox layoutGui = new VBox(20);     
	      layoutGui.getChildren().addAll(labelGui, btnTest);
	      layoutGui.setAlignment(Pos.BASELINE_CENTER);
	      sceneStart = new Scene(layoutGui, 300, 300);
	      
	  	//Main Menu Container	
	      primaryStage.setTitle("Voice Recognition");
	   
	  	
	  	//Scene 1 - Main Menu ---------------------
	  	Label labelMenu= new Label("DemosMenu");
	  	btnTranscriber = new Button("Transcriber");
	  	btnAssistant = new Button("Assistant");
	  	btnSpeaker= new Button("SpeakerId");
	  	btnAligner= new Button("Aligner");
	  	btnExit = new Button("Back");
	  	

	  	btnTranscriber.setOnAction(e -> primaryStage.setScene(sceneTranscriber));
	  	
	  	btnAssistant.setOnAction(e -> primaryStage.setScene(sceneAssistant));
	  	
	  	btnSpeaker.setOnAction(e -> primaryStage.setScene(sceneSpeaker));
	  	
	  	btnAligner.setOnAction(e -> primaryStage.setScene(sceneAligner));
	  	
	  	btnExit.setOnAction(e -> sceneChange(primaryStage));
	  	
	  	
	  	VBox layoutMenu = new VBox(20);     
	  	layoutMenu.getChildren().addAll(labelMenu, btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit );
	  	layoutMenu.setAlignment(Pos.BASELINE_CENTER);
	  	sceneDemos = new Scene(layoutMenu, 300, 300);
	                 
	  	//Scene 2 - TranscriberButton ------------------------
	  	Label labelTranscriber= new Label("TranscriberDemo Menu");
	  	
	  	//TranscriberDemo
	  	btnTranscriber1 = new Button("TranscriberDemo");
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
	  	
	  
	  	
	  	//Back to the main menu
	  	btnBack1= new Button("Back");
	  	btnBack1.setOnAction(e -> primaryStage.setScene(sceneDemos));
	  	
	  	VBox layoutTranscriber= new VBox(20);
	  	layoutTranscriber.getChildren().addAll(labelTranscriber, btnTranscriber1, btnBack1 );
	  	layoutTranscriber.setAlignment(Pos.BASELINE_CENTER);
	  	sceneTranscriber= new Scene(layoutTranscriber,300,300);

	  	//Scene - AssistantButton 
	  	Label labelAssistant= new Label("AssistantButton");
	  	
	  	
	  	btnAssistant1= new Button("AssistantDemo");
	  	btnAssistant1.setOnAction(e -> {
	  		if (! primaryStage.isShowing()) {
	  			btnAssistant1.setOnAction(evn -> primaryStage.setScene(sceneAssistant));
	  		try {
	  			AssistantDemo.main(null);
	  		} catch (Exception e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		}
	  		
	  		}
	  	});
	  	
	  	
	  	
	  	//Back to the main menu
	  		btnBack2= new Button("Back");
	  		btnBack2.setOnAction(e -> primaryStage.setScene(sceneDemos));
	  	VBox layoutAssistant= new VBox(20);
	  	layoutAssistant.getChildren().addAll(labelAssistant, btnAssistant1, btnBack2);
	  	layoutAssistant.setAlignment(Pos.BASELINE_CENTER);
	  	sceneAssistant= new Scene(layoutAssistant,300,300);

	  	//Scene - SpeakerIdButton
	  	Label labelSpeaker= new Label("SpeakerIdButton");
	  	
	  	//SpeakerIdDemo
	  	btnSpeaker1= new Button("SpeakerId");
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
	  	btnBack3= new Button("Back");
	  	btnBack3.setOnAction(e -> primaryStage.setScene(sceneDemos));
	  	VBox layoutSpeaker= new VBox(20);
	  	layoutSpeaker.getChildren().addAll(labelSpeaker, btnSpeaker1, btnBack3);
	  	layoutSpeaker.setAlignment(Pos.BASELINE_CENTER);
	  	sceneSpeaker= new Scene(layoutSpeaker,300,300);

	  	//Scene 5 - AlignerButton
	  	Label labelAligner= new Label("AlignerButton");

	  	//AlignerDemo
	  	btnAligner1= new Button("AlignerDemo");
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
	  	btnBack4= new Button("Back");
	  	btnBack4.setOnAction(e -> primaryStage.setScene(sceneDemos));
	  	VBox layoutAligner= new VBox(20);
	  	layoutAligner.getChildren().addAll(labelAligner, btnAligner1, btnBack4);
	  	layoutAligner.setAlignment(Pos.BASELINE_CENTER);
	  	sceneAligner= new Scene(layoutAligner,300,300);
	   
	 
  			if (! primaryStage.isShowing()) {
  			btnExit.setOnAction(evn -> primaryStage.setScene(sceneStart));		
  			}
	    
	  		primaryStage.setScene(sceneStart);
	  		primaryStage.show();
	  		

	voiceThread = new Thread(new Runnable() {

        @Override
        public void run() {
        	 Main v = new Main();
            try {
				v.InitDemo(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
    });
    voiceThread.start();
}
	
	public void stageChange(Stage stage) {
        // JavaFX stuff needs to be done on JavaFX thread
		Platform.runLater(new Runnable() {
            
			@Override
            public void run() {
            	
				
				//Main Menu Container	
				stage.setTitle("Start the App");
			  	
			  	
			  	//Scene 1 - Main Menu ---------------------
			  	Label labelMenu= new Label("Main Menu");
			  	btnTranscriber = new Button("Transcriber");
			  	btnAssistant = new Button("Assistant");
			  	btnSpeaker= new Button("SpeakerId");
			  	btnAligner= new Button("Aligner");
			  	btnExit = new Button("Back");
			  	
			  	
			  	
			  	btnTranscriber.setOnAction(e -> stage.setScene(sceneTranscriber));
			  	
			  	btnAssistant.setOnAction(e -> stage.setScene(sceneAssistant));
			  	
			  	btnSpeaker.setOnAction(e -> stage.setScene(sceneSpeaker));
			  	
			  	btnAligner.setOnAction(e -> stage.setScene(sceneAligner));

			  	btnExit.setOnAction(e -> initAgainMenuDemos(stage));

			  	VBox layoutMenu = new VBox(20);     
			  	layoutMenu.getChildren().addAll(labelMenu, btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit );
			  	layoutMenu.setAlignment(Pos.BASELINE_CENTER);
			  	sceneDemos = new Scene(layoutMenu, 300, 300);
			                 
			  	//Scene 2 - TranscriberButton ------------------------
			  	Label labelTranscriber= new Label("TranscriberDemo Menu");
			  	
			  	//TranscriberDemo
			  	btnTranscriber1 = new Button("TranscriberDemo");
			  	btnTranscriber1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnTranscriber1.setOnAction(evn -> stage.setScene(sceneTranscriber));
			  			
			  		try {
			  			TranscriberDemo.main(null);
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  	//Back to the main menu
			  	btnBack1= new Button("Back");
			  	btnBack1.setOnAction(e -> stage.setScene(sceneDemos));
			  	
			  	VBox layoutTranscriber= new VBox(20);
			  	layoutTranscriber.getChildren().addAll(labelTranscriber, btnTranscriber1, btnBack1 );
			  	layoutTranscriber.setAlignment(Pos.BASELINE_CENTER);
			  	sceneTranscriber= new Scene(layoutTranscriber,300,300);

			  	//Scene - AssistantButton ------------------------
			  	Label labelAssistant= new Label("AssistantButton");
			  	
			  	btnAssistant1 = new Button("AssistantDemo");
			  	btnAssistant1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnAssistant1.setOnAction(evn -> stage.setScene(sceneAssistant));
			  		try {
			  			AssistantDemo.main(null);
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  	
			  	//Back to the main menu
			  		btnBack2= new Button("Back");
			  		btnBack2.setOnAction(e -> stage.setScene(sceneDemos));
			  	VBox layoutAssistant= new VBox(20);
			  	layoutAssistant.getChildren().addAll(labelAssistant, btnAssistant, btnBack2);
			  	layoutAssistant.setAlignment(Pos.BASELINE_CENTER);
			  	sceneAssistant= new Scene(layoutAssistant,300,300);

			  	//Scene 4 - SpeakerIdButton
			  	Label labelSpeaker= new Label("SpeakerIdButton");
			  	
			  	//SpeakerIdDemo
			  	btnSpeaker1= new Button("SpeakerId");
			  	btnSpeaker1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnSpeaker1.setOnAction(evn -> stage.setScene(sceneSpeaker));
			  		try {
			  			SpeakerIdentificationDemo.main(null);
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  	//Back to the main menu
			  	btnBack3= new Button("Back");
			  	btnBack3.setOnAction(e -> stage.setScene(sceneDemos));
			  	VBox layoutSpeaker= new VBox(20);
			  	layoutSpeaker.getChildren().addAll(labelSpeaker, btnSpeaker1, btnBack3);
			  	layoutSpeaker.setAlignment(Pos.BASELINE_CENTER);
			  	sceneSpeaker= new Scene(layoutSpeaker,300,300);

			  	//Scene - AlignerButton
			  	Label labelAligner= new Label("AlignerButton");

			  	//AlignerDemo
			  	btnAligner1= new Button("AlignerDemo");
			  	btnAligner1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnAligner1.setOnAction(evn -> stage.setScene(sceneAligner));
			  		try {
			  			AlignerDemo.main(null);
			  			
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  	//Back to the main menu
			  	btnBack4= new Button("Back");
			  	btnBack4.setOnAction(e -> stage.setScene(sceneDemos));
			  	VBox layoutAligner= new VBox(20);
			  	layoutAligner.getChildren().addAll(labelAligner, btnAligner1, btnBack4);
			  	layoutAligner.setAlignment(Pos.BASELINE_CENTER);
			  	sceneAligner= new Scene(layoutAligner,300,300);
			  	
			  	
            	sceneChange(stage);

            }
        });
    }

	public void stageClose(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
	      public void run()
	      {        
	    	  stage.close();
	      }
	    });
	  }
	
	
	public void sceneChange(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
	      public void run()
	      {        

	    	  	
	    	  stage.setScene(sceneDemos);
	    	  stage.show();

	      }
	    });
	  }
	
	public void initAgainMenuStart(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
            public void run() {
	    		
	    		
	    		stage.setTitle("Start the App");

	  	      //Scene - Start_GUI 
	  	      Label labelGui = new Label("GUI-Menu");
	  	      btnTest = new Button("Demos");

	  	      btnTest.setOnAction(e -> test(stage));

	  	      VBox layoutGui = new VBox(20);     
	  	      layoutGui.getChildren().addAll(labelGui, btnTest);
	  	      layoutGui.setAlignment(Pos.BASELINE_CENTER);
	  	      sceneStart = new Scene(layoutGui, 300, 300);
	    		
	    	
	    	  
	    	  stage.setScene(sceneStart);
	    	  stage.show();
	    	  

	      }
	    });
	  }
	
	public void initAgainMenuDemos(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
            public void run() {
	    		
	    		
	    		//Main Menu Container	
				stage.setTitle("Start the App");
			  	
			  	
			  	//Scene 1 - Main Menu ---------------------
			  	Label labelMenu= new Label("Main Menu");
			  	btnTranscriber = new Button("Transcriber");
			  	btnAssistant = new Button("Assistant");
			  	btnSpeaker= new Button("SpeakerId");
			  	btnAligner= new Button("Aligner");
			  	btnExit = new Button("Back");
			  	
			  	
			  	
			  	btnTranscriber.setOnAction(e -> stage.setScene(sceneTranscriber));
			  	
			  	btnAssistant.setOnAction(e -> stage.setScene(sceneAssistant));
			  	
			  	btnSpeaker.setOnAction(e -> stage.setScene(sceneSpeaker));
			  	
			  	btnAligner.setOnAction(e -> stage.setScene(sceneAligner));

			  	btnExit.setOnAction(e -> initAgainMenuDemos(stage));

			  	VBox layoutMenu = new VBox(20);     
			  	layoutMenu.getChildren().addAll(labelMenu, btnTranscriber, btnAssistant, btnSpeaker, btnAligner, btnExit );
			  	layoutMenu.setAlignment(Pos.BASELINE_CENTER);
			  	sceneDemos = new Scene(layoutMenu, 300, 300);
	    		
	    	
	    	  //stage.close();
	    	  stage.setScene(sceneDemos);
	    	  stage.show();
	    	  

	      }
	    });
	  }
	
	public void initAgainMenuTranscriber(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
            public void run() {
	    		
	    		
	    		//Scene - Transcriber 
			  	Label labelTranscriber= new Label("TranscriberDemo Menu");
			  	
			  	//TranscriberDemo
			  	btnTranscriber1 = new Button("TranscriberDemo");
			  	btnTranscriber1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnTranscriber1.setOnAction(evn -> stage.setScene(sceneTranscriber));
			  			
			  		try {
			  			TranscriberDemo.main(null);
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  	
			  	//Back to the main menu
			  	btnBack1= new Button("Back");
			  	btnBack1.setOnAction(e -> stage.setScene(sceneDemos));
			  	
			  	VBox layoutTranscriber= new VBox(20);
			  	layoutTranscriber.getChildren().addAll(labelTranscriber, btnTranscriber1, btnBack1 );
			  	layoutTranscriber.setAlignment(Pos.BASELINE_CENTER);
			  	sceneTranscriber= new Scene(layoutTranscriber,300,300);
	    	  
	    	  stage.setScene(sceneTranscriber);
	    	  stage.show();
	    	  

	      }
	    });
	  }
	
	public void initAgainMenuAssistant(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
            public void run() {
	    		
	    		//Scene - AssistantButton 
			  	Label labelAssistant= new Label("AssistantButton");
			  
			  	btnAssistant1= new Button("AssistantDemo");
			  	btnAssistant1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnAssistant1.setOnAction(evn -> stage.setScene(sceneAssistant));
			  		try {
			  			AssistantDemo.main(null);
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  	//Back to the main menu
			  		btnBack2= new Button("Back");
			  		btnBack2.setOnAction(e -> stage.setScene(sceneDemos));
			  	VBox layoutAssistant= new VBox(20);
			  	layoutAssistant.getChildren().addAll(labelAssistant, btnAssistant, btnBack2);
			  	layoutAssistant.setAlignment(Pos.BASELINE_CENTER);
			  	sceneAssistant= new Scene(layoutAssistant,300,300);
	    		
	    	
	    	  
	    	  stage.setScene(sceneAssistant);
	    	  stage.show();
	    	  

	      }
	    });
	  }
	
	public void initAgainMenuSpeaker(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
            public void run() {
	    		
	    		//Scene - SpeakerIdButton
			  	Label labelSpeaker= new Label("SpeakerIdButton");
			  	
			  	//SpeakerIdDemo
			  	btnSpeaker1= new Button("SpeakerDemo");
			  	btnSpeaker1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnSpeaker1.setOnAction(evn -> stage.setScene(sceneSpeaker));
			  		try {
			  			SpeakerIdentificationDemo.main(null);
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  //Back to the main menu
			  	btnBack3= new Button("Back");
			  	btnBack3.setOnAction(e -> stage.setScene(sceneDemos));
			  	VBox layoutSpeaker= new VBox(20);
			  	layoutSpeaker.getChildren().addAll(labelSpeaker, btnSpeaker1, btnBack3);
			  	layoutSpeaker.setAlignment(Pos.BASELINE_CENTER);
			  	sceneSpeaker= new Scene(layoutSpeaker,300,300);
	    	  
	    	  stage.setScene(sceneSpeaker);
	    	  stage.show();
	    	  

	      }
	    });
	  }
	
	public void initAgainMenuAligner(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
            public void run() {
	    		
	    		//Scene 5 - AlignerButton
			  	Label labelAligner= new Label("AlignerButton");

			  	//AlignerDemo
			  	btnAligner1= new Button("AlignerDemo");
			  	btnAligner1.setOnAction(e -> {
			  		if (! stage.isShowing()) {
			  			btnAligner1.setOnAction(evn -> stage.setScene(sceneAligner));
			  		try {
			  			AlignerDemo.main(null);
			  			
			  		} catch (Exception e1) {
			  			// TODO Auto-generated catch block
			  			e1.printStackTrace();
			  		}
			  		
			  		}
			  	});
			  	
			  	//Back to the main menu
			  	btnBack4= new Button("Back");
			  	btnBack4.setOnAction(e -> stage.setScene(sceneDemos));
			  	VBox layoutAligner= new VBox(20);
			  	layoutAligner.getChildren().addAll(labelAligner, btnAligner1, btnBack4);
			  	layoutAligner.setAlignment(Pos.BASELINE_CENTER);
			  	sceneAligner= new Scene(layoutAligner,300,300);
	    		
	    	
	    	  
	    	  stage.setScene(sceneAligner);
	    	  stage.show();
	    	  

	      }
	    });
	  }
	
	public void test(Stage stage) {
	    Platform.runLater(new Runnable()
	    {
	    	@Override
	      public void run()
	      {   
	    	  
	    	  //sceneClose(stage);
	    	  sceneChange(stage);
	    	  
	    	  
	      }
	    });
	  }

	public void InitDemo(Stage primaryStage) throws Exception {
        
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
        startSpeechRecognition(primaryStage);
        
}
    
  	public void startSpeechRecognition(Stage primaryStage) throws Exception {
        
  		
  		
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
		            	active=false;
		 
							Platform.runLater(new Runnable()
						    {
						    	@Override
						      public void run()
						      {    
						    		initAgainMenuDemos(primaryStage);
						    		
						      }
						    });

		            } else if(voiceCommand.equalsIgnoreCase("Transcriber")) {
		            	System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
		            	active=false;
		            	Platform.runLater(new Runnable()
					    {
					    	@Override
					      public void run()
					      {    
					    		initAgainMenuTranscriber(primaryStage);
					      }
					    });
		                
		            } else if(voiceCommand.equalsIgnoreCase("Assistant")) {
		            	System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
		            	active=true;
		            	Platform.runLater(new Runnable()
					    {
					    	@Override
					      public void run()
					      {    
					    		initAgainMenuAssistant(primaryStage);
					      }
					    });

		            } else if(voiceCommand.equalsIgnoreCase("Speaker")) {
		            	System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
		            	active=true;
		            	Platform.runLater(new Runnable()
					    {
					    	@Override
					      public void run()
					      {    
					    		initAgainMenuSpeaker(primaryStage);
					      }
					    });


		            } else if(voiceCommand.equalsIgnoreCase("Aligner")) {
		            	System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
		            	active=false;
		            	Platform.runLater(new Runnable()
					    {
					    	@Override
					      public void run()
					      {    
					    		initAgainMenuAligner(primaryStage);
					      }
					    });
		            	
		            } else if(voiceCommand.equalsIgnoreCase("Back")) {
		            	System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
		            	active=false;
		            	Platform.runLater(new Runnable()
					    {
					    	@Override
					      public void run()
					      {    
					    		initAgainMenuStart(primaryStage);
					      }
					    });
		                
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
		            

		            
		            if(active==true) {
		            	
		            //TranscriberDemo
					if (voiceCommand.equalsIgnoreCase("Transcriber")) {
						System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");

						TranscriberDemo.main(null);

					//AssistantDemo
					} else if (voiceCommand.equalsIgnoreCase("Assistant")) {
						System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");

						AssistantDemo.main(null);
					
					//SpeakerIdDemo	
					} else if (voiceCommand.equalsIgnoreCase("Speaker")) {
						System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");

						SpeakerIdentificationDemo.main(null);

					//AlignerDemo
					} else if (voiceCommand.equalsIgnoreCase("Aligner")) {
						System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
						active=false;
						AlignerDemo.main(null);
						
					} else if(voiceCommand.equalsIgnoreCase("Back")) {
		            	System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
						active=false;
		            	Platform.runLater(new Runnable()
					    {
					    	@Override
					      public void run()
					      {    
					    		initAgainMenuDemos(primaryStage);
					      }
					    });
						
						}
					
		            }	
		            
		        }
		        
		  	}

public static void main(String[] args) {
    launch(args);
}
}
