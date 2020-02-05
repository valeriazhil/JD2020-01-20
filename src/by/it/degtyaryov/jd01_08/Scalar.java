package by.it.degtyaryov.jd01_08;

import java.util.Arrays;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Scalar scalar) {
        return new Scalar(scalar.value + value);
    }

    @Override
    public Var add(Vector vector) {
        return vector.add(this);
    }

    @Override
    public Var add(Matrix matrix) {
        return matrix.add(this);
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar scalar) {
        return new Scalar(scalar.value - value);
    }

    @Override
    public Var sub(Vector vector) {
        double[] result = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        for (int i = 0; i < result.length; i++) {
            result[i] -= value;
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Matrix matrix) {
        double[][] result = new double[matrix.getValue().length][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(matrix.getValue()[i], matrix.getValue()[i].length);
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] -= value;
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
        return new Scalar(scalar.value * value);
    }

    @Override
    public Var mul(Vector vector) {
        double[] result = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        for (int i = 0; i < result.length; i++) {
            result[i] *= value;
        }
        return new Vector(result);
    }

    @Override
    public Var mul(Matrix matrix) {
        double[][] result = new double[matrix.getValue().length][0];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(matrix.getValue()[i], matrix.getValue()[i].length);
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] *= value;
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
        return new Scalar(scalar.value / value);
    }

    @Override
    public Var div(Vector vector) {
        double[] result = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        for (int i = 0; i < result.length; i++) {
            result[i] /= value;
        }
        return new Vector(result);
    }

    @Override
    public Var div(Matrix matrix) {
        return super.div((Var) matrix);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
