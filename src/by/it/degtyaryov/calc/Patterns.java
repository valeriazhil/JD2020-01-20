package by.it.degtyaryov.calc;

interface Patterns {
    String OPERATOR = "[-=+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)*";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
