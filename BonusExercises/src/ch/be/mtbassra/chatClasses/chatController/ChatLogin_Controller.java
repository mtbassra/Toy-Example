package ch.be.mtbassra.chatClasses.chatController;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.chatModel.Chat_Model;
import ch.be.mtbassra.chatClasses.chatView.ChatLogin_View;
import ch.be.mtbassra.chatClasses.chatView.ChatMain_View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ChatLogin_Controller extends Controller<Chat_Model, ChatLogin_View> {
	ChatMain_View mainView;

	public ChatLogin_Controller(Chat_Model model, ChatLogin_View view) {
		super(model, view);

		// register to listen for button Start Play
		view.getBtnJoin().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("join button kam kr rya wey");
				btnJoinAction();
			}

		});
	}

	public void btnJoinAction() {
		model.startMainView();
		view.stop();

	}

}
