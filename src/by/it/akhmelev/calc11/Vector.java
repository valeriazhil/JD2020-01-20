package by.it.akhmelev.calc11;


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
        values=new double[strings.length];
        for (int i = 0; i < values.length; i++) {
            values[i]=Double.parseDouble(strings[i]);
        }
    }

    public Vector(Vector v) {
        values=Arrays.copyOf(v.values,v.values.length);
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
        } else if ((other instanceof Vector)) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
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
