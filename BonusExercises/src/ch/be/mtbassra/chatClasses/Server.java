package ch.be.mtbassra.chatClasses;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * The server that can be run both as a console application or a GUI
 */
public class Server {
	// a unique ID for each connection
	private static int uniqueId;
	// an ArrayList to keep the list of the Client
	private ArrayList<ClientThread> clientThread;
	// the port number to listen for connection
	private int port;
	// the boolean that will be turned of to stop the server
	private boolean keepGoing;

	/*
	 *  server constructor that receive the port to listen to for connection as parameter
	 *  in console
	 */

	public Server(int port) {

		// the port
		this.port = port;
		// ArrayList for the Client list
		clientThread = new ArrayList<ClientThread>();
	}
	
	public void start() {
		keepGoing = true;
		/* create socket server and wait for connection requests */
		try 
		{
			// the socket used by the server
			ServerSocket serverSocket = new ServerSocket(port);

			// infinite loop to wait for connections
			while(keepGoing) 
			{
				// format message saying we are waiting
				System.out.println("Server waiting for Clients on port " + port + ".");
				
				Socket socket = serverSocket.accept();  	// accept connection
				// if I was asked to stop
				if(!keepGoing)
					break;
				ClientThread t = new ClientThread(socket);  // make a thread of it
				clientThread.add(t);									// save it in the ArrayList
				t.start();
			}
			// I was asked to stop
			try {
				serverSocket.close();
				for(int i = 0; i < clientThread.size(); ++i) {
					ClientThread tc = clientThread.get(i);
					try {
					tc.sInput.close();
					tc.sOutput.close();
					tc.socket.close();
					}
					catch(IOException ioE) {
						// not much I can do
					}
				}
			}
			catch(Exception e) {
				System.out.println("Exception closing the server and clients: " + e);
			}
		}
		// something went bad
		catch (IOException e) {
            String msg = (" Exception on new ServerSocket: " + e + "\n");
            System.out.println(msg);
		}
	}		

	/*
	 *  to broadcast a message to all Clients
	 */
	public synchronized void broadcast(String message) {

		String messageLf = message + "\n";
			System.out.print(messageLf);
		
		// we loop in reverse order in case we would have to remove a Client
		// because it has disconnected
		for(int i = clientThread.size(); --i >= 0;) {
			ClientThread ct = clientThread.get(i);
			// try to write to the Client if it fails remove it from the list
			if(!ct.writeMsg(messageLf)) {
				clientThread.remove(i);
				System.out.println("Disconnected Client " + ct.username + " removed from list.");
			}
		}
	}

	// for a client who logoff using the LOGOUT message
	public synchronized void remove(int id) {
		// scan the array list until we found the Id
		for(int i = 0; i < clientThread.size(); ++i) {
			ClientThread ct = clientThread.get(i);
			// found it
			if(ct.id == id) {
				clientThread.remove(i);
				return;
			}
		}
	}
	
	
	
	public static int getUniqueId() {
		return uniqueId;
	}

	public static void setUniqueId(int uniqueId) {
		Server.uniqueId = uniqueId;
	}

	/*
	 *  To run as a console application just open a console window and: 
	 * > java Server
	 * > java Server portNumber
	 * If the port number is not specified 1500 is used
	 */ 
	public static void main(String[] args) {
		// start server on port 1500 unless a PortNumber is specified 
		int portNumber = 1500;
		switch(args.length) {
			case 1:
				try {
					portNumber = Integer.parseInt(args[0]);
				}
				catch(Exception e) {
					System.out.println("Invalid port number.");
					System.out.println("Usage is: > java Server [portNumber]");
					return;
				}
			case 0:
				break;
			default:
				System.out.println("Usage is: > java Server [portNumber]");
				return;
				
		}
		// create a server object and start it
		Server server = new Server(portNumber);
		server.start();
	}

}

