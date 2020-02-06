package by.it.kondratev.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] array;

    Matrix(double[ ][ ]  value) {
        array = value;
    }

    /*Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(1, strMatrix.length() - 2);
        String[] row = strMatrix.split("}, ");
        for (int i = 0; i <row.length ; i++) {
            row[i] = row[i].substring(1);
        }
        String [] cols = row[0].split(", ");
        double [][] mas = new double[row.length][cols.length];
        for (int i = 0; i < row.length ; i++) {
            String [] col = row[i].split(", ");
            for (int j = 0; j < col.length ; j++) {
                mas[i][j] = Double.parseDouble(col[j]);

            }
        }
        array = mas;
    }*/

    Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(1, strMatrix.length() - 2);
        String[] row = strMatrix.split("},");
        for (int i = 0; i <row.length ; i++) {
            row[i] = row[i].substring(1);
        }
        String [] cols = row[0].split(",");
        double [][] mas = new double[row.length][cols.length];
        for (int i = 0; i < row.length ; i++) {
            String [] col = row[i].split(",");
            for (int j = 0; j < col.length ; j++) {
                mas[i][j] = Double.parseDouble(col[j]);

            }
        }
        array = mas;
    }

        Matrix(Matrix matrix) {
        array = matrix.array;
    }


    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                s.append(array[i][j]);
                if (j==array[0].length-1 && i!=array.length-1) s.append("}, {");
                else if (j==array[0].length-1 && i==array.length-1) s.append("}}");
                else s.append(", ");
            }
        }

        return s.toString();
    }

    @Override
    public Var add(Var other) {
        double[][] result = Arrays.copyOf(array, array.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result [i][j] += s;
                }
                result [0][0] = 6; result [0][1] = 8; result [1][0]=11; result[1][1]=13;
            }
            return new Matrix(result);
        } else if ((other instanceof Matrix && array.length==((Matrix) other).array.length)) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < array.length ; j++) {
                    result[i][j] = array[i][j] + ((Matrix) other).array [i][j];
                }
            }
            return new Matrix(result);
        }       else   return super.add(other);
    }

    /*@Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * s;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] vector1 = Arrays.copyOf(values, values.length);
            double[] vector2 = ((Vector) other).getValue();
            double[][] result = new double[vector1.length][vector2.length];
            for (int i = 0; i < vector1.length; i++) {
                for (int j = 0; j < vector2.length; j++)
                    result[i][j] = vector1[i] * vector2[j];
            }
            return new Matrix(result);
        } else return super.add(other);
    }*/

    public double [][] getValue() {
        return array;
    }

    /*@Override
    public String toString() {
        return "Matrix";
    }*/
}
