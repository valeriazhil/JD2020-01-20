package by.it.zhilenkova.jd02.jd02_06.ZhilenkovaCalculator;

final class Patterns {
    static final String OPERATION="(?<![-+*/={,])([-+=*/])";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?)(,?))+}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?))+},?)+}";
}
