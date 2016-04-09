package ch.be.mtbassra.chatClasses.chatMain;

import ch.be.mtbassra.abstractClasses.Model;
import ch.be.mtbassra.chatClasses.chatLogin.ChatLogin_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.stage.Stage;

public class ChatMain_Model extends Model {
	ServiceLocator serviceLocator;
	ChatLogin_View loginView;
	ChatMain_View mainView;
	
	public ChatMain_Model() {
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Model Initialized");
	}
	



}
