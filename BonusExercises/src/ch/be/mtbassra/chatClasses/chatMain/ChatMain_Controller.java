package ch.be.mtbassra.chatClasses.chatMain;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.User;
import ch.be.mtbassra.chatClasses.chatLogin.ChatLogin_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;

public class ChatMain_Controller extends Controller<ChatMain_Model, ChatMain_View> {
	
	User user;
	ServiceLocator serviceLocator;	
	
	public ChatMain_Controller(ChatMain_Model model, ChatMain_View view) {
		super(model, view);
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Main Controller Initialized");
		
		
		
		registerUser();
	}

	public void registerUser() {
		
		
		view.getTxtCurrentOnline().setText(user.getUserName());
	}


}
