package by.it.gerasimov.jd01_09;


import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }
    Vector(Vector other) {
        value = new double[other.getValue().length];
        System.arraycopy(other.getValue(), 0, value, 0, other.getValue().length);
    }
    Vector(String strVector) {
        String[] strValues = strVector.split("[, }{]+");
        value = new double[strValues.length - 1];
        for (int i = 1; i < strValues.length; i++) {
            value[i - 1] = Double.parseDouble(strValues[i]);
        }
    }

    double[] getValue() {
        return value;
    }
    void setValue(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector other = (Vector) o;
        return Arrays.equals(value, other.value);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double value : value) {
            out.append(delimiter).append(value);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }

    @Override
    public Var add(Var other) {
        return other.reverseAdd(this);
    }
    public Vector add(Scalar other) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] + other.getValue();
        }
        return new Vector(result);
    }
    public Vector add(Vector other) {
        double[] result = new double[other.value.length];
        for (int i = 0; i < other.value.length; i++) {
            result[i] = this.value[i] + other.value[i];
        }
        return new Vector(result);
    }
    @Override
    protected Var reverseAdd(Scalar other) {
        return other.add(this);
    }
    @Override
    protected Var reverseAdd(Vector other) {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        return other.reverseSub(this);
    }
    public Vector sub(Scalar other) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] - other.getValue();
        }
        return new Vector(result);
    }
    public Vector sub(Vector other) {
        double[] result = new double[other.value.length];
        for (int i = 0; i < other.value.length; i++) {
            result[i] = this.value[i] - other.value[i];
        }
        return new Vector(result);
    }
    @Override
    protected Var reverseSub(Scalar other) {
        return other.sub(this);
    }
    @Override
    protected Var reverseSub(Vector other) {
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        return other.reverseMul(this);
    }
    public Vector mul(Scalar other) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] * other.getValue();
        }
        return new Vector(result);
    }
    public Scalar mul(Vector other) {
        double result = 0;
        for (int i = 0; i < this.value.length; i++) {
            result += this.value[i] * other.value[i];
        }
        return new Scalar(result);
    }
    public Vector mul(Matrix other) {
        double[] result = new double[other.getValue()[0].length];
        for (int i = 0; i < other.getValue()[0].length; i++) {
            for (int j = 0; j < value.length; j++) {
                result[i] += value[j] * other.getValue()[j][i];
            }
        }
        return new Vector(result);
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
    public Vector div(Scalar other) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] / other.getValue();
        }
        return new Vector(result);
    }
}
