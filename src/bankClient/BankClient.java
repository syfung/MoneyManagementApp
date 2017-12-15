package bankClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BankClient {

	public static void main(String[] args) {
		// This is a pull request test
		if (args.length == 2) {
			String hostName = args[0];
			int portNumber = Integer.valueOf(args[1]);
			try {
				Socket socket = new Socket(hostName, portNumber);
				System.out.println("Got connection");
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader localInStream = new BufferedReader(new InputStreamReader(System.in)); // Reading from
																										// System.in
				String userInput, serverInput;

				while (true) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						break;
					}
					if (in.ready()) {
						if ((serverInput = in.readLine()) != null) {
							System.out.println(serverInput);
							System.out.print("BankClient@hostname:");
							System.out.flush();
						} else {
							System.out.println("Srever exit");
							break;
						}
					}
					if (localInStream.ready()) {
						if ((userInput = localInStream.readLine()).equals("exit")) {
							System.out.println("User exit");
							break;
						}
						out.println(userInput);
					}
					out.println();
					if(out.checkError()) {
						System.out.println("\nerror: server exited");
						break;
					}

				}

				out.close();
				in.close();
				socket.close();
				localInStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Useage: BankServer hostName port");
		}
	}

}
