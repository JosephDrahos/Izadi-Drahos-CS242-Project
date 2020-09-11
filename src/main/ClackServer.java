package main;

import data.ClackData;
import java.lang.Math;

public class ClackServer {
	private int port;
	private boolean closeConnection;
	private ClackData dataToSendToServer;
	private ClackData dataToRecieveFromServer;
	
	public ClackServer(int port){
		this.port = port;
		this.closeConnection = true;
		this.dataToRecieveFromServer = null;
		this.dataToSendToServer = null;
	}
	
	public ClackServer(){
		this(7000);
	}
	
	public void start() {
		
	}
	
	public void receiveData() {
		
	}
	
	 public void sendData() {
		 
	 }
	 
	 @Override
		public int hashCode() {
			return (int) ((Math.random() * ( 300000-1)) + 1);
		}
		
		@Override
		public boolean equals(Object other) {
			ClackServer otherData = (ClackServer) other;
			return this.port == otherData.port && this.closeConnection == otherData.closeConnection;
		}
		
		@Override
		public String toString() {
			String output;
			output = "Port: " + this.port + "\n" + "Closed Connection: " + this.closeConnection + "\n" + "Data to Send: " + this.dataToSendToServer + "\n" + "Data to Receive: " + this.dataToRecieveFromServer + "\n";
			return output;
		}
}
