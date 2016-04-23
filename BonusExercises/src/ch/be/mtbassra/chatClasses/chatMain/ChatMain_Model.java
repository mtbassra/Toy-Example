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
	
	private User user;
	private static Set<User> users = new TreeSet<User>();
	private List<ChatMain_View> mainViews = new ArrayList<ChatMain_View>();
	
	
	
	
	ServiceLocator serviceLocator;
	ChatMain_View mainView;
	
	
	public ChatMain_Model() {
		
		setMainViews(new ArrayList<ChatMain_View>());
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Model Initialized");
	}
	
	public void registerUser(){
		users.add(user);
		
		
	}
	
	public List<ChatMain_View> getMainViews() {
		return mainViews;
	}



	public void setMainViews(List<ChatMain_View> mainViews) {
		this.mainViews = mainViews;
	}



}
