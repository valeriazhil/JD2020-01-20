package by.it.gerasimov.jd01_07;


class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
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
        this.value = value;
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
