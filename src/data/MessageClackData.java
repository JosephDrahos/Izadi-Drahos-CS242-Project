package data;


public class MessageClackData extends ClackData{
	private String message;
	
	public MessageClackData(String userName, String message, int type){
		super(userName, type);
		this.message = message;
	}
	
	public MessageClackData(){
		super();
		this.message = null;
	}
	
	@Override
	public String getData() {
		return this.message;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		String user = super.userName;
		
		for(int i = 0; i < user.length(); i++) {
			hash = hash * (int) user.charAt(i);
		}
		
		return hash;
	}
	
	@Override
	public boolean equals(Object other) {
		MessageClackData otherData = (MessageClackData) other;
		return this.message == otherData.getData() && this.userName == otherData.userName && this.getType() == otherData.getType();
	}
	
	@Override
	public String toString() {
		String output;
		output = "Username: " + super.userName + "\n" + "Type: " + getType() + "\n" + "Date: " + getDate() + "\n" + "Message: " + this.message + "\n";
		return output;
	}
}
