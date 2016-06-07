package ch.be.mtbassra.chatClasses;

import java.io.IOException;

/*
 * a class that waits for the message from the server and append them to the JTextArea
 * if we have a GUI or simply System.out.println() it in console mode
 */
public class ListenFromServer extends Thread {
	Client client;

	public void run() {
		while(true) {
			try {
				String msg = (String) client.getsInput().readObject();
				// if console mode print the message and add back the prompt
					System.out.println(msg);
					System.out.print("> ");
			}
			catch(IOException e) {
				System.out.println("Server has close the connection: " + e);
				break;
			}
			// can't happen with a String object but need the catch anyhow
			catch(ClassNotFoundException e2) {
			}
		}
	}
}