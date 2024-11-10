import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

        public void run() throws IOException {
                int port = 8010; // Ensure the port matches in both Server and Client
                System.out.println("Server is listening on port: " + port);

                ServerSocket socket = new ServerSocket(port);
                socket.setSoTimeout(10000);

                while (true) {
                        try {
                                Socket acceptedConnection = socket.accept();
                                System.out.println("Connected to client: " + acceptedConnection.getRemoteSocketAddress());

                                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true); // Enable auto-flush
                                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

                                // String line = fromClient.readLine();

                                toClient.println("Hello from the server!");

                                // Close resources
                                toClient.close();
                                fromClient.close();
                                acceptedConnection.close();

                        } catch (IOException ex) {
                                ex.printStackTrace();
                        }
                }
        }

        public static void main(String[] args) {
                Server server = new Server();
                try {
                        server.run();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }
}
