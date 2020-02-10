package by.it.anackij.jd01_08;


import java.util.Arrays;

public class Vector extends Var {
    private double[] values;
    private double doubleValue;
    private String strValue;

    public Vector(double[] values) {
        this.values = values;
    }



    @Override
    public Var add(Var other) {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + s;
                return  new Vector(result);
            }
        } else if (other instanceof Vector) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + new Vector((Vector) other).values[i];
                return new Vector(result);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    public Vector(Vector other) {
        this.values = other.values;
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
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }
}
