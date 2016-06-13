package ch.be.mtbassra.chatClasses.chatLogin;

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

public class ChatLogin_View extends View<ChatLogin_Model> {
		
	private Menu menuFile;
	private Menu menuFileLanguage;
	private Menu menuHelp;

	private BorderPane mainPane;
	private GridPane root;
	private Button btnConnect;
	private Label lblEnterName;
	private Label lblIcon;
	private Label lblServer;
	private Label lblPort;
	private TextField txtServerAddress;
	private TextField txtPortAddress;
	private TextField txtUserName;

	public ChatLogin_View(Stage stage, ChatLogin_Model model) {
		super(stage, model);
		
		stage.setTitle("CHAT WITH ALL");
		
		ServiceLocator.getServiceLocator().getLogger().info("Chat Login View initialized");
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
				updateLoginTexts();
			});
		}
		
		menuHelp = new Menu(tl.getString("program.menu.help"));
		
		menuBar.getMenus().addAll(menuFile, menuHelp);
		
		root = new GridPane();
		mainPane = new BorderPane();

		lblIcon = new Label();
		lblEnterName = new Label(tl.getString("enter.name"));
		
		lblServer = new Label(tl.getString("server"));
		lblPort = new Label(tl.getString("port"));
		txtUserName = new TextField();
		txtServerAddress = new TextField("localhost");
		txtPortAddress = new TextField("8888");
		btnConnect = new Button(tl.getString("connect"));

		root.add(lblEnterName, 0, 1);
		root.add(txtUserName, 1, 1);
		root.add(lblServer, 0, 2);
		root.add(txtServerAddress, 1, 2);
		root.add(lblPort, 2, 2);
		root.add(txtPortAddress, 3, 2);
		root.add(btnConnect, 3, 3);

		mainPane.setTop(menuBar);
		mainPane.setLeft(lblIcon);
		mainPane.setCenter(root);

		Scene scene = new Scene(mainPane);
		return scene;

	}
	
	public void updateLoginTexts() {
		Translator tl = ServiceLocator.getServiceLocator().getTranslator();
		//the menu entries
		menuFile.setText(tl.getString("program.menu.file"));
		menuFileLanguage.setText(tl.getString("program.menu.file.language"));
		menuHelp.setText(tl.getString("program.menu.help"));
		
		//Labels
		lblEnterName.setText(tl.getString("enter.name"));
		lblServer.setText(tl.getString("server"));
		lblPort.setText(tl.getString("port"));
		
		//Control
		btnConnect.setText(tl.getString("connect"));
	}
	

	public GridPane getRoot() {
		return root;
	}

	public void setRoot(GridPane root) {
		this.root = root;
	}

	public Button getBtnJoin() {
		return btnConnect;
	}

	public void setBtnJoin(Button btnJoin) {
		this.btnConnect = btnJoin;
	}

	public Label getLblEnterName() {
		return lblEnterName;
	}

	public void setLblEnterName(Label lblEnterName) {
		this.lblEnterName = lblEnterName;
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
