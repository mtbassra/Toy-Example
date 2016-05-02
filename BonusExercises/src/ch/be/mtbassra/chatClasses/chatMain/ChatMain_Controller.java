package ch.be.mtbassra.chatClasses.chatMain;

import java.util.ArrayList;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.User;
import ch.be.mtbassra.chatClasses.chatLogin.ChatLogin_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;

public class ChatMain_Controller extends Controller<ChatMain_Model, ChatMain_View> {
	
	ServiceLocator serviceLocator;
	ChatMain_View mView;
	
	public ChatMain_Controller(ChatMain_Model model, ChatMain_View view) {
		super(model, view);
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Main Controller Initialized");
		
		registerUser();
	}

	public void registerUser() {
		
		String onlineUsers;
		for (User users : model.getUsers()) {
			onlineUsers = users.getUserName();			
		for (ChatMain_View mainViews : model.getMainView()) {
			mainViews.getTxtCurrentOnline().setText(onlineUsers);
		}
		}
		
		String userName = model.getUsers().get(0).getUserName();
		model.getMainView().get(0).getTxtLoggedAs().setText(userName);
		System.out.println(userName);

		}



}
