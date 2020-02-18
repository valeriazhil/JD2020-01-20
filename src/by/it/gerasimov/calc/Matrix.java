package by.it.gerasimov.calc;

import java.util.Arrays;
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
        String[] strVectors = strMatrix.split("[}][, ]+[{]");
        String[] strValues = strVectors[0].split(",");
        value = new double[strVectors.length][strValues.length];
        Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        return this.toString().equals(matrix.toString());
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter1 = "";
        for (double[] doubles : this.value) {
            out.append(delimiter1).append('{');
            String delimiter2 = "";
            for (int j = 0; j < this.value[0].length; j++) {
                out.append(delimiter2).append(doubles[j]);
                delimiter2 = ", ";
            }
            out.append('}');
            delimiter1 = ", ";
        }
        out.append('}');
        return out.toString();
    }

    @Override
    public Var add(Var other) {
        return other.reverseAdd(this);
    }
    public Matrix add(Scalar other) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                result[i][j] = value[i][j] + other.getValue();
            }
        }
        return new Matrix(result);
    }
    public Matrix add(Matrix other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                result[i][j] = this.value[i][j] + other.value[i][j];
            }
        }
        return new Matrix(result);
    }
    @Override
    protected Var reverseAdd(Scalar scalar) {
        return scalar.add(this);
    }
    @Override
    protected Var reverseAdd(Matrix other) {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        return other.reverseSub(this);
    }
    public Matrix sub(Scalar other) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                result[i][j] = value[i][j] - other.getValue();
            }
        }
        return new Matrix(result);
    }
    public Matrix sub(Matrix other) {
        double[][] result = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                result[i][j] = this.value[i][j] - other.value[i][j];
            }
        }
        return new Matrix(result);
    }
    @Override
    protected Var reverseSub(Scalar scalar) {
        return scalar.sub(this);
    }
    @Override
    protected Var reverseSub(Matrix other) {
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        return other.reverseMul(this);
    }
    public Matrix mul(Scalar other) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                result[i][j] = value[i][j] * other.getValue();
            }
        }
        return new Matrix(result);
    }
    public Vector mul(Vector other) {
        double[] result = new double[this.value.length];
        for (int i = 0; i < other.getValue().length; i++) {
            for (int j = 0; j < this.value.length; j++) {
                result[i] += this.value[i][j] * other.getValue()[j];
            }
        }
        return new Vector(result);
    }
    public Matrix mul(Matrix other) {
        double[][] result = new double[this.value.length][other.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < other.value[i].length; j++) {
                for (int k = 0; k < other.value.length; k++) {
                    result[i][j] += this.value[i][k] * other.value[k][j];
                }
            }
        }
        return new Matrix(result);
    }
    @Override
    protected Var reverseMul(Scalar other) {
        return other.mul(this);
    }
    @Override
    protected Var reverseMul(Vector other) {
        return other.mul(this);
    }
    @Override
    protected Var reverseMul(Matrix other) {
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        return other.reverseDiv(this);
    }
    public Matrix div(Scalar other) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                result[i][j] = value[i][j] / other.getValue();
            }
        }
        return new Matrix(result);
    }
}
