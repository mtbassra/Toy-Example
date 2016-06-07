package ch.be.mtbassra.chatClasses.chatLogin;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.Client;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_Controller;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_Model;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ChatLogin_Controller extends Controller<ChatLogin_Model, ChatLogin_View> {
	
	Client client;
	
	ChatMain_Model mModel = new ChatMain_Model();
	ChatMain_Controller mController;
	ChatMain_View mView;

	ServiceLocator serviceLocator;
	
	public ChatLogin_Controller(ChatLogin_Model model, ChatLogin_View view) {
		super(model, view);

		// register to listen for button Start Play
		view.getBtnJoin().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				btnJoinAction();

			}

		});

		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Login Controller Initialized");
	}

	public void btnJoinAction() {
						
		String userName = view.getTxtUserName().getText();
		for(Client oldUser: mModel.getClient()) {
			if (oldUser.getUserName().equalsIgnoreCase(client.getUserName())) {
				System.out.println("User Exists");
			}
			
		}
		Client client = new Client();
		
		client.setUserName(userName);
		
		client.setServer(view.getTxtServerAddress().getText());
		
		int port = Integer.parseInt(view.getTxtPortAddress().getText());	
		client.setPort(port);
		

		mModel.setUser(client);
		model.startMainView();
		view.stop();
	

	}

}
