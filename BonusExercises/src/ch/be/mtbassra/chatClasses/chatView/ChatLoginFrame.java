package ch.be.mtbassra.chatClasses.chatView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ChatLoginFrame extends BorderPane {
	
	private GridPane root;
    private Button btnJoin;
    private Label lblEnterName;
    private Label lblWellcome;
    private Label lblIcon;
    private Label lblServer;
    private Label lblPort;
    private TextField txtServerAddress;
    private TextField txtPortAddress;
    private TextField txtUserName;

	protected ChatLoginFrame() {
		super();
		root = new GridPane();
		
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
    	
		this.setLeft(lblIcon);
		this.setTop(lblWellcome);
		this.setCenter(root);

	}
}
