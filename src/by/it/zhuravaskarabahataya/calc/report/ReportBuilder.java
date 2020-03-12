package by.it.zhuravaskarabahataya.calc.report;

interface ReportBuilder {

    void startReport();
    void addTitle();
    void addLaunchTime();
    void addEndTime();
    void addErrorAndExpressionReport();
    void writeReportToFile();
}
