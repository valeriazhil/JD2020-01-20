package by.it.anackij.jd01_07;

class Scalar extends Var {

    private double value;

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar other) {
        this.value = other.value;
    }

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
