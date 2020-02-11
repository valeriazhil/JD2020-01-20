package by.it.gerasimov.jd01_07;

class Scalar extends Var {

    private double value;

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    double getValue() {
        return value;
    }

    void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}

