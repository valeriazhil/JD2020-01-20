package by.it.dolgiy.jd02_04;

interface Patterns {
    String OPERATION = "(?<=[^-+*/{,])[-+*/=]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{"+SCALAR+"(,"+SCALAR+")*}";
    String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
}
