package main;

public class ClientSideServerListener implements Runnable{
	private ClackClient client;
	
	ClientSideServerListener(ClackClient client){
		this.client = client;
	}
	
	@Override
	public void run() {
		ClackClient check = client;
		while(client.equals(check)) {
			client.receiveData();
			client.printData();
		}
	}

}
