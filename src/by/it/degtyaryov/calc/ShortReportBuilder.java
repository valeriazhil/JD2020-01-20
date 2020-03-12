package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;

import java.text.DateFormat;
import java.util.Date;

class ShortReportBuilder extends ReportBuilder {

    @Override
    public Report addTitle(String title) {
        report.setTitle("Short report");
        return report;
    }

    @Override
    public Report addStartTime(Date start) {
        String date = DateFormat.getDateInstance(DateFormat.SHORT, ResManager.INSTANCE.getLocale()).format(start);
        report.setStartTime(date);
        return report;
    }

    @Override
    public Report addEndTime(Date end) {
        String date = DateFormat.getDateInstance(DateFormat.SHORT, ResManager.INSTANCE.getLocale()).format(end);
        report.setEndTime(date);
        return report;
    }

    @Override
    public Report addOperation(String operation, String result) {
        report.setOperation(operation);
        report.setOperation(result);
        return report;
    }
}
