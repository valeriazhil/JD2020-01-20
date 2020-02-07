package by.it.anackij.jd01_09;


import java.util.Arrays;

public class Vector extends Var {
    private double[] value;
    private double doubleValue;
    private String strValue;

    public Vector(double[] values) {
        this.value = values;
    }



    @Override
    public Var add(Var other) {
        double[] result = Arrays.copyOf(value, value.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + s;
                return  new Vector(result);
            }
        } else if (other instanceof Vector) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + new Vector((Vector) other).value[i];
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
        this.value = other.value;
    }

    public Vector(String strValue) {
        this.doubleValue = Double.parseDouble(strValue);
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
