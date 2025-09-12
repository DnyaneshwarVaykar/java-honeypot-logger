package honeypot;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Honeypot Logger Project Started!");
        
        // Start honeypot server on port 2222
        HoneypotServer server = new HoneypotServer(2222);
        server.start();

        // Optionally start Dashboard (JavaFX)
        // Dashboard.launchDashboard(args);
    }
}
