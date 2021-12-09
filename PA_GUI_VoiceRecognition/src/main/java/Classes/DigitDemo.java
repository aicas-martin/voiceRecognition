package Classes;


import java.io.IOException;


import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;


public class DigitDemo  {

private LiveSpeechRecognizer recognizer;	
	
boolean active = false;	

public void InitDialog() throws Exception {
    
    //Configuration Object
    Configuration configuration = new Configuration();
	 
    // Set path to the acoustic model.
    configuration.setAcousticModelPath("resources/edu/cmu/sphinx/models/en-us/en-us");
    // Set path to the language model (vocabulary model).
    configuration.setDictionaryPath("resources/assistant/2729.dic");
    configuration.setLanguageModelPath("resources/assistant/2729.lm");

		
				
				System.out.println("_____________________________________________________________ ");
				System.out.println("                                                              ");
				System.out.println("               Assistant Demo Menu                            ");
				System.out.println("_____________________________________________________________ ");
				System.out.println("                                                              ");
				System.out.println("           (to activate the Assistant Demo)                   ");
				System.out.println("       Say the Initial greeting: 'Hello Assistant'            ");
				System.out.println("_____________________________________________________________ ");
				System.out.println("                                                              ");
				System.out.println("                 (voice command list)                         ");
				System.out.println("                                                              ");
				System.out.println("               Say: Open/Close Browser                        ");
				System.out.println("               Say: Open/Close Teams                          ");
				System.out.println("               Say: Open/Close Thunderbird                    ");
				System.out.println("               Say: Open/Close Terminal                       ");
				System.out.println("               Say: Back /(back to the main menu) 			  ");
				System.out.println("_____________________________________________________________ ");
				System.out.println("                                                              ");
				System.out.println("           Pls choose one of the options by voice:              ");
				System.out.println("                                                              ");
				System.out.println("_____________________________________________________________ ");
				System.out.println("                                                              ");
 
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
		            	System.out.println("_____________________________________________________________ ");
						System.out.println("                                                              ");
						System.out.println("               Dialog Assistant Menu                          ");
						System.out.println("_____________________________________________________________ ");
						System.out.println("                                                              ");
						System.out.println("               Say: Open/Close Browser                        ");
						System.out.println("               Say: Open/Close Teams                          ");
						System.out.println("               Say: Open/Close Thunderbird                    ");
						System.out.println("               Say: Open/Close Terminal                       ");
						System.out.println("               Say: Back /(back to the main menu) 			  ");
						System.out.println("_____________________________________________________________ ");
						System.out.println("                                                              ");
						System.out.print("           Pls choose one of the options by voice:              ");
						System.out.println("                                                              ");
						System.out.println("_____________________________________________________________ ");
						System.out.println("                                                              ");
		            	
		            } else if(voiceCommand.equalsIgnoreCase("Back")) {
		            	System.out.println("                                                              ");
						System.out.println("Voice Command is " + voiceCommand);
						System.out.println("                                                              ");
						active=false;
						System.out.println("                                                              ");
						System.out.println("Thanks for using the Assistant Demo, now you will return to the main menu.");
						System.out.println("                                                              ");
						System.out.println("_____________________________________________________________ ");
						break;

		            }
				
		       
		        if(active==true) {    
		            
				//Open Browser
				if (voiceCommand.equalsIgnoreCase("open browser")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("firefox www.google.com");
					System.out.println("The Browser is Opened..");
				} else if (voiceCommand.equalsIgnoreCase("close browser")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("pkill firefox");
					System.out.println("The Browser is Closed");
				}   		
				
				//Open MSTeams
				if (voiceCommand.equalsIgnoreCase("open teams")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("teams");
					System.out.println("MSTeams is Opened..");
				} else if (voiceCommand.equalsIgnoreCase("close teams")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("pkill teams");
					System.out.println("MSTeams is Closed");
				}
				
				//Open Thunderbird
				if (voiceCommand.equalsIgnoreCase("open thunderbird")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("thunderbird");
					System.out.println("Your thunderbird is ready..");
				} else if (voiceCommand.equalsIgnoreCase("Close thunderbird")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("pkill thunderbird");
					System.out.println("Your thunderbird is Closed");
				}
				
				//Open Terminal
				if (voiceCommand.equalsIgnoreCase("open terminal")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("gnome-terminal");
					System.out.println("The Terminal is Opened..");
				} else if (voiceCommand.equalsIgnoreCase("close terminal")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					Runtime.getRuntime().exec("pkill gnome-terminal");
					System.out.println("The Terminal is Closed");
					
				//Back to the main menu	
				} else if (voiceCommand.equalsIgnoreCase("back")) {
					System.out.println("                                                              ");
					System.out.println("Voice Command is " + voiceCommand);
					System.out.println("                                                              ");
					System.out.println("Thanks for using the Assistant Demo, now you will return to the main menu.");
					break;
					
				}
		      }
		  	}
		  }
					
				public static void main(String[] args) throws Exception {
					
					DigitDemo dd = new DigitDemo();
					dd.InitDialog();
				}
							
			}