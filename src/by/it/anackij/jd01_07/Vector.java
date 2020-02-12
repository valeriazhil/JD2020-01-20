package by.it.anackij.jd01_07;

public class Vector extends Var {
    private double[] values;

    public Vector(double[] values) {
        this.values = values;
    }

    public Vector(Vector other) {
        this(other.values);
    }

    public Vector(String strValue) {
        String[] array;
        array = strValue.trim().replace("{","").replace("}","").split(",");

        values = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            values[i] = Double.parseDouble(array[i]);
        }
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
