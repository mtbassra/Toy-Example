package ch.be.mtbassra.chatClasses.chatMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ch.be.mtbassra.abstractClasses.Model;
import ch.be.mtbassra.chatClasses.User;
import ch.be.mtbassra.chatClasses.chatLogin.ChatLogin_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.stage.Stage;

public class ChatMain_Model extends Model {


	private ArrayList<ChatMain_View> mainViews = new ArrayList<ChatMain_View>();
	
	private static ArrayList<User> users = new ArrayList<User>();
	
	ServiceLocator serviceLocator;

	
	
	public ChatMain_Model() {
		super();
		
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Model Initialized");
	}

	
	public ArrayList<ChatMain_View> getMainView() {
		
		return mainViews;
	}



	public void setMainViews(ChatMain_View mView) {
		
		mainViews.add(mView);
	}

	public void setUser(User user) {
		
		users.add(user);
	}
	public ArrayList<User> getUsers() {
		
		return users;
	}

}
