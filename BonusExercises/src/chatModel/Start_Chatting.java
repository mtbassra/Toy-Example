package chatModel;

import chatView.Chat_View;
import commonClasses.ServiceLocator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import splashScreen.Splash_Controller;
import splashScreen.Splash_Model;
import splashScreen.Splash_View;

public class Start_Chatting extends Application {
	private static Start_Chatting mainProgram; // singleton
	private Splash_View splashView;
	private Chat_View view;
	
	private ServiceLocator serviceLocator; //resources, after initialization
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		if (mainProgram == null) {
			mainProgram = this;
		} else {
			Platform.exit();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Create and display the splash screen and model
		Splash_Model splashModel = new Splash_Model();
		splashView = new Splash_View(primaryStage, splashModel);
		new Splash_Controller(this, splashModel, splashView);
		splashView.start();
		
		//Display the splash screen and begin the initialization
		splashModel.initialize();
		
	}

	public void startApp() {
		System.out.println("Chat is started! ");
		
	}
	
	protected static Start_Chatting getMainProgram() {
		return mainProgram;
	}



}
