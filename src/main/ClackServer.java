package main;

import data.ClackData;
import java.lang.Math;
/**
 * Class is a blueprint for a ClackServer object that contains information about the port number that clients connect to
 * @author Rod Izadi & Joseph Drahos
 *
 */
public class ClackServer {
	private int port;							//integer representing port number on server connected to
	private boolean closeConnection;			//boolean representing whether connection is closed or not
	private ClackData dataToSendToServer;		//ClackData object representing data received from the client
	private ClackData dataToRecieveFromServer;	//ClackData object representing data sent to client
	
	/**
	 * constructor that sets port number
	 * @param port: integer representing port number
	 */
	public ClackServer(int port){
		this.port = port;
		this.closeConnection = true;
		this.dataToRecieveFromServer = null;
		this.dataToSendToServer = null;
	}
	
	/**
	 * Overloaded previous method setting port to default 7000
	 */
	public ClackServer(){
		this(7000);
	}
	
	/**
	 * WILL IMPLEMENT LATER
	 */
	public void start() {
		
	}

	/**
	 * WILL IMPLEMENT LATER
	 */
	public void receiveData() {
		
	}

	/**
	 * WILL IMPLEMENT LATER
	 */
	 public void sendData() {
		 
	 }
	/**
	 * Overrides default hashCode function to give unique hashCode for every ClackServer object
	 * @returns hashCode number
	 */	 
	 @Override
	public int hashCode() {
		return this.port;
	}
	
	/**
	 * Overrides default equals method and compares all variables in a ClackServer object to check equivalence
	 * @returns true or false
	 */ 
	@Override
		public boolean equals(Object other) {
		ClackServer otherData = (ClackServer) other;
		return this.port == otherData.port && this.closeConnection == otherData.closeConnection;
	}
	
	/**
	 * Overrides toString method to outputs strings of all ClackServer data
	 * returns string of object data
	 */	
	@Override
	public String toString() {
			String output;
			output = "Port: " + this.port + "\n" + "Closed Connection: " + this.closeConnection + "\n" + "Data to Send: " + this.dataToSendToServer + "\n" + "Data to Receive: " + this.dataToRecieveFromServer + "\n";
			return output;
	}
}
