package ch.be.mtbassra.chatClasses.chatLogin;

import java.io.IOException;

import ch.be.mtbassra.abstractClasses.Model;
import ch.be.mtbassra.chatClasses.ChatAccess;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_Model;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.stage.Stage;

public class ChatLogin_Model extends Model {
	
	ServiceLocator serviceLocator;	
	ChatLogin_View lView;
	ChatMain_View mView;
	
	public ChatLogin_Model() {
		super();
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Login Model Initialized");
	}
	
	public void startMainView() {
		
		Stage stage = new Stage();
		ChatMain_Model mModel = new ChatMain_Model();
		
		mView = new ChatMain_View(stage, mModel);
		mModel.getMainViews().add(mView);
		mView.start();
		
		serviceLocator.getLogger().info("Chat Main View Started");
				
	}

}
