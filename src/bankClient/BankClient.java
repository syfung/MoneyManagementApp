package bankClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BankClient {

	public static void main(String[] args) {
		if (args.length == 2) {
			String hostName = args[0];
			int portNumber = Integer.valueOf(args[1]);
			try {
				Socket socket = new Socket(hostName, portNumber);
				System.out.println("Got connection");
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				Scanner reader = new Scanner(System.in); // Reading from System.in
				String outStr;
				while ((outStr = reader.nextLine()).equals("exit") == false) {
					out.println(outStr);
				}
				out.close();
				in.close();
				socket.close();
				reader.close();
			} catch (IOException e) {
			}

		} else {
			System.out.println("Useage: BankServer hostName port");
		}
	}

}
