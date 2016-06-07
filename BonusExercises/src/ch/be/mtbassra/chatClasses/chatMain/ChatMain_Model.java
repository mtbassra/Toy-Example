package ch.be.mtbassra.chatClasses.chatMain;

import java.util.ArrayList;
import java.util.Scanner;
import ch.be.mtbassra.abstractClasses.Model;
import ch.be.mtbassra.chatClasses.ChatMessage;
import ch.be.mtbassra.chatClasses.Client;
import ch.be.mtbassra.commonClasses.ServiceLocator;

public class ChatMain_Model extends Model {

	Client client;

	private ArrayList<ChatMain_View> mainViews = new ArrayList<ChatMain_View>();
	
	private static ArrayList<Client> clients = new ArrayList<Client>();
	
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

	public void setUser(Client client) {
		
		clients.add(client);
	}
	public ArrayList<Client> getClient() {
		
		return clients;
	}

	public void startClient() {
		
		// create the Client object
		Client client = clients.get(0);
		// test if we can start the connection to the Server
		// if it failed nothing we can do
		if(!client.start())
			return;
		
		// wait for messages from user
		Scanner scan = new Scanner(System.in);
		// loop forever for message from the user
		while(true) {
			System.out.print("> ");
			// read message from user
			String msg = scan.nextLine();
			// logout if message is LOGOUT
			if(msg.equalsIgnoreCase("LOGOUT")) {
				client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
				// break to do the disconnect
				break;
			}
			// message WhoIsIn
			else if(msg.equalsIgnoreCase("WHOISIN")) {
				client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));				
			}
			else {				// default to ordinary message
				client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg));
			}
		}
		// done disconnect
		client.disconnect();	
	}
	
	


}
