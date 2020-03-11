package by.it.degtyaryov.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

class Logger {

    private static final String LOG_FILE = Helper.getPath(Logger.class, "log.txt");

    private static volatile Logger logger = new Logger();

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

    public void log(String event) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            Date calendar = new Date();
            String date = String.format("%1$td.%1$tm.%1$tY", calendar);
            String time = String.format("%tH:%tM:%tS", calendar, calendar, calendar);
            writer.printf("[%s, %s] %s%n", date, time, event);
        } catch (IOException e) {
            System.out.println("log error");
        }
    }
}
