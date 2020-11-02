package main;

import data.ClackData;

import java.io.*;
import java.lang.Math;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class is a blueprint for a ClackServer object that contains information about the port number that clients connect to
 * @author Rod Izadi Joseph Drahos
 *
 */
public class ClackServer {
	private int port;							//integer representing port number on server connected to
	private boolean closeConnection;			//boolean representing whether connection is closed or not
	private ArrayList<ServerSideClientIO> serverSideClientIOList;
	//private ClackData dataToSendToClient;		//ClackData object representing data received from the client
	//private ClackData dataToReceiveFromClient;	//ClackData object representing data sent to client
	//private ObjectOutputStream outToClient;		// The way ClackClient sends data packets
	//private ObjectInputStream inFromClient;		// The way ClackClient receives data packets
	
	/**
	 * constructor that sets port number
	 * @param port: integer representing port number
	 */
	public ClackServer(int port) throws IllegalArgumentException{
		try{
			if(port < 1024) throw new IllegalArgumentException() ;
			this.port = port;
			this.closeConnection = false;
			this.serverSideClientIOList = new ArrayList<ServerSideClientIO>();
		}catch (IllegalArgumentException iae) {
			System.err.println("Error: Port cannot be less than 1024");
		}
	}
	
	/**
	 * Overloaded previous method setting port to default 7000
	 */
	public ClackServer(){
		this(7000);
	}
	
	/**
	 * Clack server start method
	 */
	public void start() {
		try {
			
			ServerSocket sskt = new ServerSocket(port);
			Socket clientSkt = sskt.accept();
			
			while(!closeConnection) {
				ServerSideClientIO ssci = new ServerSideClientIO(this,clientSkt);
				serverSideClientIOList.add(ssci);
				Thread ssciThread = new Thread(ssci);
				ssciThread.start();
				clientSkt = sskt.accept();
			}
			
			sskt.close();
			clientSkt.close();
		}catch (IOException ioe) {
			System.err.println(ioe.getMessage());
			//System.err.println("Server IO error");
		}
	}

	public synchronized void broadcast(ClackData dataToBroadCastToClients) {
		if(dataToBroadCastToClients.getType() == 0) {
			for(ServerSideClientIO x : serverSideClientIOList) {
				if(x.getReceivedDataType() == 0) {
					x.setDataToSendClient(dataToBroadCastToClients);
					x.sendData();
				}
			}
		}else {
			for(ServerSideClientIO x: serverSideClientIOList) {
				System.out.println(x);
				x.setDataToSendClient(dataToBroadCastToClients);
				x.sendData();
			}
		}
	}
	
	public synchronized void remove(ServerSideClientIO serverSideClientToRemove) {
		serverSideClientIOList.remove(serverSideClientToRemove);
	}
	
	public String getUserList() {
		String userList = "List Of Current Users: ";
		
		for(ServerSideClientIO x: serverSideClientIOList) {
			userList += x.getUserName() + " ";
		}
		
		return userList;
	}
	
	/*
	 * Overrides default hashCode function to give unique hashCode for every ClackServer object
	 * @return hashCode number
	 */	 
	 @Override
	public int hashCode() {
		return this.port;
	}
	
	/**
	 * Overrides default equals method and compares all variables in a ClackServer object to check equivalence
	 * @return true or false
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
			output = "Port: " + this.port + "\n" + "Closed Connection: " + this.closeConnection + "\n" + "Data to Send: " ;
			return output;
	}
	
	/**
	 * Main method to test the server side
	 * @param args
	 */
	public static void main(String[] args) {
		try {	
			if(args != null) {
				Scanner s = new Scanner(args[0]);
				ClackServer server;
				if(s.hasNextInt()) {
					server = new ClackServer(s.nextInt());
				}else {
					server = new ClackServer();
				}
				server.start();
				s.close(); 
			}
		}catch(IndexOutOfBoundsException iobe) {
			ClackServer server = new ClackServer();
			server.start();
		}
	}
}