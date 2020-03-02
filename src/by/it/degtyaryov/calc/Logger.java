package by.it.degtyaryov.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

class Logger {

    private static final String LOG_FILE = Helper.getPath(Logger.class, "log.txt");
    private static final int HISTORY_COUNT = 50;
    public static Logger logger = new Logger();
    private Deque<String> history = new LinkedList<>();

    private Logger() {
    }

    public void log(String event) {
        addToHistory(event);
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            Date calendar = new Date();
            String date = String.format("%1$td.%1$tm.%1$tY", calendar);
            String time = String.format("%tH:%tM:%tS", calendar, calendar, calendar);
            for (String ev : history) {
                writer.printf("[%s %s] %s%n", date, time, ev);
            }
        } catch (IOException e) {
            System.out.println("log error");
        }
    }

    private void addToHistory(String event) {
        while (history.size() >= HISTORY_COUNT) {
            history.pollFirst();
        }
        history.addLast(event);
    }
}
