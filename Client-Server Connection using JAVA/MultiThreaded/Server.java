import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

        public Consumer<Socket> getConsumer() {
                return (clientSocket) -> {
                        try {
                                // Set up input and output streams
                                BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                
                                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true); // Enable auto-flush

                                // Send a response to the client
                                toClient.println("Hello from Server");

                                // Close resources
                                toClient.close();
                                fromClient.close();
                                clientSocket.close();

                        } catch (IOException ex) {
                                ex.printStackTrace();
                        }
                };
        }

        public static void main(String[] args) {
                int port = 8010;
                Server server = new Server();

                try {
                        ServerSocket serverSocket = new ServerSocket(port);
                        serverSocket.setSoTimeout(10000);
                        System.out.println("Server is listening on port " + port);

                        while (true) {
                                Socket acceptedSocket = serverSocket.accept();
                                System.out.println("Connected to client: " + acceptedSocket.getPort());

                                // Start a new thread to handle the client connection
                                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                                thread.start();
                        }
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }
}
