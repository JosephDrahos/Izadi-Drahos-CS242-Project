package data;

import java.util.Date;

/**
 * This class represents the data sent between the client and the server.
 * @author Joseph Drahos  Rod Izadi
 *
 */

public class ClackData {
	protected String userName;	//String representing name of client user
	protected int type;			//represents the kind of data exchanged between the client and the server
	protected Date date;		//Date object representing date when ClackData object was created
	
	public final static int CONSTANT_LISTUSERS = 0;		//give a listing of all users connected to this session
	public final static int CONSTANT_LOGOUT = 1;		//log out, i.e., close this client’s connection
	public final static int CONSTANT_SENDMESSAGE = 2;	//send a message
	public final static int CONSTANT_SENDFILE = 3;		//send a file
	
	/**
	 * Constructor which sets up UserName and type, the date is automatically generated here
	 * @param userName: username of user
	 * @param type: sets data type being exchanged
	 */
	ClackData(String userName, int type){
		this.userName = userName;
		this.type = type;
		this.date = new Date();	//sets date to date of when constructor is called
			
	}
	
	/**
	 * Overloaded previous constructor which sets up userName and type, the date is automatically generated here
	 * Username is automatically set to "Anon"
	 * @param type: sets data type being exchanged
	 */
	ClackData(int type){
		this("Anon",type);
	}
	
	/**
	 * Overloaded previous constructor which logs out user
	 */
	ClackData(){
		this(CONSTANT_LOGOUT);
	}
	
	/**
	 * 
	 * @return type of ClackData data type
	 */
	public int getType() {
		return this.type;
	}
	
	/**
	 * 
	 * @return Username of ClackData data type
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * 
	 * @return date of when ClackData data type was made
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * 
	 * @param key
	 * @return encrypted data
	 */
	public String getData(String key) {
		return encrypt("Data",key);
	}
	/**
	 * 
	 * @return Data as "Data"
	 */
	public String getData() {
		return "Data";
	}
	
	
	/**
	 * Used to encrypt text using Vignere Cipher method. With a given key which is used to encrypt a string of text.
	 * Will return encrypted text as variable "out"
	 * @param inputString
	 * @param key
	 * @return out
	 */
	protected String encrypt( String inputString, String key) {
		String keystr = new String();
		int len = inputString.length();
		
		int keyindex = 0;
		for(int i = 0; i < len; i++) {							//For loop creates Keystring by mapping each letter of input string to key letter
			if(inputString.charAt(i) == ' ') {
				keystr += ' ';
			}else {
				keystr += key.charAt(keyindex % key.length());
				keyindex++;
			}
		}
		String out = new String();
		String abc = "abcdefghijklmnopqrstuvwxyz";	//Alphabet string
		
		for(int i = 0; i < len; i++) {
			if(inputString.charAt(i) == ' ') {
				out += ' ';
			} else if (Character.isLowerCase(inputString.charAt(i))) {
				out += Character.toLowerCase(abc.charAt(((int)Character.toUpperCase(inputString.charAt(i)) + (int)keystr.charAt(i)) % 26));
			}else {
				out += Character.toUpperCase(abc.charAt(((int)inputString.charAt(i) + (int)keystr.charAt(i)) % 26));
			}
		}


		return out;
	}
	
	/**
	 * When passed inputString and correct key will decrypt encrypted inputString and return it as the variable out
	 * @param inputString
	 * @param key
	 * @return out
	 */
	public String decrypt( String inputString, String key) {
		int len = inputString.length();	
		String keystr = new String();
		int keyindex = 0;
		
		for(int i = 0; i < len; i++) {				//makes keystring based off of given key and input string
			if(inputString.charAt(i) == ' ') {
				keystr += ' ';
			}else {
				keystr += key.charAt(keyindex % key.length());
				keyindex++;
			}
		}
		
		
		String out = new String();
		for(int i = 0; i < len; i++) {		//For loop reverses Vignere Cipher and makes keystring into legible string. 
			if(inputString.charAt(i) == ' ') {
				out += ' ';
			} else if (Character.isLowerCase(inputString.charAt(i))) {
				if((int)inputString.charAt(i) - (int)Character.toLowerCase(keystr.charAt(i)) >= 0) {
					out += (char)((int)inputString.charAt(i) - (int)Character.toLowerCase(keystr.charAt(i)) + 97);
				}else {
					out += (char)(((int)inputString.charAt(i) - (int)Character.toLowerCase(keystr.charAt(i)) + 26)+ 97);
				}
			}else {
				if((int)inputString.charAt(i) - (int)keystr.charAt(i) >= 0) {
					out += (char)((int)inputString.charAt(i) - (int)keystr.charAt(i) + 65);
				} else {
					out += (char)(((int)inputString.charAt(i) - (int)keystr.charAt(i) + 26)+ 65);
				}
			}
		}
		
		return out;
	}
}
