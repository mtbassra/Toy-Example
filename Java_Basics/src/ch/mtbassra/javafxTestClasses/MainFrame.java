package ch.mtbassra.javafxTestClasses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This is a test fxtestclass
 * @author mtbas
 *
 */
public class MainFrame extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
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
    

	@Override
	public void start(Stage primaryStage) {
		

		primaryStage.setTitle("LoginFrame");
		primaryStage.setScene(creat_GUI());
		primaryStage.show();
	}
	
	private Scene creat_GUI() {
    	
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
		
		root.add(lblLoggedAs, 1, 1);
		root.add(txtLoggedAs, 2, 1);
		root.add(btnDisconnect, 2, 2);
		root.add(lblConversation, 1, 3);
		root.add(txtConversation, 2, 3);
		root.add(lblMessage, 1, 4);
		root.add(txtMessage, 2, 4);
		root.add(btnSend, 2, 5);
		root.add(lblCurrentOnline, 4, 1);
		root.add(txtCurrentOnline, 4, 2);
		

		BorderPane mainPane = new BorderPane();

		mainPane.setCenter(root);
		
		Scene scene = new Scene(mainPane, 500, 500);
		
		return scene;
		

		
	}
}