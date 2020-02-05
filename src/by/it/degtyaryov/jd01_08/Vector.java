package by.it.degtyaryov.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    public double[] getValue() {
        return value;
    }

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

    @Override
    public String toString() {
        return Arrays.toString(value).replace('[', '{')
                .replace(']', '}');
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Scalar scalar) {
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] += scalar.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var add(Vector vector) {
        double[] result = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] += value[i];
        }
        return new Vector(result);
    }

    @Override
    public Var add(Matrix matrix) {
        return null;
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Scalar scalar) {
        return null;
    }

    @Override
    public Var sub(Vector vector) {
        double[] result = Arrays.copyOf(vector.value, vector.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] -= value[i];
        }
        return new Vector(result);
    }

    @Override
    public Var sub(Matrix matrix) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar scalar) {
        return null;
    }

    @Override
    public Var mul(Vector vector) {
        double result = 0;
        for (int i = 0; i < value.length; i++) {
            result += value[i] * vector.value[i];
        }
        return new Scalar(result);
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