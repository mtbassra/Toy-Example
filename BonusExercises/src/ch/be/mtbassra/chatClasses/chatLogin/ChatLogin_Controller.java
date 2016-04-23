package ch.be.mtbassra.chatClasses.chatLogin;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import ch.be.mtbassra.Chat;
import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.ChatAccess;
import ch.be.mtbassra.chatClasses.User;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_Model;
import ch.be.mtbassra.chatClasses.chatMain.ChatMain_View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ChatLogin_Controller extends Controller<ChatLogin_Model, ChatLogin_View> {
	
	User user;

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
				
//		String userName = view.getTxtUserName().getText();
//		for(String oldUser: mModel.getUsers()) {
//			if (oldUser.equalsIgnoreCase(userName)) {
//				System.out.println("User Exists");
//			}
//			
//		}
//		user.setUserName(userName);
//		
//		ClientStart.serverIp = InetAddress.getByName(initialView.TxtServerAddress.getText());
//		try {
//			user.setServer(InetAddress.getByName(view.getTxtServerAddress().getText()));
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int port = Integer.parseInt(view.getTxtPortAddress().getText());
//		
//		user.setUserName(userName);
//		user.setServer(server);
//		user.setPort(port);
//		
//		System.out.println("User: " + userName + ": " + "Server: " + server + ": " + port);
//
//		ChatAccess access = null;
//		try {
//			access = new ChatAccess(server, port);
//		} catch (IOException ex) {
//			System.out.println("Cannot Connect To Server");
//		}
		
		model.startMainView();
		
		view.stop();
	}

}
