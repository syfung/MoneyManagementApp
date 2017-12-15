package bankServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class BankServerSocketThread implements Runnable {

	ServerSocket ServerSocket;

	public BankServerSocketThread(ServerSocket ServerSocket) {
		super();
		this.ServerSocket = ServerSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (Thread.interrupted() == false) {
			try {
				this.ServerSocket.setSoTimeout(1);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Socket clientSocket = null;
			try {
				clientSocket = this.ServerSocket.accept();
			} catch (SocketTimeoutException e) {

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (clientSocket != null) {
				BankServerThread inConnection = new BankServerThread(clientSocket);
				new Thread(inConnection).start();
			}
		}
		System.out.println("BankServerSocketThread exited");
		return;
	}

}
