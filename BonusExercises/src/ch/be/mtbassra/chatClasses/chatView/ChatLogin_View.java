package ch.be.mtbassra.chatClasses.chatView;

import ch.be.mtbassra.abstractClasses.View;
import ch.be.mtbassra.chatClasses.chatModel.Chat_Model;
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
	private Button btnJoin;
	private Label lblEnterName;
	private Label lblWellcome;
	private Label lblIcon;
	private Label lblServer;
	private Label lblPort;
	private TextField txtServerAddress;
	private TextField txtPortAddress;
	private TextField txtUserName;

	public ChatLogin_View(Stage stage, Chat_Model model) {
		super(stage, model);
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

	public GridPane getRoot() {
		return root;
	}

	public void setRoot(GridPane root) {
		this.root = root;
	}

	public Button getBtnJoin() {
		return btnJoin;
	}

	public void setBtnJoin(Button btnJoin) {
		this.btnJoin = btnJoin;
	}

	public Label getLblEnterName() {
		return lblEnterName;
	}

	public void setLblEnterName(Label lblEnterName) {
		this.lblEnterName = lblEnterName;
	}

	public Label getLblWellcome() {
		return lblWellcome;
	}

	public void setLblWellcome(Label lblWellcome) {
		this.lblWellcome = lblWellcome;
	}

	public Label getLblIcon() {
		return lblIcon;
	}

	public void setLblIcon(Label lblIcon) {
		this.lblIcon = lblIcon;
	}

	public Label getLblServer() {
		return lblServer;
	}

	public void setLblServer(Label lblServer) {
		this.lblServer = lblServer;
	}

	public Label getLblPort() {
		return lblPort;
	}

	public void setLblPort(Label lblPort) {
		this.lblPort = lblPort;
	}

	public TextField getTxtServerAddress() {
		return txtServerAddress;
	}

	public void setTxtServerAddress(TextField txtServerAddress) {
		this.txtServerAddress = txtServerAddress;
	}

	public TextField getTxtPortAddress() {
		return txtPortAddress;
	}

	public void setTxtPortAddress(TextField txtPortAddress) {
		this.txtPortAddress = txtPortAddress;
	}

	public TextField getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(TextField txtUserName) {
		this.txtUserName = txtUserName;
	}
	

}
