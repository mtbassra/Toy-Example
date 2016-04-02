package ch.be.mtbassra.chatClasses.chatView;

import ch.be.mtbassra.abstractClasses.View;
import ch.be.mtbassra.chatClasses.chatModel.Chat_Model;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chat_View extends View<Chat_Model> {
	
	ChatLoginFrame loginFrame = new ChatLoginFrame();
	
	public Chat_View(Stage stage, Chat_Model model) {
		super(stage, model);
	}
	
	@Override
	protected Scene create_GUI() {
		
		Scene scene = new Scene(loginFrame);
		
		return scene;
	}
}
