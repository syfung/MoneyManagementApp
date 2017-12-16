package moneyServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class MoneyServerSocketThread implements Runnable {

	ServerSocket ServerSocket;
	ArrayList<Thread> threadList = new ArrayList<Thread>();

	public MoneyServerSocketThread(ServerSocket ServerSocket) {
		super();
		this.ServerSocket = ServerSocket;
	}

	@Override
	public void run() {
		Socket clientSocket = null;
		while (Thread.interrupted() == false) {
			try {
				this.ServerSocket.setSoTimeout(1);
			} catch (SocketException e) {
				e.printStackTrace();
			}
			
			try {
				clientSocket = this.ServerSocket.accept();
			} catch (SocketTimeoutException e) {
				continue;
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (clientSocket != null) {
				MoneyServerThread inConnection = new MoneyServerThread(clientSocket);
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
			this.ServerSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			
		}
		System.out.println("BankServerSocketThread exited");
		return;
	}

}
