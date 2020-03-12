package by.it.kondratev.calc;

import by.it.kondratev.jd01_14.Helper;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportBuilder {

    static ReportBuilderHelper rbh = new ReportBuilderHelper();

    ReportBuilder(){
    }

    static void allEventsReportBuilder() {
        String path = Helper.getPath(ReportBuilder.class, "All events report.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.write(rbh.reportTitle(1));
            pw.write(rbh.dateAndTime() + '\n');
            for (String s : CalcLogger.fullReport) {
                pw.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void errorsReport() {
        String path = Helper.getPath(ReportBuilder.class, "Errors report.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.write(rbh.reportTitle(2));
            pw.write(rbh.dateAndTime() + '\n');
            for (String s : CalcLogger.errorsReport) {
                pw.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void errorsShortReport() {
        String path = Helper.getPath(ReportBuilder.class, "Errors short report.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.write(rbh.reportTitle(3));
            pw.write(rbh.dateAndTime() + '\n');
            for (String s : CalcLogger.errorsShortReport) {
                pw.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
