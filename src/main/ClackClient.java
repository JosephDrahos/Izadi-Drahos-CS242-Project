package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import data.*;
import java.net.*;
import java.util.ArrayList;
/**
 * This class represents the client user
 * @author Joseph Drahos Rod Izadi
 *
 */
public class ClackClient {
	
	private String userName;					//String representing name of the client
	private String hostName;					//String representing name of the computer representing the server
	private int port;							//integer representing port number on server connected to
	private boolean closeConnection;			//boolean representing whether connection is closed or not
	private ClackData dataToSendToServer;		//ClackData object representing data sent to server
	private ClackData dataToReceiveFromServer;	//ClackData object representing data received from the server
	private Scanner inFromStd; 					// scanner for user input from system.in
	private ObjectOutputStream outToServer;		// The way ClackClient sends data packets
	private ObjectInputStream inFromServer;		// The way ClackClient receives data packets
	//private static final String KEY = "TIME";   //encryption key
	
	/**
	 * Constructor for username, host name, and port,connection is automatically set to open
	 * Data sent to server and recieved from server to null
	 * @param userName: name of user
	 * @param hostName: name of host
	 * @param port: port number for connection
	 */
	public ClackClient (String userName, String hostName, int port)throws IllegalArgumentException{
		try {
			if(userName == null || hostName == null || port < 1024) {
				throw new IllegalArgumentException();
			}
			this.userName = userName;
			this.hostName = hostName;
			this.port = port;
			this.closeConnection = false;
			this.outToServer = null;
			this.inFromServer = null;
			//this.dataToSendToServer = null;
			//this.dataToReceiveFromServer = null;
	
		}
		catch(IllegalArgumentException IAE){
			if(userName == null) {
				System.err.println("ERROR: USERNAME CANNOT BE NULL");
			}
			else if(hostName == null) {
				System.err.println("ERROR: HOSTNAME CANNOT BE NULL");
			}
			else if(port < 1024) {
				System.err.println("ERROR: PORT CANNOT BE LESS THAN 1024");
			}
		}
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
	 *Starts client's communication with the server
	 */
	public void start() {
		try {

			Socket skt = new Socket(hostName, port);
			
			inFromStd = new Scanner(System.in);
			inFromStd.useDelimiter("\r|\n");	
			
			ClientSideServerListener cssl = new ClientSideServerListener(this);
			Thread csslThread = new Thread(cssl);
			csslThread.start();
			
			while(!closeConnection) {
				outToServer = new ObjectOutputStream(skt.getOutputStream());
			
				readClientData();
				sendData();
				
				inFromServer = new ObjectInputStream(skt.getInputStream());
				//receiveData();
				//printData();
			}
			//dataToReceiveFromServer = dataToSendToServer; //temporary
			
			outToServer.close();
			inFromServer.close();
			inFromStd.close();
			skt.close();
		}	
		catch(Exception e) {
			System.err.println(e.getMessage());//	DONT FORGET EXCEPTION HANDLING
		}
		inFromStd.close();	
	}
	
	/**
	 * Method receives input form standard input and responds differently based on command. 
	 */
	public void readClientData() {
		System.out.print("Enter Command: ");
		String userIn = new String();
		
		try {
				userIn = inFromStd.nextLine();
				if(userIn.contains("DONE")) {
					this.closeConnection = true;
					System.out.println("Connection is Closed");
				}
				else if(userIn.contains("SENDFILE")) {
					String fileName = new String();
					if(inFromStd.hasNext()) {
						try {
							fileName = inFromStd.nextLine();
							BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
							FileClackData userFile = new FileClackData(this.userName,fileName,3);
							System.out.println("File " + fileName + " was read");
							bufferedReader.close();
						}
						catch(IOException IOE) {
							FileClackData userFile = new FileClackData();
							System.err.println("File " + fileName + " could not be read.");
						}
					}
				}
				else if(userIn.contains("LISTUSERS")) {
					ArrayList<ServerSideClientIO> serverSideClientIOList;
					
				}
				else {
					dataToSendToServer = new MessageClackData(this.userName, userIn ,3);
				}
		}
		catch(InputMismatchException ime) {
			System.err.println(ime.getMessage());
		}
		
	}

	
	
	/**
	 * This method receives an instance of clack data from the server
	 */
	public void receiveData() {
		try {
			if(true) {
				//dataToReceiveFromServer = (ClackServer) inFromServer.readObject();
			}
			
			dataToReceiveFromServer = (ClackData) inFromServer.readObject();
		}
		catch(IOException ioe) {
			System.err.println("ERROR: Could not receive data");
		}
		catch(ClassNotFoundException CNFE) {
			System.err.println("ERROR: Class was not found when recieving data");
		}
	}
	
	/**
	 * This method sends an instance of clack data to the server
	 */
	public void sendData() {
		try {
			outToServer.writeObject(dataToSendToServer);
		}
		catch(IOException ioe) {
			System.err.println("ERROR: Could not send data");
		}
	}
	
	/**
	 * This method prints out to all the clients the information sent by a particular user 
	 */
	public void printData() {
		System.out.println(dataToReceiveFromServer.getData());
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
	 * @return hashCode number
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + userName.hashCode();
		hash = 31 * hash + hostName.hashCode();
		return hash;
	}
	
	/**
	 * Overrides default equals method and compares all variables in a ClackClient object to check equivalence
	 * @return true or false
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
		output = "Username: " + this.userName + "\n" + "hostName: " + this.hostName + "\n" + "Port: " + getPort() + "\n" + "Closed Connection: " + this.closeConnection + "\n" + "Data to Send: " + this.dataToSendToServer + "\n" + "Data to Receive: " + this.dataToReceiveFromServer + "\n";
		return output;
	}
	
	/**
	 * Main method to test the client side 
	 */
	public static void main(String[] args) {		
		try {
			ClackClient user = new ClackClient();
			Scanner s = new Scanner(args[0]).useDelimiter("@|:");
			if(s.hasNext()) {
				String username = s.next();
				if(s.hasNext()) {					
					String hostname = s.next();
					if(s.hasNext()) {
						int port = s.nextInt();
						user = new ClackClient(username,hostname,port);
					}else {
						user = new ClackClient(username,hostname);
					}
				}else {
					user = new ClackClient(username);
				}
			}
			s.close();
			user.start();
		}catch (ArrayIndexOutOfBoundsException aioe) {
			ClackClient user = new ClackClient();
			user.start();
		}
			
		
	}
}

