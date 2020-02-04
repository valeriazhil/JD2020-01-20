package by.it.zhuravaskarabahataya.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    double[][] values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public Matrix(Matrix matrix) {
        this.values = matrix.values;
    }

    public Matrix(String strMatrix) {
        this.values = stringToMatrix(strMatrix);

    }

    private double[][] stringToMatrix(String strMatrix) {
        StringBuilder sb = new StringBuilder(strMatrix);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0);
        Pattern pattern = Pattern.compile("\\{\\s*[\\d,\\s]+}");
        Matcher matcher = pattern.matcher(sb);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        double[][] matrix = new double[counter][counter];
        String[] strArray = new String[counter];
        Pattern pattern1 = Pattern.compile("\\{\\s*[\\d,\\s]+}");
        Matcher matcher1 = pattern1.matcher(sb);
        int index = 0;
        while (matcher1.find()) {
            strArray[index++] = matcher1.group();
        }
        for (int i = 0; i < strArray.length; i++) {
            StringBuilder sb2 = new StringBuilder(strArray[i]);
            sb2.deleteCharAt(0);
            sb2.deleteCharAt(sb2.length() - 1);
            String[] strArr = sb2.toString().split(",");
            for (int a = 0; a < strArr.length; a++) {
              matrix[i][a] = Double.parseDouble(strArr[a]);
            }
        }

        return matrix;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        String rowsDelimiter = "";
        for (double[] value : values) {
            result.append(rowsDelimiter);
            String delimiter = "";
            result.append("{");
            for (int j = 0; j < values.length; j++) {
                result.append(delimiter).append(value[j]);
                delimiter = ", ";
            }
            rowsDelimiter = ", ";
            result.append("}");

        }
        result.append("}");
        return result.toString();
    }
}
