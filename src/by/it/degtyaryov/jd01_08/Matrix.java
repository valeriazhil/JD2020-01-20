package by.it.degtyaryov.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][0];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        String[] arrays = strMatrix.replace(" ", "").split("},");
        value = new double[arrays.length][0];
        for (int i = 0; i < value.length; i++) {
            String[] numbers = arrays[i].replace("{", "")
                    .replace("}", "")
                    .split(",");
            value[i] = new double[numbers.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(numbers[j]);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value).replace('[', '{').replace(']', '}');
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Scalar scalar) {
        double[][] result = new double[value.length][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += scalar.getValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var add(Vector vector) {
        return null;
    }

    @Override
    public Var add(Matrix matrix) {
        return null;
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var sub(Scalar scalar) {
        return null;
    }

    @Override
    public Var sub(Vector vector) {
        return null;
    }

    @Override
    public Var sub(Matrix matrix) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var mul(Scalar scalar) {
        return null;
    }

    @Override
    public Var mul(Vector vector) {
        return null;
    }

    @Override
    public Var mul(Matrix matrix) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public Var div(Scalar scalar) {
        return null;
    }

    @Override
    public Var div(Vector vector) {
        return null;
    }

    @Override
    public Var div(Matrix matrix) {
        return null;
    }
}