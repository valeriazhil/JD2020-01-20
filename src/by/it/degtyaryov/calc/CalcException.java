package by.it.degtyaryov.calc;

import by.it.degtyaryov.calc.i18n.ResManager;
import by.it.degtyaryov.calc.i18n.TextResource;

class CalcException extends Exception {

    static ResManager res = ResManager.INSTANCE;

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(String.format(res.get(TextResource.CALC_EXCEPTION), message));
    }

    public CalcException(String message, Throwable cause) {
        super(String.format(res.get(TextResource.CALC_EXCEPTION), message), cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
