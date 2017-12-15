package bankServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class BankServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 1) {
			int portNumber = Integer.valueOf(args[0]);
			//Thread CommandListner = new Thread(new BankServerCommandThread());
			ServerSocket ServerSocket;
			try {
				ServerSocket = new ServerSocket(portNumber);
				Thread SocketListner = new Thread(new BankServerSocketThread(ServerSocket));
				//CommandListner.start();
				SocketListner.start();
				Scanner reader = new Scanner(System.in); // Reading from System.in
				String inStr;
				System.out.print("BankApp@localhos :");
				System.out.flush();
				while ((inStr = reader.nextLine()).startsWith("q") == false) {
					System.out.print("BankApp@localhos :");
					System.out.flush();
					System.out.println(inStr);
				}
				System.out.println("Exiting");
				SocketListner.interrupt();
				reader.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} else {
			System.out.println("Useage: BankServer port");
		}
		return;

	}

}
