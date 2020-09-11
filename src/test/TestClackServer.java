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
	 * This main method allows 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClackServer testServer = new ClackServer(1200);
		ClackServer testServer2 = new ClackServer();
		
		ClackServer testServer3 = new ClackServer(-2000); //Testing for negative input port
				
		
		System.out.println(testServer.equals(testServer2));
		testServer = testServer2;
		System.out.println(testServer.equals(testServer2));
		
		System.out.println(testServer.toString());
		System.out.println(testServer2.toString());
		
		System.out.println(testServer3.toString());
		
	}
}
