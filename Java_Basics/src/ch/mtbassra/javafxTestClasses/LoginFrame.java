package ch.mtbassra.javafxTestClasses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginFrame extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
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
    

	@Override
	public void start(Stage primaryStage) {
		

		primaryStage.setTitle("LoginFrame");
		primaryStage.setScene(creat_GUI());
		primaryStage.show();
	}
	
	private Scene creat_GUI() {
    	
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

		BorderPane mainPane = new BorderPane();
		
		mainPane.setLeft(lblIcon);
		mainPane.setTop(lblWellcome);
		mainPane.setCenter(root);
		
		Scene scene = new Scene(mainPane, 500, 500);
		
		return scene;
		

		
	}
}