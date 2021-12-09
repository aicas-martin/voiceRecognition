package Main;


import java.util.Scanner;

import Classes.AlignerButton;
import Classes.AssistantButton;
import Classes.SpeakerIdentificationButton;
import Classes.TranscriberButton;

/**
 * @author luis
 */


public class CMUSphinx_Keyboard_Example {
	

	public static void main(String[] args) throws Exception {
    	
		//Demos Classes
		TranscriberButton transcriber = new TranscriberButton();
    	AssistantButton assistant = new AssistantButton();
    	SpeakerIdentificationButton speakerid = new SpeakerIdentificationButton();
    	AlignerButton aligner = new AlignerButton();
    	
		
    	//Demos Menu
    	Scanner sc = new Scanner (System.in);
    	boolean exit = false;
    	int option; // save the user option

    	while (!exit) {
    		
    		System.out.println("********************** Voice Recognition Demos Menu **********************");
    		
    		System.out.println("Option '1': Transcriber Demo");
    		System.out.println("Option '2': Assistant Demo");
    		System.out.println("Option '3': SpeakerID Demo");
    		System.out.println("Option '4': Aligner Demo");
    		System.out.println("Option '5': Exit");
    			
    		System.out.print("Pls choose one of the options by keyboard: ");
    		option = sc.nextInt();
    		
    		switch (option){
        		
        		case 1: 
        			transcriber.main(args);
        			System.out.println("you have selected the option 1: Transcriber Demo");
        			break;
        		case 2:
        			assistant.main(args);
        			System.out.println("you have selected the option 2: Assistant Demo");
        			break;
        		case 3:
        			speakerid.main(args);
        			System.out.println("you have selected the option 3: SpeakerID Demo");
        			break;
        		case 4:
        			aligner.main(args);
        			System.out.println("you have selected the option 4: Aligner Demo");
        			break;
        		case 5:
        			System.out.println("you have selected the option 5: Exit. Thanks for using this program, bye!");
        			exit = true;
        			break;
        		default:
                    System.out.println("Only numbers between 1 and 5");
        
    	   }     
    	}        
	 }	     
  }               
