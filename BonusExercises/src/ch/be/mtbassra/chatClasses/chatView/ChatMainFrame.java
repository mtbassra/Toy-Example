package ch.be.mtbassra.chatClasses.chatView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ChatMainFrame extends BorderPane {
	
	private String userName;
	
	private GridPane root;
	private Label lblLoggedAs;
	private TextField txtLoggedAs;
	private Button btnDisconnect;
	private Label lblConversation;
	private TextField txtConversation;
	private Label lblMessage;
	private TextField txtMessage;
	private Button btnSend;
	private Label lblCurrentOnline;
	private TextField txtCurrentOnline;
	
	protected ChatMainFrame() {
		super();
		
		root = new GridPane();
		
		lblLoggedAs = new Label(" Logged As: ");
		txtLoggedAs = new TextField();
		btnDisconnect = new Button(" Disconnect ");
		lblConversation = new Label(" Conversation: ");
		txtConversation = new TextField();
		lblMessage = new Label("Write Message: ");
		txtMessage = new TextField();
		btnSend = new Button(" Send ");
		lblCurrentOnline = new Label(" Currently Online: ");
		txtCurrentOnline = new TextField();
		
		root.add(lblLoggedAs, 0, 1);
		root.add(txtLoggedAs, 1, 0);
	
		
		
	}
	
	

}
