package honeypot;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class HoneypotServer {
    private int port;

    public HoneypotServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Honeypot listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                String attackerIP = socket.getInetAddress().getHostAddress();
                LocalDateTime time = LocalDateTime.now();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Fake Service: Login required");
                String input = in.readLine();

                Logger.log(attackerIP, port, input, time);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
