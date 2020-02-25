package by.it.zhuravaskarabahataya.jd01_13.calcForExperiments;

interface Patterns {
    String OPERATION = "[-+*/=]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
