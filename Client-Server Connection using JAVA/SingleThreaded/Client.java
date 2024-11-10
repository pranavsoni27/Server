import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

        public void run() throws UnknownHostException, IOException {
                int port = 8010; // Ensure the port matches the server's port

                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);

                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true); // Enable auto-flush
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Send a message to the server
                // toSocket.println("Hello from the client!"); // Automatically flushed
                
                // System.out.println("<< Message sent to server successfully >>");

                // Read the server's response
                String line = fromSocket.readLine();
                System.out.println("Response from server: " + line);

                // Close resources
                toSocket.close();
                fromSocket.close();
                socket.close();
        }

        public static void main(String[] args) {
                System.out.println("Connected to server successfully");
                try {
                        Client client = new Client();
                        client.run();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }
}
