package by.it.cherkas.Calculator;

import by.it.cherkas.Calculator.report.ReportDirector;

class CalcException extends Exception {
    public CalcException(String message) {
        super("ERROR:" + message);
        Logger.getInstance().log("\n" + "ERROR: " + message);
        ReportDirector.addBriefError("\n" + message + "\n");
        ReportDirector.addFullError("\n" + "ERROR: " + message + "\n");

    }

    @SuppressWarnings("unused")
    public CalcException() {
        super();
    }
    @SuppressWarnings("unused")
    public CalcException(String message, Throwable cause) {
        super("ERROR:" + message, cause);
    }
    @SuppressWarnings("unused")
    public CalcException(Throwable cause) {
        super(cause);
    }
    @SuppressWarnings("unused")
    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:" + message, cause, enableSuppression, writableStackTrace);
    }
}