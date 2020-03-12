package by.it.degtyaryov.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

abstract class ReportBuilder {

    private static final String REPORT_FILE = Helper.getPath(Logger.class, "report.txt");

    protected Report report = new Report();

    public abstract Report addTitle(String title);

    public abstract Report addStartTime(Date start);

    public abstract Report addEndTime(Date end);

    public abstract Report addOperation(String operation, String result);

    public Report build() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(REPORT_FILE))) {
            writer.print(report);
        } catch (IOException e) {
            System.out.println("report error");
        }
        return report;
    }
}
