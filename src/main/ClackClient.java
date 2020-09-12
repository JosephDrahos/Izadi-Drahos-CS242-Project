package main;

import data.ClackData;
import data.FileClackData;
/**
 * This class represents the client user
 * @author Joseph Drahos & Rod Izadi
 *
 */
public class ClackClient {
	
	private String userName;					//String representing name of the client
	private String hostName;					//String representing name of the computer representing the server
	private int port;							//integer representing port number on server connected to
	private boolean closeConnection;			//boolean representing whether connection is closed or not
	private ClackData dataToSendToServer;		//ClackData object representing data sent to server
	private ClackData dataToRecieveFromServer;	//ClackData object representing data received from the server
	
	/**
	 * Constructor for username, host name, and port,connection is automatically set to open
	 * Data sent to server and recieved from server to null
	 * @param userName: name of user
	 * @param hostName: name of host
	 * @param port: port number for connection
	 */
	public ClackClient (String userName, String hostName, int port){
		this.userName = userName;
		this.hostName = hostName;
		this.port = port;
		this.closeConnection = false;
		this.dataToSendToServer = null;
		this.dataToRecieveFromServer = null;
	}
	
	/**
	 * Overloaded previous method with automatically setting port to 7000
	 * @param userName: name of user
	 * @param hostName: name of host
	 */
	public ClackClient (String userName, String hostName){
		this(userName,hostName,7000);
	}
	
	/**
	 * Overloaded previous function with automatically setting port to 7000 and hostName to "localhost"
	 * @param userName: name of user
	 */
	public ClackClient (String userName){
		this(userName, "localhost");
	}
	
	/**
	 * Overloaded previous function automatically setting port to 7000, hostname to "localhost", and userName to "Anon"
	 */
	public ClackClient(){
		this("Anon");
	}
	
	/**
	 * WILL IMPLEMENT LATER
	 */
	public void start() {
		
	}
	
	/**
	 * WILL IMPLEMENT LATER
	 */
	public void readClientData() {
		
	}
	
	/**
	 * WILL IMPLEMENT LATER
	 */
	public void receiveData() {
		
	}
	
	/**
	 * WILL IMPLEMENT LATER
	 */
	public void printData() {
		
	}
	
	/**
	 * 
	 * @return Name of user
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * 
	 * @return name of host
	 */
	public String getHostName() {
		return this.hostName;
	}
	
	/**
	 * 
	 * @return port number
	 */
	public int getPort() {
		return this.port;
	}
	
	/**
	 * Overrides default hashCode function to give unique hashCode for every ClackClient object
	 * @returns hashCode number
	 */
	@Override
	public int hashCode() {
		return (int) ((Math.random() * ( 300000-1)) + 1);
	}
	
	/**
	 * Overrides default equals method and compares all variables in a ClackClient object to check equivalence
	 * @returns true or false
	 */
	@Override
	public boolean equals(Object other) {
		ClackClient otherData = (ClackClient) other;
		return this.userName == otherData.userName && this.hostName == otherData.hostName && this.port == otherData.port && this.closeConnection == otherData.closeConnection;
	}
	
	/**
	 * Overrides toString method to outputs strings of all ClackClient data
	 * returns string of object data
	 */
	@Override
	public String toString() {
		String output;
		output = "Username: " + this.userName + "\n" + "hostName: " + this.hostName + "\n" + "Port: " + getPort() + "\n" + "Closed Connection: " + this.closeConnection + "\n" + "Data to Send: " + this.dataToSendToServer + "\n" + "Data to Receive: " + this.dataToRecieveFromServer + "\n";
		return output;
	}
}
