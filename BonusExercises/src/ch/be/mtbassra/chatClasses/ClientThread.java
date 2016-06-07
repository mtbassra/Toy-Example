package ch.be.mtbassra.chatClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;


/** One instance of this thread will run for each client */
class ClientThread extends Thread {
	
	Server server;
	
	// an ArrayList to keep the list of the Client
	private ArrayList<ClientThread> clientThread;
	// the socket where to listen/talk
	Socket socket;
	ObjectInputStream sInput;
	ObjectOutputStream sOutput;
	// my unique id (easier for deconnection)
	int id;
	// the Username of the Client
	String username;
	// the only type of message a will receive
	ChatMessage cm;
	// the date I connect
	String date;

	// Constructore
	ClientThread(Socket socket) {
		
		// a unique id
		id = server.getUniqueId();
		id = ++id;
		this.socket = socket;
		/* Creating both Data Stream */
		System.out.println("Thread trying to create Object Input/Output Streams");
		try
		{
			// create output first
			sOutput = new ObjectOutputStream(socket.getOutputStream());
			sInput  = new ObjectInputStream(socket.getInputStream());
			// read the username
			username = (String) sInput.readObject();
			System.out.println(username + " just connected.");
		}
		catch (IOException e) {
			System.out.println("Exception creating new Input/output Streams: " + e);
			return;
		}
		// have to catch ClassNotFoundException
		// but I read a String, I am sure it will work
		catch (ClassNotFoundException e) {
		}
        date = new Date().toString() + "\n";
	}

	// what will run forever
	public void run() {
		// to loop until LOGOUT
		boolean keepGoing = true;
		while(keepGoing) {
			// read a String (which is an object)
			try {
				cm = (ChatMessage) sInput.readObject();
			}
			catch (IOException e) {
				System.out.println(username + " Exception reading Streams: " + e);
				break;				
			}
			catch(ClassNotFoundException e2) {
				break;
			}
			// the messaage part of the ChatMessage
			String message = cm.getMessage();

			// Switch on the type of message receive
			switch(cm.getType()) {

			case ChatMessage.MESSAGE:
				server.broadcast(username + ": " + message);
				break;
			case ChatMessage.LOGOUT:
				System.out.println(username + " disconnected with a LOGOUT message.");
				keepGoing = false;
				break;
			case ChatMessage.WHOISIN:
				writeMsg("List of the users connected at " + "\n");
				// scan al the users connected
				for(int i = 0; i < clientThread.size(); ++i) {
					ClientThread ct = clientThread.get(i);
					writeMsg((i+1) + ") " + ct.username + " since " + ct.date);
				}
				break;
			}
		}
		// remove myself from the arrayList containing the list of the
		// connected Clients
		server.remove(id);
		close();
	}
	
	// try to close everything
	private void close() {
		// try to close the connection
		try {
			if(sOutput != null) sOutput.close();
		}
		catch(Exception e) {}
		try {
			if(sInput != null) sInput.close();
		}
		catch(Exception e) {};
		try {
			if(socket != null) socket.close();
		}
		catch (Exception e) {}
	}

	/*
	 * Write a String to the Client output stream
	 */
	public boolean writeMsg(String msg) {
		// if Client is still connected send the message to it
		if(!socket.isConnected()) {
			close();
			return false;
		}
		// write the message to the stream
		try {
			sOutput.writeObject(msg);
		}
		// if an error occurs, do not abort just inform the user
		catch(IOException e) {
			System.out.println("Error sending message to " + username);
			System.out.println(e.toString());
		}
		return true;
	}
}