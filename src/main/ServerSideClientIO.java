package main;

import java.io.*;
import data.ClackData;
import java.net.*;

public class ServerSideClientIO implements Runnable{
	private boolean closeConnection;
	private ClackData dataToReceiveFromClient;
	private ClackData dataToSendToClient;
	private ObjectInputStream inFromClient;
	private ObjectOutputStream outToClient;
	private ClackServer server;
	private Socket clientSocket;
	
	
	ServerSideClientIO(ClackServer server, Socket clientSocket){
		this.server = server;
		this.clientSocket = clientSocket;
		this.closeConnection = false;
		this.dataToReceiveFromClient = null;
		this.dataToSendToClient = null;
		this.inFromClient = null;
		this.outToClient = null;
	}


	@Override
	public void run() {
		try {
			while(!clientSocket.isClosed()) {
				outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
				inFromClient = new ObjectInputStream(clientSocket.getInputStream());
				receiveData();
				server.broadcast(dataToSendToClient);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void receiveData() {
		try {
			if(!clientSocket.isClosed()) {
				dataToReceiveFromClient = (ClackData) inFromClient.readObject();
				System.out.println(dataToReceiveFromClient.toString());
			}else {
				server.remove(this);
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
		}
		catch(IOException ioe) {
			System.err.println("ERROR: Could not send data");
		}
	}
	
	public void setDataToSendClient(ClackData dataToSendToClient) {
		this.dataToSendToClient = dataToSendToClient;
	}
}
