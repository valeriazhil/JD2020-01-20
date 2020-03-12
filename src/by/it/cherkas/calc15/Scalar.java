package by.it.cherkas.calc15;

import java.util.Objects;

class Scalar extends Var {

    private double value;

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }
    Scalar(double value) {
        this.value = value;
    }
    Scalar(Scalar other) {
        this.value = other.value;
    }


    double getValue() {
        return value;
    }
    void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scalar scalar = (Scalar) o;
        return Double.compare(scalar.value, value) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.reverseAdd(this);
    }
    public Scalar add(Scalar other) {
        return new Scalar(this.value + other.value);
    }
    public Vector add(Vector other) {
        return other.add(this);
    }
    public Matrix add(Matrix other) {
        return other.add(this);
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
    protected Var reverseAdd(Matrix other) {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.reverseSub(this);
    }
    public Scalar sub(Scalar other) {
        return new Scalar(this.value - other.value);
    }
    public Vector sub(Vector other) {
        double[] result = new double[other.getValue().length];
        for (int i = 0; i < other.getValue().length; i++) {
            result[i] = this.value - other.getValue()[i];
        }
        return new Vector(result);
    }
    public Matrix sub(Matrix other) {
        double[][] result = new double[other.getValue().length][other.getValue()[0].length];
        for (int i = 0; i < other.getValue().length; i++) {
            for (int j = 0; j < other.getValue()[i].length; j++) {
                result[i][j] = this.value - other.getValue()[i][j];
            }
        }
        return new Matrix(result);
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
    protected Var reverseSub(Matrix other) {
        return other.sub(this);
    }

    public Var mul(Var other) throws CalcException {
        return other.reverseMul(this);
    }
    public Scalar mul(Scalar other) {
        return new Scalar(this.value * other.value);
    }
    public Vector mul(Vector other) {
        return other.mul(this);
    }
    public Matrix mul(Matrix other) {
        return other.mul(this);
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
    public Var div(Var other) throws CalcException {
        return other.reverseDiv(this);
    }
    public Scalar div(Scalar other) throws CalcException {
        if (other.value != 0) {
            return new Scalar(this.value / other.value);
        } else {
            throw new CalcException("Деление на 0");
        }
    }
    @Override
    protected Var reverseDiv(Scalar other) throws CalcException {
        return other.div(this);
    }
    @Override
    protected Var reverseDiv(Vector other) throws CalcException {
        return other.div(this);
    }
    @Override
    protected Var reverseDiv(Matrix other) throws CalcException {
        return other.div(this);
    }
}

