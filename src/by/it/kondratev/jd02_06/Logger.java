package by.it.kondratev.jd02_06;

import by.it.kondratev.jd01_14.Helper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

class Logger {

    private static volatile Logger logger;
    private static String path = Helper.getPath(Logger.class, "log.txt");

    void log(String message) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true)))
        {
            Date calendar = new Date();
            String date = String.format("%1$td.%1$tm.%1$tY", calendar);
            String time = String.format("%tH:%tM:%tS", calendar, calendar, calendar);
            pw.printf("%s || %s || %s%n", date, time, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Logger() {
    }

    public static Logger getInstance() {
        Logger local = logger;
        if (local==null) {
            synchronized (Logger.class) {
                local = logger;
                if (local==null)
                    logger = local = new Logger();
            }
        }
        return local;
    }
}
