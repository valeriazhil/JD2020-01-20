package by.it.kondratev.calc;

import by.it.kondratev.jd01_14.Helper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CalcLogger {

    public static CalcLogger calcLogger = new CalcLogger();
    private static String path = Helper.getPath(CalcLogger.class, "calclog.txt");
    public static List<String > fullReport = new ArrayList<>();
    public static List<String > errorsReport = new ArrayList<>();
    public static List<String > errorsShortReport = new ArrayList<>();

    void log(String message, int i) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true)))
        {
            Date calendar = new Date();
            String date = String.format("%1$td.%1$tm.%1$tY", calendar);
            String time = String.format("%tH:%tM:%tS", calendar, calendar, calendar);
            String result = String.format("%s ||  %s ||%n%s%n", date, time, message);
            pw.printf(result);
            switch (i) {
                case 1:  fullReport.add(result); break;
                case 2: errorsReport.add(result); break;
                default: errorsShortReport.add(result); break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CalcLogger() {
    }

    public static CalcLogger getInstance() {
        CalcLogger local = calcLogger;
        if (local==null) {
            synchronized (CalcLogger.class) {
                local = calcLogger;
                if (local==null)
                    calcLogger = local = new CalcLogger();
            }
        }
        return local;
    }
}
