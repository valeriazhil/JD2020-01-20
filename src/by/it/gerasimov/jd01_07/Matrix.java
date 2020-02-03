package by.it.gerasimov.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] strVectors = strMatrix.split("[}][, ]+[{]"); //??
        String[] strValues = strVectors[0].split(","); //??
        value = new double[strVectors.length][strValues.length];
        Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher m = p.matcher(strMatrix);
        for (int i = 0; i < strVectors.length; i++) {
            for (int j = 0; j < strValues.length; j++) {
                if (m.find()) {
                    value[i][j] = Double.parseDouble(m.group());
                }
            }
        }
    }

    double[][] getValue() {
        return value;
    }

    void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter1 = "";
        for (int i = 0; i < this.value.length; i++) {
            out.append(delimiter1).append("{ ");
            String delimiter2 = "";
            for (int j = 0; j < this.value[0].length; j++) {
                out.append(delimiter2).append(value[i][j]);
                delimiter2 = ", ";
            }
            out.append(" }");
            delimiter1 = ", ";
        }
        out.append('}');
        return out.toString();
    }
}
