package by.it.degtyaryov.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        String[] strValues = strVector.replace(" ", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        this.value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strValues[i]);
        }
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] += scalar.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        if (this.value.length != vector.value.length) {
            throw new CalcException("different size of vectors");
        }
        double[] result = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] += value[i];
        }
        return new Vector(result);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        return super.add((Var) matrix);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = scalar.getValue() - result[i];
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        if (this.value.length != vector.value.length) {
            throw new CalcException("different size of vectors");
        }
        double[] result = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] -= value[i];
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        return super.sub((Var) matrix);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] *= scalar.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        if (this.value.length != vector.value.length) {
            throw new CalcException("different size of vectors");
        }
        double result = 0;
        for (int i = 0; i < value.length; i++) {
            result += value[i] * vector.value[i];
        }
        return new Scalar(result);
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        if (this.value.length != matrix.getValue().length) {
            throw new CalcException("different size matrix and vector");
        }
        double[] result = new double[matrix.getValue().length];
        for (int i = 0; i < matrix.getValue().length; i++) {
            for (int j = 0; j < value.length; j++) {
                result[i] += matrix.getValue()[i][j] * value[j];
            }
        }
        return new Vector(result);
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
        return super.div((Var) vector);
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        return super.div((Var) matrix);
    }

    @Override
    public String toString() {
        return Arrays.toString(value).replace('[', '{')
                .replace(']', '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(value, vector.value);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }
}