package honeypot;

import java.io.*;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "logs/honeypot_log.csv";

    public static void log(String ip, int port, String message, LocalDateTime time) {
        try {
            File logDir = new File("logs");
            if (!logDir.exists()) logDir.mkdir();

            FileWriter fw = new FileWriter(LOG_FILE, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(time + "," + ip + "," + port + "," + (message != null ? message : "NULL"));
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
