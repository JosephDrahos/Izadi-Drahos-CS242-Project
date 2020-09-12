package test;

import main.ClackClient;
/**
 * This tests every case for the ClackClient class
 * 
 * @author Rod Izadi & Joseph Drahos
 *
 */
public class TestClackClient {
	/**
	 * Takes command line arguments which there none of
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Runs all test cases for ClackClient
		 */
		ClackClient testClient = new ClackClient("Test Name", "Host Name", 1200);	//sets test case with username, hostName, and port number
		ClackClient testClient2 = new ClackClient("Test Name2", "Host Name2");		//sets test case with userName, hostName, and port Number
		ClackClient testClient3 = new ClackClient("Test Name3");					//sets test case with username
		ClackClient testClient4 = new ClackClient();								//sets test case with no arguments
		
		//Runs ClackClient functions for testClient
		System.out.println(testClient.getUserName());
		System.out.println(testClient.toString());
		System.out.println(testClient.getHostName());
		System.out.println(testClient.getPort());

		//Runs ClackClient functions for testClient2
		System.out.println(testClient2.getUserName());
		System.out.println(testClient2.toString());
		System.out.println(testClient2.getHostName());
		System.out.println(testClient2.getPort());
		
		//Runs ClackClient functions for testClient3		
		System.out.println(testClient3.getUserName());
		System.out.println(testClient3.toString());
		System.out.println(testClient3.getHostName());
		System.out.println(testClient3.getPort());
		
		//Runs ClackClient functions for testClient4
		System.out.println(testClient4.getUserName());
		System.out.println(testClient4.toString());
		System.out.println(testClient4.getHostName());
		System.out.println(testClient4.getPort());
		
		//Runs equals method for testClient against testClient2 first as not equal and then as equal
		System.out.println(testClient.equals(testClient2));
		testClient = testClient2;
		System.out.println(testClient.equals(testClient2));
		
	}
}
