package ch.be.mtbassra.chatClasses;

import java.net.InetAddress;
import java.util.Set;
import java.util.TreeSet;

public class User {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private InetAddress server = InetAddress.getLoopbackAddress();
	private int port;
	
    private static Set<String> users = new TreeSet<String>();
	
	
	public User(String userName, InetAddress server, int port) {
		this.userName = userName;
		this.server = server;
		this.port = port;

	}
	
    public static Set<String> getUsers() {
        return users;
    }
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public InetAddress getServer() {
		return server;
	}


	public void setServer(InetAddress server) {
		this.server = server;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}
		

}
	
	
//
//private static final long serialVersionUID = 1L;
//private InetAddress ipAddress = InetAddress.getLoopbackAddress();
//private int portNumber = 0;
//
//
//public Player() {
//}
//
//
//
//public InetAddress getIpAddress() {
//	return ipAddress;
//}
//
//
//public void setIpAddress(InetAddress ipAddress) {
//	this.ipAddress = ipAddress;
//}
//
//
//public int getPortNumber() {
//	return portNumber;
//}
//
//
//public void setPortNumber(int portNumber) {
//	this.portNumber = portNumber;
//}
//}
