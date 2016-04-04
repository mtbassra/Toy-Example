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

public class ChatMain_View extends View<Chat_Model> {

	private BorderPane mainPane;
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

	public ChatMain_View(Stage stage, Chat_Model model) {
		super(stage, model);
	}

	@Override
	protected Scene create_GUI() {

		root = new GridPane();
		mainPane = new BorderPane();

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

		mainPane.setCenter(root);

		Scene scene = new Scene(mainPane);

		return scene;
	}

	public BorderPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}

	public Label getLblLoggedAs() {
		return lblLoggedAs;
	}

	public void setLblLoggedAs(Label lblLoggedAs) {
		this.lblLoggedAs = lblLoggedAs;
	}

	public TextField getTxtLoggedAs() {
		return txtLoggedAs;
	}

	public void setTxtLoggedAs(TextField txtLoggedAs) {
		this.txtLoggedAs = txtLoggedAs;
	}

	public Button getBtnDisconnect() {
		return btnDisconnect;
	}

	public void setBtnDisconnect(Button btnDisconnect) {
		this.btnDisconnect = btnDisconnect;
	}

	public Label getLblConversation() {
		return lblConversation;
	}

	public void setLblConversation(Label lblConversation) {
		this.lblConversation = lblConversation;
	}

	public TextField getTxtConversation() {
		return txtConversation;
	}

	public void setTxtConversation(TextField txtConversation) {
		this.txtConversation = txtConversation;
	}

	public Label getLblMessage() {
		return lblMessage;
	}

	public void setLblMessage(Label lblMessage) {
		this.lblMessage = lblMessage;
	}

	public TextField getTxtMessage() {
		return txtMessage;
	}

	public void setTxtMessage(TextField txtMessage) {
		this.txtMessage = txtMessage;
	}

	public Button getBtnSend() {
		return btnSend;
	}

	public void setBtnSend(Button btnSend) {
		this.btnSend = btnSend;
	}

	public Label getLblCurrentOnline() {
		return lblCurrentOnline;
	}

	public void setLblCurrentOnline(Label lblCurrentOnline) {
		this.lblCurrentOnline = lblCurrentOnline;
	}

	public TextField getTxtCurrentOnline() {
		return txtCurrentOnline;
	}

	public void setTxtCurrentOnline(TextField txtCurrentOnline) {
		this.txtCurrentOnline = txtCurrentOnline;
	}

}