package ch.be.mtbassra.chatClasses;

import java.io.PrintStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class ChatServer {

    public static final String QUIT = "/quit";

    // Server socket.
    private static ServerSocket serverSocket = null;
    // Client socket.
    private static Socket clientSocket = null;
    // Current online users
    private static Set<String> onlineUsers = new TreeSet<String>();
    // Current vector clocks
    private static Map<String, Integer> vectorClocks = new TreeMap<String, Integer>();
    // Current history
    private static List<String> histories = new ArrayList<String>();
    // Current private channels
    private static Map<String, Integer> privateChanels = new HashMap<String, Integer>();
    // Chat server can accept up to "maxClientsCount" clients connections.
    private static final int maxClientsCount = 8;
    // Thread to serve the client request
    private static final ChatThread[] threads = new ChatThread[maxClientsCount];
    // History size
    private static final int HISTORY_SIZE = 10;

    /**
     * Add latest history to chat channel
     * @param history history to add
     */
    synchronized public static void addHistory(String history) {
        while (histories.size() >= HISTORY_SIZE) {
            histories.remove(0);
        }
            
        histories.add(history);
    }
    
    /**
     * Get latest history
     * @return history
     */
    synchronized public static List<String> getHistories() {
        return new ArrayList<String>(histories);
    }
    
    /**
     * Add online user
     * @param user user
     */
    synchronized public static void addOnlineUser(String user) {
        onlineUsers.add(user);
    }

    /**
     * Remove online user (when user goes offline)
     * @param user user to remove
     */
    synchronized public static void removeOnlineUser(String user) {
        onlineUsers.remove(user);
    }

    /**
     * Get all current online users
     * @return current online users
     */
    synchronized public static Set<String> getOnlineUsers() {
        Set<String> result = new TreeSet<String>(onlineUsers);
        return result;
    }

    /**
     * remove item from vector clock
     * @param user user that we want to remove item
     */
    synchronized public static void removeFromVectorClock(String user) {
        vectorClocks.remove(user);
    }
    
    /**
     * Add new item to private chanel (1-1 chatting)
     * @param sender the sender
     * @param receiver the receiver
     * @param numberOfConversation number of conversation made
     */
    synchronized public static void increaseNumberOfConversation(String sender, String receiver, Integer numberOfConversation) {
        String key = sender.compareTo(receiver) < 0 ? sender + receiver : receiver + sender;
        Integer i = privateChanels.get(key);
        if (i == null) {
            privateChanels.put(key, numberOfConversation);
        } else {
            privateChanels.put(key, i + numberOfConversation);
        }
    }

    /**
     * Get number of conversation done between sender and receiver
     * @param sender sender
     * @param receiver receiver
     * @return 
     */
    synchronized public static int getNumberOfConversation(String sender, String receiver) {
        String key = sender.compareTo(receiver) < 0 ? sender + receiver : receiver + sender;
        Integer i = privateChanels.get(key);
        
        if (i == null) {
            i = Integer.valueOf(0);
        }
        
        return i;
    }

    public static void main(String args[]) {

        // The default port number.
        int portNumber = 8888;
        if (args.length < 1) {
            System.out.println("Usage: java MultiThreadChatServerSync <portNumber>\n"
                    + "Now using port number=" + portNumber);
        } else {
            portNumber = Integer.valueOf(args[0]).intValue();
        }

        // Open a new socket
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println(e);
        }

        // For each connection, create a thread to track it
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                int i = 0;
                for (i = 0; i < maxClientsCount; i++) {
                    if (threads[i] == null) {
                        (threads[i] = new ChatThread(clientSocket, threads)).start();
                        break;
                    }
                }
                if (i == maxClientsCount) {
                    PrintStream os = new PrintStream(clientSocket.getOutputStream());
                    String message = "Server too busy, cannot have more than " + maxClientsCount + " clients";
                    os.println(message);
                    System.out.println(message);
                    os.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
