package test;

import data.*;

public class TestClackData {
	public static void main(String[] args) {
		
		MessageClackData testMessage = new MessageClackData("Test Name","Message Test",0);
		MessageClackData testMessage2 = new MessageClackData();
		
		MessageClackData testMessage3 = new MessageClackData( null, "BeeBop", 0 );
		
		System.out.println(testMessage.getData());
		System.out.println(testMessage2.toString());
		System.out.println(testMessage.equals(testMessage2));
		testMessage2 = testMessage;
		System.out.println(testMessage.equals(testMessage2));
		System.out.println(testMessage.toString());
		
		FileClackData testFile = new FileClackData("DrahosIzadi","Test File",2);
		FileClackData testFile2 = new FileClackData();
		
		
		System.out.println(testFile.getData());
		testFile.setFileName("New Name");
		System.out.println(testFile.getFileName());
		System.out.println(testFile2.getFileName());
		System.out.println(testFile.equals(testFile2));
		testFile2 = testFile;
		System.out.println(testFile.equals(testFile2));
		System.out.println(testFile.toString());
		
		System.out.println(testMessage3.toString());
	}
}
