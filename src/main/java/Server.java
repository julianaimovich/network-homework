import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.println("Write your name");
        final String name = in.readLine();
        out.println("Are you child? (yes/no)");
        String age = in.readLine();

        switch (age) {
            case "yes" -> out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            case "no" -> out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
        }
    }
}