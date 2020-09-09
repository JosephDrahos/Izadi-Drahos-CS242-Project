package data;

import java.util.Date;


public abstract class ClackData {
	protected String userName;
	private int type;
	protected Date date;
	
	public final static int CONSTANT_LISTUSERS = 0;
	public final static int CONSTANT_LOGOUT = 1;
	public final static int CONSTANT_SENDMESSAGE = 2;
	public final static int CONSTANT_SENDFILE = 3;
	
	
	ClackData(String userName, int type){
		this.userName = userName;
		this.type = type;
		this.date = new Date();
	}
	
	ClackData(int type){
		this("Anon",type);
	}
	
	ClackData(){
		this(CONSTANT_LOGOUT);
	}
	
	public int getType() {
		return this.type;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public abstract String getData();
}
