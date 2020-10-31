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
			try {
				//System.out.println("Receiving Data");
				client.receiveData();
				client.printData();
				//Thread.sleep(1000);
			}catch (Exception e) {
				System.err.println("Listener error" + e.getMessage());
			}
		}
		System.out.println("Listener closed");
	}

}
