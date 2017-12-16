package moneyServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class MoneyServer {

	public static void main(String[] args) {
		// Usage BankServer port number
		if (args.length == 1) {
			int portNumber = Integer.valueOf(args[0]);

			// Open Socket and hand the accepting to a thread
			ServerSocket ServerSocket;
			try {
				ServerSocket = new ServerSocket(portNumber);
				Thread SocketListner = new Thread(new MoneyServerSocketThread(ServerSocket));
				SocketListner.start();

				// While taking in put from the command pomp
				Scanner reader = new Scanner(System.in); // Reading from
															// System.in
				String inStr;
				System.out.print("BankApp@localhos :");
				System.out.flush();
				while ((inStr = reader.nextLine()).equals("exit") == false) {
					System.out.print("BankApp@localhos :");
					System.out.flush();
					System.out.println(inStr);
				}
				System.out.println("Exiting");

				SocketListner.interrupt();
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			// Usage
		} else {
			System.out.println("Useage: BankServer port");
		}
	}

}
