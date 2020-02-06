package by.it.gerasimov.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = new double[value[i].length];
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        value = new double[matrix.getValue().length][0];
        for (int i = 0; i < matrix.getValue().length; i++) {
            value[i] = new double[matrix.getValue()[i].length];
            System.arraycopy(matrix.getValue()[i], 0, value[i], 0, matrix.getValue()[i].length);
        }
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
        this.value = new double[value.length][0];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = new double[value[i].length];
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter1 = "";
        for (double[] doubles : this.value) {
            out.append(delimiter1).append("{ ");
            String delimiter2 = "";
            for (int j = 0; j < this.value[0].length; j++) {
                out.append(delimiter2).append(doubles[j]);
                delimiter2 = ", ";
            }
            out.append(" }");
            delimiter1 = ", ";
        }
        out.append('}');
        return out.toString();
    }
}
