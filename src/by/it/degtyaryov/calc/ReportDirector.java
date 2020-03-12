package by.it.degtyaryov.calc;

import java.util.*;

class ReportDirector {

    private ReportBuilder builder;
    private Date startTime;
    private Date endTime;
    private Map<String, String> operations;

    public ReportDirector(ReportBuilder builder) {
        this.builder = builder;
        startTime = new Date();
        operations = new LinkedHashMap<>();
    }

}
