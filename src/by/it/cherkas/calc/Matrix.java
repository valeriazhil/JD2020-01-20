package by.it.cherkas.calc;

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

    public double[][] getValue() {
        return value;
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
        return super.add((Var) vector);
    }

    @Override
    public Var add(Matrix matrix) {
        double[][] result = new double[value.length][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += matrix.value[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar scalar) {
        double[][] result = new double[value.length][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = scalar.getValue() - result[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var sub(Vector vector) {
        return super.add((Var) vector);
    }

    @Override
    public Var sub(Matrix matrix) {
        double[][] result = new double[value.length][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix.getValue()[i][j] - result[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar scalar) {
        return scalar.mul(this);
    }

    @Override
    public Var mul(Vector vector) {
        return super.add((Var) vector);
    }

    @Override
    public Var mul(Matrix matrix) {
        double[][] result = new double[matrix.getValue().length][value[0].length];
        for (int i = 0; i < matrix.getValue().length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                for (int k = 0; k < value.length; k++) {
                    result[i][j] += matrix.getValue()[i][k] * value[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var div(Var other) {
        return other.div(this);
    }

    @Override
    public Var div(Scalar scalar) {
        return super.div((Var) scalar);
    }

    @Override
    public Var div(Vector vector) {
        return super.add((Var) vector);
    }

    @Override
    public Var div(Matrix matrix) {
        return super.div((Var) matrix);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value).replace('[', '{').replace(']', '}');
    }
}
