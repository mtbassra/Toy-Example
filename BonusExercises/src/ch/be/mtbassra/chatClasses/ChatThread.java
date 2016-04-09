package ch.be.mtbassra.chatClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatThread extends Thread {

    private String clientName = null;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket clientSocket = null;
    private final ChatThread[] threads;
    private int maxClientsCount;

    public ChatThread(Socket clientSocket, ChatThread[] threads) {
        this.clientSocket = clientSocket;
        this.threads = threads;
        maxClientsCount = threads.length;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void run() {
        int maxClientsCount = this.maxClientsCount;
        ChatThread[] threads = this.threads;
		ChatMessage message = new ChatMessage();

        try {
            // Create input and output streams for this client.
            ois = new ObjectInputStream(clientSocket.getInputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());

            // Read the very first message
            try {
                message = (ChatMessage) ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChatThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            String name = (String) message.getPayload();
            System.out.print("the name is: " + message.getPayload() + "\n");

            // Add new Username
            ChatServer.addOnlineUser(name);
            ChatServer.addHistory(name + " has joined the room");
            for (int i = 0; i < maxClientsCount; i++) {
                if (threads[i] != null) {
                    // Broadcasting new joiner event
                    message = new ChatMessage(ChatMessage.MessageType.NEW_ONLINE, ChatServer.getOnlineUsers());
                    threads[i].oos.writeObject(message);

                    // Broadcasting the history
                    message = new ChatMessage(ChatMessage.MessageType.HISTORY, ChatServer.getHistories());
                    threads[i].oos.writeObject(message);
                }
            }

            // Welcome the new client.
            message = new ChatMessage(ChatMessage.MessageType.TEXT, 
                    "Welcome " + name + " to our chat room.");
            oos.writeObject(message);
            synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] != null && threads[i] == this) {
                        clientName = "@" + name;

                    } else if (threads[i] != null && threads[i] != this) {
                        message = new ChatMessage(ChatMessage.MessageType.TEXT, 
                                "*** A new user " + name + " entered the chat room !!! ***");
                        threads[i].oos.writeObject(message);

                    }
                }
            }
            
            
            // Start the conversation.
            while (true) {
                try {
                    message = (ChatMessage) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ChatThread.class.getName()).log(Level.SEVERE, null, ex);
                }

                String line = (String) message.getPayload();

                // Quit
                if (line.startsWith("/quit")) {
                    break;
                }
                
                // Private Message
                if (line.startsWith("@")) {
                    String[] words = line.split("\\s", 2);
                    if (words.length > 1 && words[1] != null) {
                        words[1] = words[1].trim();
                        if (!words[1].isEmpty()) {
                            synchronized (this) {
                                for (int i = 0; i < maxClientsCount; i++) {
                                    // If sender and receiver are found
                                    if (threads[i] != null && threads[i] != this
                                            && threads[i].clientName != null
                                            && threads[i].clientName.equals(words[0])) {
                                        String receiver = threads[i].clientName.substring(1);
                                        
                                        // Check to see if the chanel (sender, receiver) has already been etablished
                                        int nbConversation = ChatServer.getNumberOfConversation(name, receiver);
                                        if (nbConversation > 0) { // Old chanel
                                            message = new ChatMessage(ChatMessage.MessageType.TEXT, "RE[" + nbConversation + "]: (" + name + ", " + receiver + ") " + words[1]);
                                        } else { // No, it's the first time
                                            message = new ChatMessage(ChatMessage.MessageType.TEXT, 
                                                "(" + name + " to " + receiver + " ) " + words[1]);
                                        }
                                        // Notify the two sides
                                        threads[i].oos.writeObject(message);
                                        this.oos.writeObject(message);
                                        
                                        // Then increase the number of conversation by one
                                        ChatServer.increaseNumberOfConversation(name, receiver, 1);
                                        
                                        break;
                                    }
                                }

                                // Notify the event - user has sent a private message and then update the vector clock
                                ChatServer.addHistory(name + " has sent a private message");
                                for (int i = 0; i < maxClientsCount; i++) {
                                    // Update Vector Clock
                                    if (threads[i] != null) {
                                        message = new ChatMessage(ChatMessage.MessageType.HISTORY, ChatServer.getHistories());
                                        message.setSender(name);
                                        threads[i].oos.writeObject(message);
                                    }

                                }
                            }
                        }
                    }
                } else { // Broadcast message
                    synchronized (this) {
                        ChatServer.addHistory(name + " has sent a broadcast message");
                        for (int i = 0; i < maxClientsCount; i++) {
                            if (threads[i] != null && threads[i].clientName != null) {
                                message = new ChatMessage(ChatMessage.MessageType.TEXT, "<" + name + "> " + line);
                                threads[i].oos.writeObject(message);

                                // Update Vector Clock
                                message = new ChatMessage(ChatMessage.MessageType.HISTORY, ChatServer.getHistories());
                                message.setSender(name);
                                threads[i].oos.writeObject(message);
                            }
                        }
                    }
                }
            } // End of the while loop, user has left the chat room
            
            // Notify other user
            synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] != null && threads[i] != this
                            && threads[i].clientName != null) {
                        message = new ChatMessage(ChatMessage.MessageType.TEXT, "*** The user " + name
                                + " is leaving the chat room !!! ***");
                        threads[i].oos.writeObject(message);
                    }
                }
            }
            // Send goodbye message to that user
            message = new ChatMessage(ChatMessage.MessageType.TEXT, "*** Bye " + name + " ***");
            oos.writeObject(message);

            // Do some clean up: Remove user, remove clock, update history  
            // release the thread and close the streams
            ChatServer.removeOnlineUser(name);
            ChatServer.removeFromVectorClock(name);
            ChatServer.addHistory(name + " has left the room");
            for (int i = 0; i < maxClientsCount; i++) {
                if (threads[i] != null) {
                    message = new ChatMessage(ChatMessage.MessageType.NEW_OFFLINE, ChatServer.getOnlineUsers());
                    threads[i].oos.writeObject(message);

                    message = new ChatMessage(ChatMessage.MessageType.HISTORY, ChatServer.getHistories());
                    threads[i].oos.writeObject(message);
                }
            }

            synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] == this) {
                        threads[i] = null;
                    }
                }
            }
            
            oos.close();
            ois.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
