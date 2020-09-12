package data;

/**
 * Represents data from ClackData as a message
 * inherits ClackData variables and methods
 * @author Rod Izadi & Joseph Drahos
 *
 */
public class MessageClackData extends ClackData{
	private String message;	//String representing instant message
	
	/**
	 * Constructor which calls super constructor from ClackData
	 * @param userName: inherited from ClackData
	 * @param message: inherited from ClackData
	 * @param type: inherited from ClackData
	 */
	public MessageClackData(String userName, String message, int type){
		super(userName, type);
		this.message = message;
	}
	
	/**
	 * Overloaded previous method with no arguments
	 */
	public MessageClackData(){
		super();
		this.message = null;
	}
	
	/**
	 * @returns message data
	 */
	@Override
	public String getData() {
		return this.message;
	}
	
	/**
	 * Overrides default hashCode function to give unique hashCode for every messageClackData object
	 * @returns hashCode number
	 */
	@Override
	public int hashCode() {
		return (int) ((Math.random() * ( 300000-1)) + 1);
	}
	
	/**
	 * Overrides default equals method and compares all variables in a messageClackData object to check equivalence
	 * @returns true or false
	 */
	@Override
	public boolean equals(Object other) {
		MessageClackData otherData = (MessageClackData) other;
		return this.message == otherData.getData() && this.userName == otherData.userName && this.getType() == otherData.getType();
	}
	
	/**
	 * Overrides toString method to outputs strings of all messageClackData data
	 * returns string of object data
	 */
	@Override
	public String toString() {
		String output;
		output = "Username: " + super.userName + "\n" + "Type: " + getType() + "\n" + "Date: " + getDate() + "\n" + "Message: " + this.message + "\n";
		return output;
	}
}
