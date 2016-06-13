package ch.be.mtbassra.chatClasses;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

import ch.be.mtbassra.commonClasses.ServiceLocator;

/*
 * The server that can be run both as a console application or a GUI
 */
public class Server {

	ServiceLocator serviceLocator;
	// a unique ID for each connection
	private static int uniqueId;
	// an ArrayList to keep the list of the Client
	private ArrayList<ClientThread> clientThread;
	// the port number to listen for connection
	private int port;
	// the boolean that will be turned of to stop the server
	private boolean keepGoing;
//	private static boolean serverListning = false;

	/*
	 * server constructor that receive the port to listen to for connection
	 * 
	 */
	public Server(int port) {
		
		serviceLocator = ServiceLocator.getServiceLocator();
		// the port
		this.port = port;
		// ArrayList for the Client list
		clientThread = new ArrayList<ClientThread>();
	}

	public void start() {
		keepGoing = true;
		/* create socket server and wait for connection requests */
		try {
			// the socket used by the server
			ServerSocket serverSocket = new ServerSocket(port);

			// infinite loop to wait for connections
			while (keepGoing) {
				// format message saying we are waiting
				System.out.println("Server waiting for Clients on port " + port + ".");

				Socket socket = serverSocket.accept(); // accept connection
				// if I was asked to stop
				if (!keepGoing)
					break;
				ClientThread t = new ClientThread(socket); // make a thread of
															// it
				clientThread.add(t); // save it in the ArrayList
				t.start();
			}
			// It was asked to stop
			try {
				serverSocket.close();
				for (int i = 0; i < clientThread.size(); ++i) {
					ClientThread tc = clientThread.get(i);
					try {
						tc.sInput.close();
						tc.sOutput.close();
						tc.socket.close();
					} catch (IOException ioE) {
						// not much I can do
					}
				}
			} catch (Exception e) {
				serviceLocator.getLogger().info("Exception closing the server and clients: " + e);
				System.out.println("Exception closing the server and clients: " + e);
			}
		}
		// something went wrong
		catch (IOException e) {
			serviceLocator.getLogger().info("Exception closing the server and clients: " + e + "\n");
			String msg = (" Exception on new ServerSocket: " + e + "\n");
			System.out.println(msg);
		}
	}

	/*
	 * to broadcast a message to all Clients
	 */
	public synchronized void broadcast(String message) {

		String messageLf = message + "\n";
		System.out.print(messageLf);

		// loop in reverse order in case we would have to remove a Client
		// because it has disconnected
		for (int i = clientThread.size(); --i >= 0;) {
			ClientThread ct = clientThread.get(i);
			// try to write to the Client if it fails remove it from the list
			if (!ct.writeMsg(messageLf)) {
				clientThread.remove(i);
				System.out.println("Disconnected Client " + ct.username + " removed from list.");
			}
		}
	}

	// remove a client who logoff 
	public synchronized void remove(int id) {
		// scan the array list until we found the Id
		for (int i = 0; i < clientThread.size(); ++i) {
			ClientThread ct = clientThread.get(i);
			// found it
			if (ct.id == id) {
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
	 * Run the server
	 */
	public static void main(String[] args) {
		// start server on port 8888 unless a PortNumber is specified
		int portNumber = 8888;
		// create a server object and start it
		Server server = new Server(portNumber);
		server.start();		
	}

}
