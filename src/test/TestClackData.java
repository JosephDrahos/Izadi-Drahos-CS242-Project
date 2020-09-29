package test;
import java.io.*;
import data.*;
/**
 * This tests every case for the ClackData class
 * 
 * @author Rod Izadi  Joseph Drahos
 *
 */
public class TestClackData {
	/**
	 * Takes command line arguments which there none of
	 * @param list of user input strings args
	 */
	public static void main(String[] args) {
		/**
		 * Runs test cases for ClackData
		 */
		MessageClackData testMessage = new MessageClackData("Test Name","Brave New World","TIME",1);	//Sets test case for message with arguments filled
		MessageClackData testMessage1 = new MessageClackData("TypeTest2", "TypeTest2", "Burger", 2);
		MessageClackData testMessage2 = new MessageClackData();								//Sets test case for message with no arguments
		
		MessageClackData testMessage3 = new MessageClackData( null, "BeeBop", 3 );			//Sets test case with null username
		
		//Runs getData method for message test cases
		System.out.println(testMessage.getData());
		System.out.println(testMessage.getData("TIME"));
		System.out.println(testMessage1.getData());
		System.out.println(testMessage3.getData());
		System.out.println(testMessage2.getData());
		
		//Runs toString method message for test cases
		System.out.println(testMessage.toString());
		System.out.println(testMessage2.toString());
		System.out.println(testMessage3.toString());
		
		//Runs equals method for testMessage against testMessage2, first with them not equal and then them equal
		System.out.println(testMessage.equals(testMessage2));
		testMessage2 = testMessage;
		System.out.println(testMessage.equals(testMessage2));
		
		
		FileClackData testFile = new FileClackData("DrahosIzadi","Test File",2);	//Sets test case for file with arguments filled
		FileClackData testFile1 = new FileClackData("Part 2 Test","Part2_Document.txt",2);
		FileClackData testFile2 = new FileClackData();								//Sets test case for file with arguments empty
		
		//Runs getData method for file test cases
		System.out.println(testFile.getData());
		System.out.println(testFile2.getData());
		
		testFile.setFileName("New Name");	//Runs the setFileName method for testFile
		
		//Runs getFileName method for file test cases
		System.out.println(testFile.getFileName());
		System.out.println(testFile2.getFileName());
		
		//Runs equals method for testFile against testFile2 with them being not equal and then equal
		System.out.println(testFile.equals(testFile2));
		testFile2 = testFile;
		System.out.println(testFile.equals(testFile2));
		
		//Runs toString method for file test cases
		System.out.println(testFile.toString());
		System.out.println(testFile2.toString());
		System.out.println(testFile1.toString());
		
		
		
	}
}
