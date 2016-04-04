package ch.be.mtbassra.chatClasses.chatController;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.Chat;
import ch.be.mtbassra.chatClasses.chatModel.Chat_Model;
import ch.be.mtbassra.chatClasses.chatView.ChatLogin_View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ChatLogin_Controller extends Controller<Chat_Model, ChatLogin_View> {
	
	Chat chat = new Chat();
	
	public ChatLogin_Controller(Chat_Model model, ChatLogin_View view) {
		super(model, view);
		
     // register ourselves to listen for button Start Play
        
		view.btnJoin.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("join button kam kr rya wey");
        		chat.startMainView();
        	}
        	
        });
	}

}
