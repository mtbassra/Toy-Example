package ch.be.mtbassra.chatClasses.chatLogin;

import java.io.IOException;
import java.util.ArrayList;
import ch.be.mtbassra.abstractClasses.Model;
import ch.be.mtbassra.chatClasses.ChatAccess;
import ch.be.mtbassra.chatClasses.User;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_Controller;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_Model;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.stage.Stage;

public class ChatLogin_Model extends Model {
	
	ServiceLocator serviceLocator;	
	ChatLogin_View lView;
	ChatMain_View mView;
	ChatMain_Controller mController;
	

	
	public ChatLogin_Model() {
		super();
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Login Model Initialized");
	}
	
	public void startMainView() {
		
		Stage stage = new Stage();
		
		ChatMain_Model mModel = new ChatMain_Model();
		
		mView = new ChatMain_View(stage, mModel);
		
		mModel.getMainView().add(mView);
		mView.start();
		mController = new ChatMain_Controller(mModel, mView);
		
		serviceLocator.getLogger().info("Chat Main View Started");
				
	}

}
