package by.it.kondratev.Calculator;


import java.util.Arrays;

class Vector extends Var {

    private double[] values;

    Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(String str) {
        String[] strings = str.replace(" ", "")
                .replace("{", "")
                .replace("}", "").split(",");
        values=new double[strings.length];
        for (int i = 0; i < values.length; i++) {
            values[i]=Double.parseDouble(strings[i]);
        }
    }

    public Vector(Vector v) {
        values=Arrays.copyOf(v.values,v.values.length);
    }

    public double [] getValue() {
        return values;
    }

    @Override
    public Var add(Var other) {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + s;
            }
            return new Vector(result);
        } else if ((other instanceof Vector && result.length==((Vector) other).values.length)) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - s;
            }
            return new Vector(result);
        } else if ((other instanceof Vector && result.length==((Vector) other).values.length)) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * s;
            }
            return new Vector(result);
        } else if (other instanceof Vector && values.length==((Vector) other).values.length) {
            double result = 0;
            for (int i = 0; i < values.length; i++) {
                result += values[i] * ((Vector) other).values[i];
                }
                return new Scalar(result);
            } else return super.add(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double[] result = Arrays.copyOf(values, values.length);
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / s;
            }
            return new Vector(result);
        } else return super.add(other);
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
