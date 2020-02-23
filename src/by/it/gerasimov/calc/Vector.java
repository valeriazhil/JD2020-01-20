package by.it.gerasimov.calc;


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
    public Var add(Var other) throws CalcException {
        return other.reverseAdd(this);
    }
    public Vector add(Scalar other) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] + other.getValue();
        }
        return new Vector(result);
    }
    public Vector add(Vector other) throws CalcException {
        if (other.value.length == this.value.length) {
            double[] result = new double[other.value.length];
            for (int i = 0; i < other.value.length; i++) {
                result[i] = this.value[i] + other.value[i];
            }
            return new Vector(result);
        } else {
            throw new CalcException("Длины векторов не совпадают");
        }
    }
    @Override
    protected Var reverseAdd(Scalar other) {
        return other.add(this);
    }
    @Override
    protected Var reverseAdd(Vector other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.reverseSub(this);
    }
    public Vector sub(Scalar other) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] - other.getValue();
        }
        return new Vector(result);
    }
    public Vector sub(Vector other) throws CalcException {
        if (other.value.length == this.value.length) {
            double[] result = new double[other.value.length];
            for (int i = 0; i < other.value.length; i++) {
                result[i] = this.value[i] - other.value[i];
            }
            return new Vector(result);
        } else {
            throw new CalcException("Длины векторов не совпадают");
        }
    }
    @Override
    protected Var reverseSub(Scalar other) {
        return other.sub(this);
    }
    @Override
    protected Var reverseSub(Vector other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.reverseMul(this);
    }
    public Vector mul(Scalar other) {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            result[i] = value[i] * other.getValue();
        }
        return new Vector(result);
    }
    public Scalar mul(Vector other) throws CalcException {
        if (other.value.length == this.value.length) {
            double result = 0;
            for (int i = 0; i < this.value.length; i++) {
                result += this.value[i] * other.value[i];
            }
            return new Scalar(result);
        } else {
            throw new CalcException("Длины векторов не совпадают");
        }
    }
    public Vector mul(Matrix other) throws CalcException {
        if (this.value.length == other.getValue().length) {
            double[] result = new double[other.getValue()[0].length];
            for (int i = 0; i < other.getValue()[0].length; i++) {
                for (int j = 0; j < value.length; j++) {
                    result[i] += value[j] * other.getValue()[j][i];
                }
            }
            return new Vector(result);
        } else {
            throw new CalcException("Длина вектора не равна кол-ву строк матрицы");
        }
    }
    @Override
    protected Var reverseMul(Scalar other) {
        return other.mul(this);
    }
    @Override
    protected Var reverseMul(Vector other) throws CalcException {
        return other.mul(this);
    }
    @Override
    protected Var reverseMul(Matrix other) throws CalcException {
        return other.mul(this);
    }
    @Override
    public Var div(Var other) throws CalcException {
        return other.reverseDiv(this);
    }
    public Vector div(Scalar other) throws CalcException {
        double[] result = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            if (other.getValue() != 0) {
                result[i] = value[i] / other.getValue();
            } else {
                throw new CalcException("Деление на 0");
            }
        }
        return new Vector(result);
    }
}
