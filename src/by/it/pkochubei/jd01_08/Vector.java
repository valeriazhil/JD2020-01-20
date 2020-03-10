package by.it.pkochubei.jd01_08;

import java.util.Arrays;

class Vector  extends Var {

    private double[] value;

    Vector(double[ ] value) {
        this.value=value;
    }



    Vector (Vector vector) {
        this.value=vector.value;
    }

    Vector(String str) {
        String[] part = str.replace("{", "")
                .replace("}", "")
                .replace(" ", "")
                .split(",");

        value=new double[part.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(part[i]);
        }


    }

    @Override
    public Var add(Var other) {
        double[] result = Arrays.copyOf(value, value.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] += s;
            }
            return new Vector(result);
        }
        if (other instanceof Vector) {
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[] result = Arrays.copyOf(value, value.length);
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] -= s;
            }
            return new Vector(result);
        }
        if (other instanceof Vector) {
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            int res = 0;
            for (int i = 0; i < value.length; i++) {
                res += value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return  sb.toString();
    }
}
