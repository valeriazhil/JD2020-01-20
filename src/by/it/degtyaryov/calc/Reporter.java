package by.it.degtyaryov.calc;

import java.util.ArrayList;
import java.util.List;

class Reporter {

    protected List<Expression> operations = new ArrayList<>();
    private ReportBuilder builder;

    void setReportBuilder(ReportBuilder builder) {
        this.builder = builder;
        this.builder.addStartTime();
    }

    Report getReport() {
        return builder.getReport();
    }

    void addOperation(String operation, String result) {
        operations.add(new Expression(operation, result));
    }

    void buildReport() {
        builder.addTitle();
        builder.addEndTime();
        builder.addOperation(operations);
    }
}
