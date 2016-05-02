package ch.be.mtbassra.chatClasses;

import java.net.InetAddress;
import java.util.Set;
import java.util.TreeSet;

public class User {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private InetAddress server = InetAddress.getLoopbackAddress();
	private int port;
	
	public User(){
		
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
