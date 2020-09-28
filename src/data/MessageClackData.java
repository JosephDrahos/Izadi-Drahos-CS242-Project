package data;

/**
 * Represents data from ClackData as a message
 * inherits ClackData variables and methods
 * @author Rod Izadi  Joseph Drahos
 *
 */
public class MessageClackData extends ClackData{
	private String message;	//String representing instant message
	
	/**
	 * Constructor which calls super constructor and stores message as encrypted message
	 * @param userName
	 * @param message
	 * @param key
	 * @param type
	 */
	public MessageClackData(String userName, String message, String key, int type) {
		super(userName, type);
		this.message = encrypt(message, key);
	}
	
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
	 * @return decrypted message
	 */
	@Override
	public String getData(String key) {
		return decrypt(this.message, key);
	}
	
	/**
	 * @return message data
	 */
	@Override
	public String getData() {
		return this.message;
	}
	
	/**
	 * Overrides default hashCode function to give unique hashCode for every messageClackData object
	 * @return hashCode number
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + message.hashCode();
		hash = 31 * hash + userName.hashCode();
		return hash;
	}
	
	/**
	 * Overrides default equals method and compares all variables in a messageClackData object to check equivalence
	 * @return true or false
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
