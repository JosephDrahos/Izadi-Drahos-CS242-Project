package data;
/**
 * Represents data from ClackData as the name and contents of a file
 * Inherits variables and methods from ClackData
 * @author Joseph Drahos & Rod Izadi
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
	 * @returns Name of file
	 */
	public String getFileName() {
		return this.fileName;
	}
	/**
	 * @returns file Contents
	 */
	@Override
	public String getData() {
		return this.fileContents;
	}
	
	/**
	 * Reads File Contents
	 * WILL IMPLEMENT LATER
	 */
	public void readFileContents() {
		
	}
	
	/**
	 * Writes File Contents
	 * WILL IMPLEMENT LATER
	 */
	public void writeFileContents() {
		
	}
	
	/**
	 * Overrides default hashCode function to give unique hashCode for every fileClackData object
	 * @returns hashCode number
	 */
	@Override
	public int hashCode() {
		return (int) ((Math.random() * ( 300000-1)) + 1);
	}
	
	/**
	 * Overrides default equals method and compares all variables in a fileClackData object to check equivalence
	 * @returns true or false
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


