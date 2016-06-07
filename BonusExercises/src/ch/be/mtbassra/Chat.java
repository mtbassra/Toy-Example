package ch.be.mtbassra;

import ch.be.mtbassra.chatClasses.chatLogin.ChatLogin_Controller;
import ch.be.mtbassra.chatClasses.chatLogin.ChatLogin_Model;
import ch.be.mtbassra.chatClasses.chatLogin.ChatLogin_View;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import ch.be.mtbassra.splashScreen.Splash_Controller;
import ch.be.mtbassra.splashScreen.Splash_Model;
import ch.be.mtbassra.splashScreen.Splash_View;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Chat extends Application {
	
	private static Chat mainProgram; // singleton
	private Splash_View splashView;
	private ChatLogin_Model loginModel;
	private ChatLogin_View loginView;
	private ChatMain_View mainView;
	
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
		
		//Resources are now initialized
		serviceLocator = ServiceLocator.getServiceLocator();
		
		//Display the splash screen and begin the initialization
		splashModel.initialize();
		
	}
	
	public void startLoginView() {
		
		Stage loginStage = new Stage();
		
		loginModel = new ChatLogin_Model();
		
		loginView = new ChatLogin_View(loginStage, loginModel);
		
		new ChatLogin_Controller(loginModel, loginView);
		
		splashView.stop();
		splashView = null;
		loginView.start();
		
	}
	
	@Override	
	public void stop(){
		serviceLocator.getConfiguration().save();
		
		if (loginView != null && mainView  != null)  {
			//Make the view invisible
			loginView.stop();
			mainView.stop();
		}
		
		serviceLocator.getLogger().info("Application is Terminated");
	}
	
	protected static Chat getMainProgram() {
		return mainProgram;
	}

}
