package by.it.cherkas.Calculator.report;

import by.it.cherkas.Calculator.FileHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FullReportBuilder implements ReportBuilder{

    FullReport fullReport;

    @Override
    public void startReport() {
        fullReport = new FullReport();
    }

    @Override
    public void addTitle() {
        fullReport.title = "Full Report About Project";
    }

    @Override
    public void addLaunchTime() {
        fullReport.launchTime = ReportDirector.launchTime;
    }

    @Override
    public void addEndTime() {
        fullReport.endTime = ReportDirector.funishTime;
    }

    @Override
    public void addErrorAndExpressionReport() {
        StringBuilder rep = new StringBuilder();
        for (String s : ReportDirector.fullErrors) {
            rep.append(s);
        }
        fullReport.errorReport = rep.toString();
    }

    public FullReport getReport() {
        return fullReport;
    }

    @Override
    public void writeReportToFile() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FileHelper.reportFile, true))) {
            printWriter.print(fullReport.title + "\n");
            printWriter.print(fullReport.launchTime + "\n");
            printWriter.print(fullReport.endTime+"\n");
            if (fullReport.errorReport == null){
                printWriter.print("No errors in this program:)\n");
            }
            else {
                printWriter.print(fullReport.errorReport + "\n");
            }
            printWriter.print("-----------------------------"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}