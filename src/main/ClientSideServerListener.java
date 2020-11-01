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
		while(client.checkConnection() == false) {
			
				//System.out.println("Receiving Data");
			client.receiveData();
			client.printData();
				//Thread.sleep(1000);
			
			
		}
		System.out.println("Listener closed");
	}

}
