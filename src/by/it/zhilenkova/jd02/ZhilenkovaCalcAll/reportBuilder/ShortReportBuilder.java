package by.it.zhilenkova.jd02.ZhilenkovaCalcAll.reportBuilder;

import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.Logger;

public class ShortReportBuilder extends ReportBuilder {

    private Logger logger = Logger.getLogger();

    @Override
    public void printHeader() {
        logger.log("----------------------------------SHORT REPORT-----------------------------------");
    }

    @Override
    public void printExceptions(Exception exception) {
        String text = exception.getMessage();
//        String message = String.format("%s %s\n", text);
        logger.log(text + "\n");
    }
}
