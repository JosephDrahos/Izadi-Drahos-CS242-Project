package data;

public class FileClackData extends ClackData{
	private String fileName;
	private String fileContents;
	
	public FileClackData(String userName, String fileName, int type){
		super(userName, type);
		this.fileName = fileName;
		this.fileContents = null;
	}
	
	public FileClackData(){
		super();
		this.fileName = null;
		this.fileContents = null;
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	@Override
	public String getData() {
		return this.fileContents;
	}
	
	public void readFileContents() {
		
	}
	
	public void writeFileContents() {
		
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
		FileClackData otherData = (FileClackData) other;
		return this.userName == otherData.userName && this.getType() == otherData.getType() && this.fileName == otherData.fileName && this.fileContents == otherData.fileContents;
	}
	
	@Override
	public String toString() {
		String output;
		output = "Username: " + super.userName + "\n" + "Type: " + getType() + "\n" + "Date: " + getDate() + "\n" + "File Name: " + this.fileName + "\n" + "File Contents: " + this.fileContents + "\n";
		return output;
	}
}


