package ch.be.mtbassra.chatClasses;

import java.io.IOException;

import ch.be.mtbassra.commonClasses.ServiceLocator;

/*
 * a class that waits for the message from the server and append them to the JTextArea
 * if we have a GUI or simply System.out.println() it in console mode
 */
public class ListenFromServer extends Thread {

	ServiceLocator serviceLocator;
	String message;	
	Client client;
	
	public ListenFromServer(Client client) {
		this.client = client;
	}

	public void run() {
		while (true) {
			try {
				message = (String) client.getsInput().readObject();
				System.out.println(message);
				
			} catch (IOException e) {
				System.out.println("Server has close the connection: " + e);
				break;
			}
			// can't happen with a String object but need the catch anyhow
			catch (ClassNotFoundException e2) {
			}
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}