import java.io.*;
import java.net.*;

public class TestClient {
    public static void main(String[] args) {
        String[] messages = {
            "admin",
            "password123",
            "test",
            "root",
            "honeypot",
            "123456",
            "guest",
            "letmein",
            "attack1",
            "attack2"
        };

        try {
            for (String msg : messages) {
                Socket socket = new Socket("localhost", 2222);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Read server welcome message
                System.out.println("Server says: " + in.readLine());

                // Send test message
                out.println(msg);
                System.out.println("Sent message: " + msg);

                socket.close();

                // Small delay to simulate different attack times
                Thread.sleep(500);
            }

            System.out.println("All test messages sent successfully.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
