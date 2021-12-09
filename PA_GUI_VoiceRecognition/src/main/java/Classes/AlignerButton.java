package Classes;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import edu.cmu.sphinx.alignment.LongTextAligner;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechAligner;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;


/**
 * This class demonstrates how to align audio to existing transcription and
 * receive word timestamps.
 * <br>
 * In order to initialize the aligner you need to specify several data files
 * which might be available on the CMUSphinx website. There should be an
 * acoustic model for your language, a dictionary, an optional G2P model to
 * convert word strings to pronunciation. 
 * <br>
 * Currently the audio must have specific format (16khz, 16bit, mono), but in
 * the future other formats will be supported. 
 * <br>
 * Text should be a clean text in lower case. It should be cleaned from
 * punctuation marks, numbers and other non-speakable things. In the future
 * automatic cleanup will be supported.
 */
public class AlignerButton  {

public void initAlignerButton() throws Exception {
		
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
		System.out.println("               AlignerButton Menu                   ");
		System.out.println("_____________________________________________________________ ");
		System.out.println("                                                              ");
		System.out.println("               Option 1: Aligner                    ");
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
			if (voiceCommand.equalsIgnoreCase("Aligner")) {
				System.out.println("                                                              ");
				System.out.println("Voice Command is " + voiceCommand);
				System.out.println("                                                              ");
				System.out.println("you have selected the option 1: Aligner");
				AlignerDemo.main(null);
			
			
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


					AlignerButton ab = new AlignerButton();
					try {
						ab.initAlignerButton();
					} catch (Exception e) {
						e.printStackTrace(); 

					
					}
				
				}
}
