package by.it.degtyaryov.calc;

import java.io.*;
import java.util.Date;

class Logger {

    private static final String LOG_FILE = Helper.getPath(Logger.class, "log.txt");
    public static Logger logger = new Logger();

    private Logger() {
    }

    public void log(String event) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            Date calendar = new Date();
            String date = String.format("%1$td.%1$tm.%1$tY", calendar);
            String time = String.format("%tH:%tM:%tS", calendar, calendar, calendar);
            writer.printf("[%s %s] %s%n", date, time, event);
        } catch (IOException e) {
            System.out.println("log error");
        }
    }
}
