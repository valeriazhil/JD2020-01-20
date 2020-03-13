package by.it.akhmelev.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {


    void log(String message) {
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter("log.txt", true))
        ) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static volatile Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        Logger local = logger;
        if (local == null) {
            synchronized (Logger.class) {
                local = logger;
                if (local == null) {
                    logger = local = new Logger();
                }

            }
        }
        return local;
    }
}
