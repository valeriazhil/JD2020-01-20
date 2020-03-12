package by.it.cherkas.Calculator.report;


import java.util.ArrayList;
import java.util.List;

public class ReportDirector {
    static String launchTime;
    static String funishTime;
    static List<String> briefErrors = new ArrayList<>();
    static List<String> fullErrors = new ArrayList<>();

    public static void setLaunchTime(String dateTimeInstance) {
        launchTime = "Launch time: " + dateTimeInstance;
    }

    public static void setFinish(String dateTimeInstance) {
        funishTime = "Finish time: " + dateTimeInstance;
    }

    public void buildReport(ReportBuilder builder){
        builder.startReport();
        builder.addTitle();
        builder.addLaunchTime();
        builder.addEndTime();
        builder.addErrorAndExpressionReport();
        builder.writeReportToFile();
    }

    public static void addBriefError(String err){
        briefErrors.add(err);
    }

    public static void addOperation(String oper){
        briefErrors.add(oper);
        fullErrors.add(oper);
    }

    public static void addFullError (String err){
        fullErrors.add(err);
    }

}