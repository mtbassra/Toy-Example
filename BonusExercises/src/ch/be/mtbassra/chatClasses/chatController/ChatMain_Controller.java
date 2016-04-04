package ch.be.mtbassra.chatClasses.chatController;

import ch.be.mtbassra.abstractClasses.Controller;
import ch.be.mtbassra.chatClasses.chatModel.Chat_Model;
import ch.be.mtbassra.chatClasses.chatView.ChatMain_View;

public class ChatMain_Controller extends Controller<Chat_Model, ChatMain_View> {
	
	public ChatMain_Controller(Chat_Model model, ChatMain_View view) {
		super(model, view);
	}

}
