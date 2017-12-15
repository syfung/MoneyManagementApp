package bankServer;

import java.net.Socket;

public class BankServerThread implements Runnable {
	Socket clientSocket;
	
	public BankServerThread(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
