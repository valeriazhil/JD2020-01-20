package by.it.zhuravaskarabahataya.jd01_08;
//почему copyOF на двумерки не срабатывает
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//В конструкторе лучше не вызывать методы,но этот получился монстром каким-то без них

class Matrix extends Var implements Operation {
    private double[][] values;

    public Matrix(double[][] values) {
        this.values = values;
    }

    public Matrix(Matrix matrix) {
        this.values = matrix.values;
    }

    public Matrix(String strMatrix) {
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
        this.values = matrix;
    }

    private static double[][] copy2dArray(double[][] source){
        double[][] resultArray = new double[source.length][source[0].length];
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                resultArray[i][j] = source[i][j];
            }
        }
        return resultArray;
    }

    @Override
    public Var add(Var other) {
        double[][] result = copy2dArray(this.values);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += s;
                }
            }
            return new Matrix(result);
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {
            double[][] result = copy2dArray(this.values);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = values[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Vector){
            double[] result = new double[((Vector) other).getValues().length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i] += this.values[i][j] * ((Vector) other).getValues()[j];
                }
            }
            return new Vector(result);
        }

        else if (other instanceof Matrix){

        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
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
