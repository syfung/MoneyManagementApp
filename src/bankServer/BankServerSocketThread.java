package bankServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class BankServerSocketThread implements Runnable {

	ServerSocket ServerSocket;
	ArrayList<Thread> threadList = new ArrayList<Thread>();

	public BankServerSocketThread(ServerSocket ServerSocket) {
		super();
		this.ServerSocket = ServerSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Socket clientSocket = null;
		while (Thread.interrupted() == false) {
			try {
				this.ServerSocket.setSoTimeout(1);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				clientSocket = this.ServerSocket.accept();
			} catch (SocketTimeoutException e) {
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (clientSocket != null) {
				BankServerThread inConnection = new BankServerThread(clientSocket);
				Thread t = new Thread(inConnection);
				t.start();
				this.threadList.add(t);
			}
		}
		for(Thread t : this.threadList) {
			System.out.println("interrupt " + t);
			t.interrupt();
		}
		try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			
		}
		System.out.println("BankServerSocketThread exited");
		return;
	}

}
