import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", Server.PORT);
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println(reader.readLine());
        writer.println("Donovan");
        System.out.println(reader.readLine());
        writer.println("yes");
        System.out.println(reader.readLine());
    }
}