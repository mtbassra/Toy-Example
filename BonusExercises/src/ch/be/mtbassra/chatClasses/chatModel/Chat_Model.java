package ch.be.mtbassra.chatClasses.chatModel;

import ch.be.mtbassra.abstractClasses.Model;
import ch.be.mtbassra.chatClasses.chatView.ChatLogin_View;
import ch.be.mtbassra.chatClasses.chatView.ChatMain_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.stage.Stage;

public class Chat_Model extends Model {
	ServiceLocator serviceLocator;
	ChatLogin_View loginView;
	ChatMain_View mainView;
	
	public Chat_Model() {
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Model Initialized");
	}
	
	public void startMainView() {
		
		Stage stage = new Stage();
		Chat_Model model = new Chat_Model();
		
		mainView = new ChatMain_View(stage, model);
		mainView.start();
		
		serviceLocator.getLogger().info("Chat is started");
				
	}
	
}
