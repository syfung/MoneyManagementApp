package bankServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		try {
			PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			String inStr;
			out.println("Your are connected to the server the first time");
			while (Thread.interrupted() == false) {
				if (in.ready()) {
					inStr = in.readLine();
					if (inStr != null) {
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
