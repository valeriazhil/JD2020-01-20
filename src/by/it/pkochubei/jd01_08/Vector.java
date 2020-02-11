package by.it.pkochubei.jd01_08;


import java.util.Arrays;

class Vector extends Var {

    private double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    public Vector(String str) {
        String[] strings = str.replace(" ", "")
                .replace("{", "")
                .replace("}", "").split(",");
        values = new double[strings.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(strings[i]);
        }
    }

    public Vector(Vector v) {
        values = Arrays.copyOf(v.values, v.values.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).values[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).values[i];
            }
            return new Vector(res);
        } else
            return super.sub(other);
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
