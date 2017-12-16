package moneyServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MoneyServerThread implements Runnable {
	Socket clientSocket;

	public MoneyServerThread(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			String inStr;
			out.println("Your are connected to the server the first time");
			while (Thread.interrupted() == false) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					break;
				}
				if (in.ready()) {
					inStr = in.readLine();
					if (inStr != null && !inStr.isEmpty()) {
						System.out.println(inStr);
						out.println("Your are connected to the server");
					}
				}
			}
			in.close();
			out.close();
			this.clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
