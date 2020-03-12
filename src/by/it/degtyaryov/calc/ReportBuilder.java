package by.it.degtyaryov.calc;

import java.util.List;

abstract class ReportBuilder {

    protected Report report = new Report();

    Report getReport() {
        return report;
    }

    public abstract void addTitle();

    public abstract void addStartTime();

    public abstract void addEndTime();

    public abstract void addOperation(List<Expression> operations);
}
