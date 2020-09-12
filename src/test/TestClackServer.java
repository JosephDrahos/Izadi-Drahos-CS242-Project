package test;

import main.ClackServer;

/**
 * This tests every case for the ClackServer class
 * 
 * @author Rod Izadi & Joseph Drahos
 *
 */

public class TestClackServer {
	/**
	 * 
	 * Allows to take in command line arguments and tests cases for ClackServer Class 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Runs various test cases for each function of ClackServer Class
		 */
		ClackServer testServer = new ClackServer(1200); //Inputs 1200 for port number 
		ClackServer testServer2 = new ClackServer();	//Runs ClackServer constructor with no input
		
		ClackServer testServer3 = new ClackServer(-2000); //Testing for negative input port
				
		
		System.out.println(testServer.equals(testServer2));	//Tries equals method while not equal
		testServer = testServer2;							//Sets testServer to testServer2
		System.out.println(testServer.equals(testServer2));	//Tries equals method while equal
		
		//Runs toString for all test cases
		System.out.println(testServer.toString());			
		System.out.println(testServer2.toString());			
		System.out.println(testServer3.toString());
		
	}
}
