package test;

import main.ClackClient;

public class TestClackClient {
	public static void main(String[] args) {
		ClackClient testClient = new ClackClient("Test Name", "Host Name", 1200);
		ClackClient testClient2 = new ClackClient("Test Name2", "Host Name2");
		ClackClient testClient3 = new ClackClient("Test Name3");
		ClackClient testClient4 = new ClackClient();
		
		System.out.println(testClient.getUserName());
		System.out.println(testClient.toString());
		System.out.println(testClient.getHostName());
		System.out.println(testClient.getPort());
		
		System.out.println(testClient2.getUserName());
		System.out.println(testClient2.toString());
		System.out.println(testClient2.getHostName());
		System.out.println(testClient2.getPort());
		
		System.out.println(testClient3.getUserName());
		System.out.println(testClient3.toString());
		System.out.println(testClient3.getHostName());
		System.out.println(testClient3.getPort());
		
		System.out.println(testClient4.getUserName());
		System.out.println(testClient4.toString());
		System.out.println(testClient4.getHostName());
		System.out.println(testClient4.getPort());
		
		System.out.println(testClient.equals(testClient2));
		testClient = testClient2;
		System.out.println(testClient.equals(testClient2));
		
	}
}
