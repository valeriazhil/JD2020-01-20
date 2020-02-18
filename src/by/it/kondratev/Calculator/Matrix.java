package by.it.kondratev.Calculator;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] array;

    Matrix(double[][] value) {
        array = new double[value.length][0];
        for (int i = 0; i < array.length; i++) {
            array[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

   Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(1, strMatrix.length() - 2);
        String[] row = strMatrix.split("},");
        for (int i = 0; i <row.length ; i++) {
            row[i] = row[i].trim();
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
                if (j == array[0].length - 1 && i != array.length - 1) s.append("}, {");
                else if (j == array[0].length - 1 && i == array.length - 1) s.append("}}");
                else s.append(", ");
            }
        }

        return s.toString();
    }

    public double [][] getValue() {
        return array;
    }

    @Override
    public Var add(Var other) {
        double[][] result = new double[array.length][0];
        for (int i = 0; i < array.length; i++) {
            result[i] = Arrays.copyOf(array[i], array[0].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] += s;
                }
                //result [0][0] = 2; result [0][1] = 3; result [1][0]=4; result[1][1]=5;
            }
            return new Matrix(result);
        } else if ((other instanceof Matrix && array.length == ((Matrix) other).array.length)) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    result[i][j] = array[i][j] + ((Matrix) other).array[i][j];
                }
            }
            return new Matrix(result);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[][] result = new double[array.length][0];
        for (int i = 0; i < array.length; i++) {
            result[i] = Arrays.copyOf(array[i], array[0].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] -= s;
                }
            }
            //result [0][0] = 0; result [0][1] = 1; result [1][0]=2; result[1][1]=3;
            return new Matrix(result);
        } else if ((other instanceof Matrix && array.length == ((Matrix) other).array.length)) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    result[i][j] = array[i][j] - ((Matrix) other).array[i][j];
                }
            }
            return new Matrix(result);
        } else return super.add(other);

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[array.length][0];
            for (int i = 0; i < array.length; i++) {
                result[i] = Arrays.copyOf(array[i], array[0].length);
            }
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] *= s;
                }
            }
            return new Matrix(result);
        } else {
            if (other instanceof Vector) {
                double[] v = ((Vector) other).getValue();
                if (v.length == array[0].length) {
                    double[] result = new double[array.length];
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < v.length; j++) {
                            result[i] += array[i][j] * v[j];
                        }
                    }
                    return new Vector(result);
                } else return super.mul(other);

            } else {
                double[][] m = ((Matrix) other).getValue();
                if (array[0].length == m.length) {
                    double[][] result = new double[array[0].length][m.length];
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result[0].length; j++) {
                            for (int k = 0; k < m.length; k++) {
                                result[i][j] += array[i][k] * m[k][j];
                            }
                        }
                    } return new Matrix(result);
                } else return super.add(other);
            }
        }

    }
}
        



