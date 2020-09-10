package data;

/*

*/
public abstract class MessageClackData extends ClackData{
	private String message;
	
	MessageClackData(String userName, String message, int type){
		super(userName, type);
		this.message = message;
	}
	
	MessageClackData(){
		super();
		this.message = "NULL";
	}
	
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
		return this.hashCode() == otherData.hashCode();
	}
}
