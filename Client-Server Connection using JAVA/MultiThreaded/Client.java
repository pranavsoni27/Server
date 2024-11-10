import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

        public Runnable getRunnable() {
                return () -> {
                        int port = 8010;
                        try {
                                InetAddress address = InetAddress.getByName("localhost");
                                Socket socket = new Socket(address, port);

                                try (
                                        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true); // Enable auto-flush
                                        
                                        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                                ){
                                        // Send a unique message to the server
                                        // toSocket.println("Hello from Client " + socket.getLocalSocketAddress());

                                        System.out.println("Connected to server successfully");

                                        // Read and print the server's response
                                        String serverResponse = fromSocket.readLine();
                                        System.out.println("Server response: " + serverResponse);

                                } catch (IOException ex) {
                                        ex.printStackTrace();
                                } finally {
                                        socket.close(); // Ensure the socket is closed
                                }
                        } catch (IOException ex) {
                                ex.printStackTrace();
                        }
                };
        }

        public static void main(String[] args) {
                Client client = new Client();
                for (int i = 0; i < 100; i++) { // Adjust the number of clients as needed
                        try {
                                Thread thread = new Thread(client.getRunnable());
                                thread.start();
                        } catch (Exception ex) {
                                ex.printStackTrace();
                        }
                }
        }
}
