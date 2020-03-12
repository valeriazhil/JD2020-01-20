package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class FullReportBuilder extends ReportBuilder {

    @Override
    public void addTitle() {
        report.setTitle("\n--------------------\n" +
                                ResManager.INSTANCE.get(TextResource.FULL_TITLE) +
                                "\n--------------------\n");
    }

    @Override
    public void addStartTime() {
        String date = DateFormat.getTimeInstance(DateFormat.FULL, ResManager.INSTANCE.getLocale()).format(new Date());
        report.setStartTime(date);
    }

    @Override
    public void addEndTime() {
        String date = DateFormat.getTimeInstance(DateFormat.FULL, ResManager.INSTANCE.getLocale()).format(new Date());
        report.setEndTime(date);
    }

    @Override
    public void addOperation(List<Expression> operations) {
        List<String> op = new ArrayList<>();
        for (Expression operation : operations) {
            String line = String.format(ResManager.INSTANCE.get(TextResource.FULL_FORM_OPERATION), operation.getOperation(), operation.getResult());
            op.add(line);
        }
        report.setOperations(op);
    }
}
