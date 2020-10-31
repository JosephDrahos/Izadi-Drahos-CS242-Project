package main;

import java.io.*;
import data.*;
import java.net.*;

public class ServerSideClientIO implements Runnable{
	private boolean closeConnection;
	private ClackData dataToReceiveFromClient;
	private ClackData dataToSendToClient;
	private ObjectInputStream inFromClient;
	private ObjectOutputStream outToClient;
	private ClackServer server;
	private Socket clientSocket;
	private String clientUserName;
	
	ServerSideClientIO(ClackServer server, Socket clientSocket){
		this.server = server;
		this.clientSocket = clientSocket;
		this.closeConnection = false;
		this.dataToReceiveFromClient = null;
		this.dataToSendToClient = null;
		this.inFromClient = null;
		this.outToClient = null;
		this.clientUserName = null;
	}


	@Override
	public void run() {
		try {
			while(!clientSocket.isClosed()) {
				outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
				inFromClient = new ObjectInputStream(clientSocket.getInputStream());
				receiveData();
				server.broadcast(dataToSendToClient);
				System.out.println(clientSocket.isClosed());
			}
			System.out.println("Removing " + this);
			server.remove(this);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void receiveData() {
		try { 
			dataToReceiveFromClient = (ClackData) inFromClient.readObject();
			this.clientUserName = dataToReceiveFromClient.getUserName();
			
			//message with listuser type
			if(dataToReceiveFromClient.getType() == 0) {
				dataToSendToClient = new MessageClackData("Server",server.getUserList(),3);
				System.out.println(dataToSendToClient.toString());
			}else {
				System.out.println(dataToReceiveFromClient.toString());
				dataToSendToClient = dataToReceiveFromClient;
			}
		}
		catch(IOException ioe) {
			System.err.println("ERROR: Could not receive data");
		}
		catch(ClassNotFoundException CNFE) {
			System.err.println("ERROR: Class was not found when recieving data");
		}
	}
	
	public void sendData() {
		try {
			outToClient.writeObject(dataToSendToClient);
			System.out.println("Sending Data");
		}
		catch(IOException ioe) {
			System.err.println("ERROR: Could not send data");
		}
	}
	
	public void setDataToSendClient(ClackData dataToSendToClient) {
		this.dataToSendToClient = dataToSendToClient;
	}
	
	public String getUserName() {
		return this.clientUserName;
	}
}
