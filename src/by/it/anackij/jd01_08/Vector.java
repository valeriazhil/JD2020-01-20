package by.it.anackij.jd01_08;


public class Vector extends Var {
    private double[] values;
    private double doubleValue;

    public Vector(double[] values) {
        this.values = values;
    }

    public Vector(Vector other) {
        this.values = other.values;
    }

    public Vector(String strValue) {
        this.doubleValue = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append('{');
        String delimiter = "";
        for (double value : values) {
            out.append(delimiter).append(value);
            delimiter= ", ";
        }
        out.append('}');
        return out.toString();
    }
}
