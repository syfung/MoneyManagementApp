package bankServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BankServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 1) {
			int portNumber = Integer.valueOf(args[0]);

			try {
				ServerSocket serverSocket = new ServerSocket(portNumber);
				while(true) {
					Socket clientSocket = serverSocket.accept();
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Useage: BankServer hostName port");
		}

	}

}
