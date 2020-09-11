package test;

import data.*;

public class TestClackData {
	public static void main(String[] args) {
		
		MessageClackData testMessage = new MessageClackData("Test Name","Message Test",0);
		MessageClackData testMessage2 = new MessageClackData();

		System.out.println(testMessage.getData());
		System.out.println(testMessage2.toString());
		testMessage2 = testMessage;
		System.out.println(testMessage.equals(testMessage2));
		System.out.println(testMessage.toString());
		
		FileClackData testFile = new FileClackData("DrahosIzadi","Test File",2);
		System.out.println(testFile.getData());
		testFile.setFileName("New Name");
		System.out.println(testFile.getFileName());
		FileClackData testFile2;
		testFile2 = testFile;
		System.out.println(testFile.equals(testFile2));
		System.out.println(testFile.toString());
		
	}
}
