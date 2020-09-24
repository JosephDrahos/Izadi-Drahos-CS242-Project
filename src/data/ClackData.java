package data;

import java.util.Date;

/**
 * This class represents the data sent between the client and the server.
 * @author Joseph Drahos & Rod Izadi
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
	 * @returns type of ClackData data type
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
	 * @returns date of when ClackData data type was made
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
	 * @returns Data as "Data"
	 */
	public String getData() {
		return "Data";
	}
	
	
	/**
	 * TODO: Implement
	 * @param inputString
	 * @param key
	 * @return
	 */
	protected String encrypt( String inputString, String key) {
		String keystr = new String();
		int len = inputString.length();
		
		int keyindex = 0;
		for(int i = 0; i < len; i++) {
			if(inputString.charAt(i) == ' ') {
				keystr += ' ';
			}else {
				keystr += key.charAt(keyindex % key.length());
				keyindex++;
			}
		}
		String out = new String();
		String abc = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i = 0; i < len; i++) {
			if(inputString.charAt(i) == ' ') {
				out += ' ';
			} else if (Character.isLowerCase(inputString.charAt(i))) {
				out += abc.charAt(((int)inputString.charAt(i) + (int)keystr.charAt(i)) % 26);
			}else {
				out += Character.toUpperCase(abc.charAt(((int)inputString.charAt(i) + (int)keystr.charAt(i)) % 26));
			}
		}
		return out;
	}
	
	/**
	 * TODO: Implement
	 * @param inputString
	 * @param key
	 * @return
	 */
	protected String decrypt( String inputString, String key) {
		int len = inputString.length();
		String keystr = new String();
		int keyindex = 0;
		
		for(int i = 0; i < len; i++) {
			if(inputString.charAt(i) == ' ') {
				keystr += ' ';
			}else {
				keystr += key.charAt(keyindex % key.length());
				keyindex++;
			}
		}
		
		System.out.println(keystr);
		String out = new String();
		for(int i = 0; i < len; i++) {
			if(inputString.charAt(i) == ' ') {
				out += ' ';
			} else if (Character.isLowerCase(inputString.charAt(i))) {
				if((int)inputString.charAt(i) - (int)keystr.charAt(i) >= 0) {
					out += (char)((int)inputString.charAt(i) - (int)keystr.charAt(i) + 97);
				}else {
					out += (char)(((int)inputString.charAt(i) - (int)keystr.charAt(i) + 26)+ 97);
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
