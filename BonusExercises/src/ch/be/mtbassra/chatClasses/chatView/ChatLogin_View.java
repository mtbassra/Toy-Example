package ch.be.mtbassra.chatClasses.chatView;

import ch.be.mtbassra.abstractClasses.View;
import ch.be.mtbassra.chatClasses.Chat;
import ch.be.mtbassra.chatClasses.chatModel.Chat_Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChatLogin_View extends View<Chat_Model> {
	
	private BorderPane mainPane;
	private GridPane root;
    public Button btnJoin;
    private Label lblEnterName;
    private Label lblWellcome;
    private Label lblIcon;
    private Label lblServer;
    private Label lblPort;
    private TextField txtServerAddress;
    private TextField txtPortAddress;
    private TextField txtUserName;
    
    Chat chat = new Chat();
	
	public ChatLogin_View(Stage stage, Chat_Model model) {
		super(stage, model);
		
		btnJoin.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("join button kam kr rya wey");
        		chat.startMainView();
        	}
        	
        });
	}
	
	@Override
	protected Scene create_GUI() {
		
		root = new GridPane();
		mainPane = new BorderPane();
		
    	lblIcon = new Label();
    	lblWellcome = new Label("Wellcome To Chat");
    	lblEnterName = new Label("Enter Name: ");
    	lblServer = new Label("Server: ");
    	lblPort = new Label("Port: ");
    	txtUserName = new TextField();
    	txtServerAddress = new TextField("LocalHost");
    	txtPortAddress = new TextField("8888");
    	btnJoin = new Button(" JOIN ");

    	root.add(lblWellcome, 0, 0);
    	root.add(lblEnterName, 0, 1);
    	root.add(txtUserName, 1, 1);
    	root.add(lblServer, 0, 2);
    	root.add(txtServerAddress, 1, 2);
    	root.add(lblPort, 2, 2);
    	root.add(txtPortAddress, 3, 2);
    	root.add(btnJoin, 3, 3);
    	
		mainPane.setLeft(lblIcon);
		mainPane.setTop(lblWellcome);
		mainPane.setCenter(root);
		
		Scene scene = new Scene(mainPane);
		
		
		return scene;
		
	}

}
