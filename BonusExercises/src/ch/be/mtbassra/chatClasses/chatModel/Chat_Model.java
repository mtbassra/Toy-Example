package ch.be.mtbassra.chatClasses.chatModel;

import ch.be.mtbassra.abstractClasses.Model;
import ch.be.mtbassra.chatClasses.Chat;
import ch.be.mtbassra.commonClasses.ServiceLocator;

public class Chat_Model extends Model {
	ServiceLocator serviceLocator;
	
	public Chat_Model() {
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Model Initialized");
	}
	
	

}
