package by.it.zhilenkova.jd02.ZhilenkovaCalcAll;

import by.it.zhilenkova.jd02.ZhilenkovaCalcAll.localization.TranslateManager;

public class CalcException extends Exception {
    public CalcException() {
        super();
    }

    TranslateManager tm = TranslateManager.INSTANCE;


    public CalcException(String message) {
        super ("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }


}
