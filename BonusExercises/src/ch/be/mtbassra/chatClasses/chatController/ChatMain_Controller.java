package ch.be.mtbassra.chatClasses.chatController;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.chatModel.Chat_Model;
import ch.be.mtbassra.chatClasses.chatView.ChatLogin_View;
import ch.be.mtbassra.chatClasses.chatView.ChatMain_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ChatMain_Controller extends Controller<Chat_Model, ChatMain_View> {
	
	ServiceLocator serviceLocator;
	
	ChatLogin_View loginView;
	
	
	public ChatMain_Controller(Chat_Model model, ChatMain_View view) {
		super(model, view);
		
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Main Controller Initialized");
	}
	
	



}
