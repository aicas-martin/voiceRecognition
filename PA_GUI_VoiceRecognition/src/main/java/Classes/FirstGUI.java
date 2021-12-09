package Classes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstGUI extends Application {

Scene scene1, scene2, scene3, scene4, scene5;
Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, btnExit;

	@Override
	public void start(Stage primaryStage) {
	
		
		
	primaryStage.setTitle("GUI Voice Recognition Main Menu");
	
	Stage Window = new Stage();
	
	//Scene 1 - Main Menu ---------------------
	Label label1= new Label("Main Menu");
	Button button1= new Button("Transcriber");
	Button button2= new Button("Assistant");
	Button button3= new Button("SpeakerId");
	Button button4= new Button("Aligner");
	Button btnExit = new Button("Exit");
	
	button1.setOnAction(e -> primaryStage.setScene(scene2));
	
	button2.setOnAction(e -> primaryStage.setScene(scene3));
	
	button3.setOnAction(e -> primaryStage.setScene(scene4));
	
	button4.setOnAction(e -> primaryStage.setScene(scene5));
	
	
	VBox layout1 = new VBox(20);     
	layout1.getChildren().addAll(label1, button1, button2, button3, button4, btnExit );
	layout1.setAlignment(Pos.BASELINE_CENTER);
	scene1= new Scene(layout1, 300, 250);
               
	//Scene 2 - TranscriberButton ------------------------
	Label label2= new Label("TranscriberDemo Menu");
	
	//TranscriberDemo
	Button button5= new Button("TranscriberDemo");
	button5.setOnAction(e -> {
		if (! Window.isShowing()) {
			button5.setOnAction(evn -> Window.setScene(scene2));
		try {
			TranscriberDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//RecDemo
	Button button6= new Button("RecDemo");
	button6.setOnAction(e -> {
		if (! Window.isShowing()) {
			button6.setOnAction(evn -> Window.setScene(scene2));
		try {
			RecDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
	Button button7= new Button("Back");
	button7.setOnAction(e -> primaryStage.setScene(scene1));
	
	VBox layout2= new VBox(20);
	layout2.getChildren().addAll(label2, button5, button6, button7 );
	layout2.setAlignment(Pos.BASELINE_CENTER);
	scene2= new Scene(layout2,300,250);

	//Scene 3 - AssistantButton ------------------------
	Label label3= new Label("AssistantButton");
	
	//DigitDemo
	Button button8= new Button("DigitDemo");
	button8.setOnAction(e -> {
		if (! Window.isShowing()) {
			button8.setOnAction(evn -> Window.setScene(scene3));
		try {
			TranscriberDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	
	Button button9= new Button("DialogDemo");
	button9.setOnAction(e -> {
		if (! Window.isShowing()) {
			button9.setOnAction(evn -> Window.setScene(scene3));
		try {
			RecDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	Button button10= new Button("BankDemo");
	button10.setOnAction(e -> {
		if (! Window.isShowing()) {
			button10.setOnAction(evn -> Window.setScene(scene3));
		try {
			RecDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
	Button button11= new Button("Back");
	button11.setOnAction(e -> primaryStage.setScene(scene1));
	VBox layout3= new VBox(20);
	layout3.getChildren().addAll(label3, button8, button9, button10, button11);
	layout3.setAlignment(Pos.BASELINE_CENTER);
	scene3= new Scene(layout3,300,250);

	//Scene 4 - SpeakerIdButton
	Label label4= new Label("SpeakerIdButton");
	
	//SpeakerIdDemo
	Button button12= new Button("SpeakerId");
	button12.setOnAction(e -> {
		if (! Window.isShowing()) {
			button10.setOnAction(evn -> Window.setScene(scene4));
		try {
			SpeakerIdentificationDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
	Button button13= new Button("Back");
	button13.setOnAction(e -> primaryStage.setScene(scene1));
	VBox layout4= new VBox(20);
	layout4.getChildren().addAll(label4, button12, button13);
	layout4.setAlignment(Pos.BASELINE_CENTER);
	scene4= new Scene(layout4,300,250);

	//Scene 5 - AlignerButton
	Label label5= new Label("AlignerButton");

	//AlignerDemo
	Button button14= new Button("AlignerDemo");
	button14.setOnAction(e -> {
		if (! Window.isShowing()) {
			button14.setOnAction(evn -> Window.setScene(scene5));
		try {
			AlignerDemo.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
	});
	
	//Back to the main menu
	Button button15= new Button("Back");
	button15.setOnAction(e -> primaryStage.setScene(scene1));
	VBox layout5= new VBox(20);
	layout5.getChildren().addAll(label5, button14, button15);
	layout5.setAlignment(Pos.BASELINE_CENTER);
	scene5= new Scene(layout5,300,250);
 

		//Exit Button action handler
		btnExit.setOnAction(e -> {
			if (! Window.isShowing()) {
			btnExit.setOnAction(evn -> Window.setScene(scene1));		
			System.exit(0);

		}
	});
		
	primaryStage.setScene(scene1);
	
	primaryStage.show();
	}
	
public static void main(String[] args) {
	launch(args);
	}
	    
}
