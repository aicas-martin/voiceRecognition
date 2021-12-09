package Classes;


import java.net.URL;
import java.util.ArrayList;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.decoder.adaptation.Stats;
import edu.cmu.sphinx.decoder.adaptation.Transform;
import edu.cmu.sphinx.speakerid.Segment;
import edu.cmu.sphinx.speakerid.SpeakerCluster;
import edu.cmu.sphinx.speakerid.SpeakerIdentification;
import edu.cmu.sphinx.util.TimeFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SpeakerIdentificationButton  {

public void InitSpeakerIdentificationButton() throws Exception {
		
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
		System.out.println("               SpeakerIDButton Menu                   ");
		System.out.println("_____________________________________________________________ ");
		System.out.println("                                                              ");
		System.out.println("               Option 1: Speaker                     ");
		System.out.println("               Option 2: Back                                 ");
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
			if (voiceCommand.equalsIgnoreCase("Speaker")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 1: Speaker");
				SpeakerIdentificationDemo.main(null);
			
				
			//Back to the main Memu
			} else if (voiceCommand.equalsIgnoreCase("Back")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
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


					SpeakerIdentificationButton sb = new SpeakerIdentificationButton();
					try {
						sb.InitSpeakerIdentificationButton();
					} catch (Exception e) {
						e.printStackTrace(); 

					
					}
				
				}
}
 