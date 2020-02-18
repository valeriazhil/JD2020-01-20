package by.it.kondratev.Calculator;

public class Patterns {

    static final String OPERATION = "[-+/*]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR =  "\\{("+SCALAR+",?)+}"; //"\\{(-?[0-9]+\\.?[0-9]*,?)+}";
    static final String MATRIX = "\\{("+VECTOR+",?)+}";  //"\\{(\\{(-?[0-9]+\\.?[0-9]*,?)+},?)+}";
}
