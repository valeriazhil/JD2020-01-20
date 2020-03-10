package by.it.kondratev.calc;


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
        for (int i = 0; i < strings.length; i++) {
            values[i]=Double.parseDouble(strings[i]);
        }
    }

    public Vector(Vector v) {
        values = Arrays.copyOf(v.values,v.values.length);
    }

    public double [] getValue() {
        return values;
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + s;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( result.length != ((Vector) other).values.length)
                throw new CalcException ("Невозможна операция над векторами разной длины");
            else {
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] + ((Vector) other).values[i];
                }
                return new Vector(result);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] result = Arrays.copyOf(values, values.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - s;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if ( result.length != ((Vector) other).values.length)
                throw new CalcException ("Невозможна операция над векторами разной длины");
            else {
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] - ((Vector) other).values[i];
                }
                return new Vector(result);
            }
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * s;
            }
            return new Vector(result);
        } else if (other instanceof Vector)
            if ( this.values.length != ((Vector) other).values.length)
                throw new CalcException ("Невозможна операция над векторами разной длины");
            else {
                double result = 0;
                for (int i = 0; i < values.length; i++) {
                    result += values[i] * ((Vector) other).values[i];
                }
                return new Scalar(result);
            }
            else return super.add(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar)other).value == 0)
                throw new CalcException("Деление на ноль");
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
