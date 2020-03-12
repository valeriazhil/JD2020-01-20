package by.it.cherkas.Calculator.report;

import java.util.ArrayList;
import java.util.List;

public abstract class Report {
    BriefReport briefReport;
    FullReport fullReport;


    public String title;
    public String launchTime;
    public String endTime;
    public String errorReport;
    public List<String> errorsReport = new ArrayList<>();

}