package ch.be.mtbassra.chatClasses.chatMain;

import java.util.Locale;
import ch.be.mtbassra.abstractClasses.View;
import ch.be.mtbassra.commonClasses.ServiceLocator;
import ch.be.mtbassra.commonClasses.Translator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChatMain_View extends View<ChatMain_Model> {
	
	private Menu menuFile;
	private Menu menuFileLanguage;
	private Menu menuHelp;

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
	private Label lblCurrentlyOnline;
	private TextField txtCurrentOnline;

	public ChatMain_View(Stage stage, ChatMain_Model model) {
		super(stage, model);
	}

	@Override
	protected Scene create_GUI() {
		
		ServiceLocator sl = ServiceLocator.getServiceLocator();
		Translator tl = sl.getTranslator();
		
		MenuBar menuBar = new MenuBar();
		menuFile = new Menu(tl.getString("program.menu.file"));
		menuFileLanguage = new Menu(tl.getString("program.menu.file.language"));
		menuFile.getItems().add(menuFileLanguage);
		
		for (Locale locale : sl.getLocales()) {
			MenuItem language = new MenuItem(locale.getLanguage());
			menuFileLanguage.getItems().add(language);
			language.setOnAction( event -> {
				sl.setTranslator(new Translator(locale.getLanguage()));
				updateMainTexts();
			});
		}
		menuHelp = new Menu(tl.getString("program.menu.help"));
		
		menuBar.getMenus().addAll(menuFile, menuHelp);

		root = new GridPane();
		mainPane = new BorderPane();

		lblLoggedAs = new Label(tl.getString("logged.as"));
		txtLoggedAs = new TextField();
		btnDisconnect = new Button(tl.getString("disconnect"));
		lblConversation = new Label(tl.getString("conversation"));
		txtConversation = new TextField();
		lblMessage = new Label(tl.getString("message"));
		txtMessage = new TextField();
		btnSend = new Button(tl.getString("send"));
		lblCurrentlyOnline = new Label(tl.getString("currently.online"));
		txtCurrentOnline = new TextField();

		root.add(lblLoggedAs, 1, 1);
		root.add(txtLoggedAs, 2, 1);
		root.add(btnDisconnect, 2, 2);
		root.add(lblConversation, 1, 3);
		root.add(txtConversation, 2, 3);
		root.add(lblMessage, 1, 4);
		root.add(txtMessage, 2, 4);
		root.add(btnSend, 2, 5);
		root.add(lblCurrentlyOnline, 4, 1);
		root.add(txtCurrentOnline, 4, 2);

		mainPane.setTop(menuBar);
		mainPane.setCenter(root);

		Scene scene = new Scene(mainPane);

		return scene;
	}
	
	public void updateMainTexts() {
		
		Translator tl = ServiceLocator.getServiceLocator().getTranslator();
		//the menu entries
		menuFile.setText(tl.getString("program.menu.file"));
		menuFileLanguage.setText(tl.getString("program.menu.file.language"));
		menuHelp.setText(tl.getString("program.menu.help"));
		
		//Labels
		lblLoggedAs.setText(tl.getString("logged.as"));
		lblCurrentlyOnline.setText(tl.getString("currently.online"));
		lblConversation.setText(tl.getString("conversation"));
		lblMessage.setText(tl.getString("message"));
		
		//Control
		btnDisconnect.setText(tl.getString("disconnect"));
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
		return lblCurrentlyOnline;
	}

	public void setLblCurrentOnline(Label lblCurrentOnline) {
		this.lblCurrentlyOnline = lblCurrentOnline;
	}

	public TextField getTxtCurrentOnline() {
		return txtCurrentOnline;
	}

	public void setTxtCurrentOnline(TextField txtCurrentOnline) {
		this.txtCurrentOnline = txtCurrentOnline;
	}

}