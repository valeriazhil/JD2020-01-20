package by.it.zhilenkova.jd02.ZhilenkovaCalcAll.reportBuilder;

public interface Report {

    void printHeader();
    void printStartUseTime();
    void printEndUseTime();
    void printOperations(String operation, String result);
    void printExceptions(Exception exception);
    String getDate();
}
