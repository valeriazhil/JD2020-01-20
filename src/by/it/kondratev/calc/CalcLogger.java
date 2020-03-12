package by.it.kondratev.calc;

import by.it.kondratev.jd01_14.Helper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

class CalcLogger {

    private static volatile CalcLogger logger;
    private static String path = Helper.getPath(CalcLogger.class, "calclog.txt");

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

    private CalcLogger() {
    }

    public static CalcLogger getInstance() {
        CalcLogger local = logger;
        if (local==null) {
            synchronized (CalcLogger.class) {
                local = logger;
                if (local==null)
                    logger = local = new CalcLogger();
            }
        }
        return local;
    }
}
