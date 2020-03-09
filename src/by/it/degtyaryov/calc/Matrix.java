package by.it.degtyaryov.calc;

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
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
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
    public Var add(Vector vector) throws CalcException {
        return super.add((Var) vector);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        if (this.value.length != matrix.value.length
                || this.value[0].length != matrix.value[0].length) {
            throw new CalcException("different size of matrix");
        }
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
    public Var sub(Var other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
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
    public Var sub(Vector vector) throws CalcException {
        return super.sub((Var) vector);
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        if (this.value.length != matrix.value.length
                || this.value[0].length != matrix.value[0].length) {
            throw new CalcException("different size of matrix");
        }
        double[][] result = new double[matrix.getValue().length][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(matrix.getValue()[i], matrix.getValue()[i].length);
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix.getValue()[i][j] - value[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        return scalar.mul(this);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        return super.mul((Var) vector);
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        if (this.value.length != matrix.value.length
                || this.value[0].length != matrix.value[0].length) {
            throw new CalcException("different size of matrix");
        }
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
    public Var div(Var other) throws CalcException {
        return other.div(this);
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        return super.div((Var) scalar);
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        return super.add((Var) vector);
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        return super.div((Var) matrix);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value).replace('[', '{').replace(']', '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        for (int i = 0; i < value.length; i++) {
            if (!Arrays.equals(value[i], matrix.value[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }
}