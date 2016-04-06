package ch.be.mtbassra.chatClasses.chatModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatAccess extends Observable {
	
	// Declaring the Socket and the ObjectOutputStream
    private Socket socket;
    private ObjectOutputStream oos;

    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }

    /*
     * Create socket, and receiving thread with the parameter server and port
     * Throws IOException. 
     */
    public ChatAccess(String server, int port) throws IOException {
        socket = new Socket(server, port);
        oos = new ObjectOutputStream(socket.getOutputStream());

        Thread receivingThread = new Thread() {
            @SuppressWarnings("rawtypes")
			@Override
            public void run() {
                try {
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					ChatMessage message = (ChatMessage) ois.readObject();
                    while (message != null) {
                        notifyObservers(message);
                        message = (ChatMessage) ois.readObject();
                    }
                } catch (IOException ex) {
                    notifyObservers(ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ChatAccess.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        receivingThread.start();
    }

    
    
    /*
     * Send a message to the server with the parameter message to send and throws IOException.
     */
    @SuppressWarnings("rawtypes")
	public void send(ChatMessage message) throws IOException {
        oos.writeObject(message);
    }

    
    
    
    /*
     * Close the socket and catch IOException.
     */
    
    public void close() {
        try {
            socket.close();
        } catch (IOException ex) {
            notifyObservers(ex);
        }
    }
}
