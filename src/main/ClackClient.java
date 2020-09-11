package main;

import data.ClackData;
import data.FileClackData;

public class ClackClient {
	private String userName;
	private String hostName;
	private int port;
	private boolean closeConnection;
	private ClackData dataToSendToServer;
	private ClackData dataToRecieveFromServer;
	
	public ClackClient (String userName, String hostName, int port){
		this.userName = userName;
		this.hostName = hostName;
		this.port = port;
		this.closeConnection = true;
		this.dataToSendToServer = null;
		this.dataToRecieveFromServer = null;
	}
	
	public ClackClient (String userName, String hostName){
		this(userName,hostName,7000);
	}
	
	public ClackClient (String userName){
		this(userName, "localhost");
	}
	
	public ClackClient(){
		this("Anon");
	}
	
	public void start() {
		
	}
	
	public void readClientData() {
		
	}
	
	public void receiveData() {
		
	}
	
	public void printData() {
		
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getHostName() {
		return this.hostName;
	}
	
	public int getPort() {
		return this.port;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		String user = this.userName;
		
		for(int i = 0; i < user.length(); i++) {
			hash = hash * (int) user.charAt(i);
		}
		
		return hash;
	}
	
	@Override
	public boolean equals(Object other) {
		ClackClient otherData = (ClackClient) other;
		return this.userName == otherData.userName && this.hostName == otherData.hostName && this.port == otherData.port && this.closeConnection == otherData.closeConnection;
	}
	
	@Override
	public String toString() {
		String output;
		output = "Username: " + this.userName + "\n" + "hostName: " + this.hostName + "\n" + "Port: " + getPort() + "\n" + "Closed Connection: " + this.closeConnection + "\n" + "Data to Send: " + this.dataToSendToServer + "\n" + "Data to Receive: " + this.dataToRecieveFromServer + "\n";
		return output;
	}
}
