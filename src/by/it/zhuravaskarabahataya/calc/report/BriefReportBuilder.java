package by.it.zhuravaskarabahataya.calc.report;

import by.it.zhuravaskarabahataya.calc.FileHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BriefReportBuilder implements ReportBuilder {

     BriefReport briefReport;

    @Override
    public void startReport() {
        briefReport = new BriefReport();
    }

    @Override
    public void addTitle() {
        briefReport.title = "Brief Report About Project";
    }

    @Override
    public void addLaunchTime() {
        briefReport.launchTime = ReportDirector.launchTime;
    }

    @Override
    public void addEndTime() {
        briefReport.endTime = ReportDirector.funishTime;
    }

    @Override
    public void addErrorAndExpressionReport() {
        StringBuilder rep = new StringBuilder();
        for (String s : ReportDirector.briefErrors) {
            rep.append(s);
        }
        briefReport.errorReport = rep.toString();
    }

    public BriefReport getReport() {
        return briefReport;
    }

    @Override
    public void writeReportToFile() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FileHelper.reportFile, true))) {
            printWriter.print(briefReport.title + "\n");
            printWriter.print(briefReport.launchTime + "\n");
            printWriter.print(briefReport.endTime+"\n");
            if (briefReport.errorReport == null){
                printWriter.print("No errors in this program:)\n");
            }
            else {
                printWriter.print(briefReport.errorReport + "\n");
            }
            printWriter.print("-----------------------------"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
