package main;

public class ClientSideServerListener implements Runnable{
	private ClackClient client;
	
	/**
	 * ClientSideServerListener constructor
	 * 
	 * @param client
	 */
	ClientSideServerListener(ClackClient client){
		this.client = client;
	}
	
	/**
	 * Thread run function
	 */
	@Override
	public void run() {
		while(!client.checkConnection()) {
			try {
				client.receiveData();
				client.printData();
			}catch (Exception e) {
				
			}
		}
	}

}
