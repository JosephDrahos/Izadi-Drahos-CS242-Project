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
	 * This run function receives data from server and prints to client
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
