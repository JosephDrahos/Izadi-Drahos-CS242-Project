package main;

public class ClientSideServerListener implements Runnable{
	private ClackClient client;
	
	ClientSideServerListener(ClackClient client){
		this.client = client;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			client.receiveData();
			client.sendData();
		}
	}

}
