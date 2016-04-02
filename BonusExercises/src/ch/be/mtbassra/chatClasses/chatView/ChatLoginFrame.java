package ch.be.mtbassra.chatClasses.chatView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

@SuppressWarnings("unused")
public class ChatLoginFrame extends BorderPane{
	
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
    
    public ChatLoginFrame() {
    	create_GUI();
    }
    
    private void create_GUI() {
    	
    	root = new GridPane();
    	
    	lblIcon = new Label();
    	lblWellcome = new Label("Wellcome To Chat");
    	lblEnterName = new Label("Enty Name");
    	lblServer = new Label("Server");
    	lblPort = new Label("Port");
    	txtUserName = new TextField();
    	txtServerAddress = new TextField("LocalHost");
    	txtPortAddress = new TextField("8888");
    	btnJoin = new Button();

    	root.add(lblIcon, 0, 1);
    	root.add(lblWellcome, 0, 0);
    	root.add(lblEnterName, 1, 0);
    	root.add(txtUserName, 1, 1);
    	root.add(lblServer, 2, 0);
    	root.add(txtServerAddress, 2, 1);
    	root.add(lblPort, 2, 2);
    	root.add(lblPort, 2, 3);

    	
    }



}
