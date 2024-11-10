import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public void connectToServer() {
        int port = 8010;

        try {
            InetAddress address = InetAddress.getByName("localhost");
            try (Socket socket = new Socket(address, port);
                    PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // Print connection confirmation
                System.out.println("Connected to server successfully");

                // Send a message to the server
                // toServer.println("Hello from Client " + socket.getLocalSocketAddress());

                // Read and print the server's response
                String response = fromServer.readLine();
                System.out.println("Server response: " + response);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();

        // Adjust the number of clients as needed
        for (int i = 0; i<1000; i++) {
            new Thread(client::connectToServer).start();
        }
    }
}
