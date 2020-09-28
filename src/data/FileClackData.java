package data;
import java.io.*;
/**
 * Represents data from ClackData as the name and contents of a file
 * Inherits variables and methods from ClackData
 * @author Joseph Drahos  Rod Izadi
 *
 */
public class FileClackData extends ClackData{
	private String fileName;		//String representing name of file
	private String fileContents;	//String representing contents of file
	
	/**
	 * Constructor to set up Username, File Name, and type
	 * @param userName inherited from ClackData
	 * @param fileName: name of file(Automatically set to Null)
	 * @param type: inherited from ClackData
	 */
	public FileClackData(String userName, String fileName, int type){
		super(userName, type);
		this.fileName = fileName;
		this.fileContents = null;
	}
	
	/**
	 * Overloaded previous constructor with fileName set to Null as well as fileContents
	 */
	public FileClackData(){
		super();
		this.fileName = null;
		this.fileContents = null;
	}
	
	/**
	 * Sets fileName
	 * @param fileName:Name of file
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	/**
	 * 
	 * @return Name of file
	 */
	public String getFileName() {
		return this.fileName;
	}
	
	/**
	 * @return decrypted file contents
	 */
	@Override
	public String getData(String key) {
		return decrypt(this.fileContents, key);
	}
	/**
	 * @return file Contents
	 */
	@Override
	public String getData() {
		return this.fileContents;
	}
	
	/**
	 * Instantiates fileContents by readying the contents of this.fileName
	 * @throws file not found Exception
	 */
	public void readFileContents() throws IOException {
		try {
			BufferedReader br = new BufferedReader( new FileReader(this.fileName));
			String nextLine = new String();
			while( (nextLine = br.readLine()) != null) {
				this.fileContents += nextLine;
			}
			br.close();
		}catch (FileNotFoundException fnfe) {
			System.err.println("File" + this.fileName + "does not exist");
			throw new IOException();
		}
		
	}
	
	/**
	 * Instantiates fileContents by readying the contents of this.fileName and encrypting the data
	 * @param ecryption key
	 * @throws IOException
	 */
	public void readFileContents(String key) throws IOException {
		try {
			BufferedReader br = new BufferedReader( new FileReader(this.fileName));
			String nextLine = new String();
			while( (nextLine = br.readLine()) != null) {
				this.fileContents += nextLine;
			}
			this.fileContents = encrypt(this.fileContents, key);
			br.close();
		}catch (FileNotFoundException fnfe) {
			System.err.println("File" + this.fileName + "does not exist");
			throw new IOException();
		}
		
	}
	
	/**
	 * Writes File Contents
	 * WILL IMPLEMENT LATER
	 */
	public void writeFileContents() {
		try {
			FileWriter writer = new FileWriter(this.fileName);
			writer.write(this.fileContents);
			writer.close();
		}catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
	
	public void writeFileContents(String key) {
		try {
			FileWriter writer = new FileWriter(this.fileName);
			writer.write(decrypt(this.fileContents, key));
			writer.close();
		}catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
	/**
	 * Overrides default hashCode function to give unique hashCode for every fileClackData object
	 * @return hashCode number
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + fileName.hashCode();
		hash = 31 * hash + fileContents.hashCode();
		hash = 31 * hash + userName.hashCode();
		return hash;
	}
	
	/**
	 * Overrides default equals method and compares all variables in a fileClackData object to check equivalence
	 * @return true or false
	 */
	@Override
	public boolean equals(Object other) {
		FileClackData otherData = (FileClackData) other;
		return this.userName == otherData.userName && this.getType() == otherData.getType() && this.fileName == otherData.fileName && this.fileContents == otherData.fileContents;
	}
	
	/**
	 * Overrides toString method to outputs strings of all fileClackData data
	 * returns string of object data
	 */
	@Override
	public String toString() {
		String output;
		output = "Username: " + super.userName + "\n" + "Type: " + getType() + "\n" + "Date: " + getDate() + "\n" + "File Name: " + this.fileName + "\n" + "File Contents: " + this.fileContents + "\n";
		return output;
	}
}


