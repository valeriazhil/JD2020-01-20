package by.it.zhilenkova.jd02.ZhilenkovaCalcAll.reportBuilder;

import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportBuilder implements Report {

    private Logger logger = Logger.getLogger();


    @Override
    public void printHeader() {
    }

    @Override
    public void printStartUseTime() {
        String text = "Start use time";
        String message = String.format("\n%s %s\n", getDate(), text);
        logger.log(message);
    }

    @Override
    public void printEndUseTime() {
        String text = "End use time";
        String message = String.format("\n%s %s", getDate(), text);
        logger.log(message);
    }

    @Override
    public void printOperations(String operation, String result) {
        logger.log(operation + " " + result);
    }

    @Override
    public void printExceptions(Exception exception) {
    }

    @Override
    public String getDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY" + " " + "HH:mm:ss");
        return df.format(date);

    }
}
