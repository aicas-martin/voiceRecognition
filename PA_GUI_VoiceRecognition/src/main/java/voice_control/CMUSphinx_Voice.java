package voice_control;

import java.io.IOException;

import Classes.AlignerDemo;
import Classes.AssistantButton;
import Classes.SpeakerIdentificationDemo;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.stage.Stage;


/**
 * @author luis
 */


public class CMUSphinx_Voice   {
	
	  	private LiveSpeechRecognizer recognizer;
	    
	  	boolean active = false;
	     
	  	public void InitDemo() throws Exception {
		        
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
			System.out.println("  'Sleep'- This command allows entering the sleep modus, pausing all voice recognition in real time                             ");
			System.out.println("  'Exit'- Through this command the navigation process is canceled and the program is exited.                              ");
			System.out.println("                                                              ");
			System.out.println("_______________________________________________________________________________________________");
		
 
		    
			try {
	            recognizer = new LiveSpeechRecognizer(configuration);
	        } catch (IOException e) {
	            System.out.println(e);
	        }
	         
	        //Start speech recognition 
			GUImenuDemos();
	        
    }
	    
	  	public void GUImenuDemos() throws Exception {
	        
	  		
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
	                
	            	GUI_Demos gui = new GUI_Demos();
	            	gui.main(null);

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
					System.exit(0);

	            }
	            

	            
	            if(active==true) {
	            	
	            //TranscriberDemo
				if (voiceCommand.equalsIgnoreCase("Transcriber")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					System.out.println("you have selected the option Transcriber");
					//TranscriberDemo.main(null);
					
					MenuTranscriber mt = new MenuTranscriber();
					mt.main(null);
					
		
				
				
				//AssistantDemo
				} else if (voiceCommand.equalsIgnoreCase("Assistant")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					System.out.println("you have selected the option Assistant");
					AssistantButton.main(null);
				
				//SpeakerIdDemo	
				} else if (voiceCommand.equalsIgnoreCase("Speaker")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					System.out.println("you have selected the option SpeakerId");
					SpeakerIdentificationDemo.main(null);

				//AlignerDemo
				} else if (voiceCommand.equalsIgnoreCase("Aligner")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					System.out.println("you have selected the option Aligner");
					AlignerDemo.main(null);
					
				//Exit the programm
				} else if (voiceCommand.equalsIgnoreCase("exit")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					System.out.println("you have selected the option Exit..                        ");
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

		public static void main(String[] args)  {
			
			CMUSphinx_Voice v = new CMUSphinx_Voice();
			try {
				v.InitDemo();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
