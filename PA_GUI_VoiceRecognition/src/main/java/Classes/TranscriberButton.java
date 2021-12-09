package Classes;

import java.io.IOException;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A simple example that shows how to transcribe a continuous audio file that
 * has multiple utterances in it.
 */
public class TranscriberButton  {


	public void InitTranscriberButton() throws Exception {
		
		//Configuration Object
	    Configuration configuration = new Configuration();
		 
	    // Set path to the acoustic model.
	    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
	    // Set path to the language model (vocabulary model).
	    configuration.setDictionaryPath("resources/assistant/2729.dic");
	    configuration.setLanguageModelPath("resources/assistant/2729.lm");
	    
	    // RealTime Speech Recognition with the LiveSpeechRecognizer Class
        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
     

        recognizer.startRecognition(true);
        
        System.out.println("_____________________________________________________________ ");
		System.out.println("                                                              ");
		System.out.println("               TranscriberButton Menu                   ");
		System.out.println("_____________________________________________________________ ");
		System.out.println("                                                              ");
		System.out.println("               Option 1: Transcriber                     ");
		System.out.println("               Option 2: Rec                       ");
		System.out.println("               Option 3: Back                                 ");
		System.out.println("                                                              ");
		System.out.println("_____________________________________________________________ ");
		System.out.println("                                                              ");
		System.out.println("           Pls choose one of the options by voice:            ");
		System.out.println("                                                              ");
		System.out.println("_____________________________________________________________ ");
		System.out.println("                                                              ");
		
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognizer.getResult()) != null) {
        	
            //Get the recognized speech
            String voiceCommand = result.getHypothesis();
            
            //System.out.println(result.getHypothesis());
            
            
            if(true) {
            	
            	
            	
            //TranscriberDemo
			if (voiceCommand.equalsIgnoreCase("Transcriber")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 1: Transcriber");
				TranscriberDemo.main(null);
			
			//AssistantDemo
			} else if (voiceCommand.equalsIgnoreCase("Rec")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 2: Rec");
				RecDemo.main(null);
			
			
			//Go to the main Menu
			} else if (voiceCommand.equalsIgnoreCase("Back")) {
				System.out.println("                                                              ");
				
				System.out.println("Thanks for using the TranscriberMenu.");
				System.out.println("                                                              ");
				System.out.println("_____________________________________________________________ ");
				break;
				}
			
            }	
            
        }
        
  	}

				
				public static void main(String[] args) {


					TranscriberButton tb = new TranscriberButton();
					try {
						tb.InitTranscriberButton();
					} catch (Exception e) {
						e.printStackTrace(); 

					
					}
				
				}
}