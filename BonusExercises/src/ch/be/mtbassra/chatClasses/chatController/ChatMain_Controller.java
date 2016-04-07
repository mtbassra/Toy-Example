package ch.be.mtbassra.chatClasses.chatController;

import java.io.IOException;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.chatModel.ChatAccess;
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
		
		// register to listen for button Start Play
		loginView.getBtnJoin().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				btnJoinAction();

			}

		});
		
		serviceLocator = ServiceLocator.getServiceLocator();
		serviceLocator.getLogger().info("Chat Main Controller Initialized");
	}
	
	public void btnJoinAction() {

		// try {
		// String userName = view.getTxtUserName().getText();
		// for (String oldUser : model.getUsers()) {
		// if (oldUser.equalsIgnoreCase(userName)) {
		// System.out.println("User name: " + userName + " already exists");
		// return;
		// }
		// }

		String server = loginView.getTxtServerAddress().getText();
		int port = Integer.parseInt(loginView.getTxtPortAddress().getText());

		System.out.println("Server: " + server + ":" + port);

		ChatAccess access = null;
		try {
			access = new ChatAccess(server, port);
		} catch (IOException ex) {

		}

		model.startMainView();
		loginView.stop();
	}
	
	



}
