package by.it.gerasimov.jd01_07;


class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        value = new double[vector.getValue().length];
        System.arraycopy(vector.getValue(), 0, value, 0, vector.getValue().length);
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
}
