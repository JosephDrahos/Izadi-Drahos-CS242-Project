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
			this.outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
			this.inFromClient = new ObjectInputStream(clientSocket.getInputStream());
			
			while(!clientSocket.isClosed() && !this.closeConnection) {
				receiveData();
				server.broadcast(dataToReceiveFromClient);
				//Thread.sleep(1000);
			}
			System.out.println("Removing " + this);
			server.remove(this);
			
		}catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
	
	public void receiveData() {
		try { 
			dataToReceiveFromClient = (ClackData) inFromClient.readObject();
			this.clientUserName = dataToReceiveFromClient.getUserName();
		
			if(dataToReceiveFromClient.getType() == 1) {
				this.closeConnection = true;
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
			//message with listuser type
			if(dataToSendToClient.getType() == 0) {
				dataToSendToClient = new MessageClackData("Server",server.getUserList(),3);
				System.out.println(dataToSendToClient.toString());
			}else if(dataToSendToClient.getType() == 1) {
				dataToSendToClient = null;
			}else {
				System.out.println(dataToSendToClient.toString());
			}
			
			outToClient.writeObject(dataToSendToClient);
			outToClient.flush();
		}
		catch(IOException ioe) {
			System.err.println("ERROR: Could not send data");
		}
	}
	
	public void setDataToSendClient(ClackData dataToSendToClient) {
		this.dataToSendToClient = dataToSendToClient;
	}
	
	public int getReceivedDataType() {
		if(dataToReceiveFromClient == null) {
			return -1;
		}
		return this.dataToReceiveFromClient.getType();
	}
	
	public String getUserName() {
		return this.clientUserName;
	}
}
