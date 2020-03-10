package by.it.kondratev.calc;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] values;

    Matrix(double[][] value) {
        values = new double[value.length][0];
        for (int i = 0; i < values.length; i++) {
            values[i] = Arrays.copyOf(value[i], value[i].length);
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
        values = new double[row.length][cols.length];
        for (int i = 0; i < row.length ; i++) {
            String [] col = row[i].split(",");
            for (int j = 0; j < col.length ; j++) {
                values[i][j] = Double.parseDouble(col[j]);

            }
        }
    }

    Matrix(Matrix matrix) {
        values = matrix.values;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                s.append(values[i][j]);
                if (j == values[0].length - 1 && i != values.length - 1) s.append("}, {");
                else if (j == values[0].length - 1 && i == values.length - 1) s.append("}}");
                else s.append(", ");
            }
        }

        return s.toString();
    }

    public double [][] getValue() {
        return values;
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[][] result = new double[values.length][0];
        for (int i = 0; i < values.length; i++) {
            result[i] = Arrays.copyOf(values[i], values[0].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] += s;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix)
            if (values.length != ((Matrix) other).values.length ||
                    values[0].length != ((Matrix) other).values[0].length)
                throw new CalcException ("Невозможна операция над матрицами разной размерности");
            else {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < values.length; j++) {
                    result[i][j] = values[i][j] + ((Matrix) other).values[i][j];
                }
            }
            return new Matrix(result);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[][] result = new double[values.length][0];
        for (int i = 0; i < values.length; i++) {
            result[i] = Arrays.copyOf(values[i], values[0].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] -= s;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix)
            if (values.length != ((Matrix) other).values.length ||
                    values[0].length != ((Matrix) other).values[0].length)
                throw new CalcException ("Невозможна операция над матрицами разной размерности");
            else {
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < values[0].length; j++) {
                        result[i][j] = values[i][j] - ((Matrix) other).values[i][j];
                    }
                }
                return new Matrix(result);
        } else return super.sub(other);

    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = new double[values.length][0];
            for (int i = 0; i < values.length; i++) {
                result[i] = Arrays.copyOf(values[i], values[0].length);
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
                if (v.length != values[0].length)
                    throw new CalcException("Операция невозможна " +
                            "(ширина матрицы должна быть равна длине вектора)");
                else {
                    double[] result = new double[values.length];
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < v.length; j++) {
                            result[i] += values[i][j] * v[j];
                        }
                    }
                    return new Vector(result);
                }
            } else {
                double[][] m = ((Matrix) other).getValue();
                if (values[0].length != m.length)
                    throw new CalcException("Операция невозможна " +
                            "(ширина первой матрицы должна быть равна длине второй матрицы)");
                else {
                    double[][] result = new double[values.length][m[0].length];
                    for (int i = 0; i < result.length; i++) {
                        for (int j = 0; j < result[0].length; j++) {
                            for (int k = 0; k < m.length; k++) {
                                result[i][j] += values[i][k] * m[k][j];
                            }
                        }
                    } return new Matrix(result);
                }
            }
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Matrix || other instanceof Vector)
            return super.div(other);
        else {
            double[][] result = new double[values.length][0];
            for (int i = 0; i < values.length; i++) {
                result[i] = Arrays.copyOf(values[i], values[0].length);
            }
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] /= s;
                }
            }
            return new Matrix(result);
        }
    }
}
        



