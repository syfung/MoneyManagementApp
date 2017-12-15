package bankClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BankClient {

	public static void main(String[] args) {
		// Check usage
		if (args.length == 2) {

			// Convert host name and port number
			String hostName = args[0];
			int portNumber = Integer.valueOf(args[1]);

			// TODO actually separate the try catch block
			try {
				// Open socket and create connection
				Socket socket = new Socket(hostName, portNumber);
				System.out.println("Got connection");

				// Open read/write stream
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedReader localInStream = new BufferedReader(new InputStreamReader(System.in)); // Reading
																										// from
																										// System.in
				String userInput, serverOutput; // serverInput --> in, userInput
												// --> out

				// Main loop
				while (true) {
					// Sleep 30ms to reserve thread time
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						break;
					}

					if (in.ready()) { // Avoid blocking
						serverOutput = in.readLine(); // Not checking null since
														// in.ready()
						System.out.println(serverOutput);
						System.out.print("BankClient@hostname:");
						System.out.flush();
					}
					if (localInStream.ready()) { // Avoid blocking
						if ((userInput = localInStream.readLine()).equals("exit")) { // Some
																						// user
																						// input
																						// handled
																						// locally
							System.out.println("User exit");
							break;
						}
						out.println(userInput); // The rest post to the server
					}

					// Check server connection by posting new line
					out.println();
					if (out.checkError()) {
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

		} else { // Usage
			System.out.println("Useage: BankServer hostName port");
		}
	}

}
