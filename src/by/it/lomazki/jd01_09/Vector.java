package by.it.lomazki.jd01_09;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        // {2.0, 3.0, 4.0}
        String[] arrStrVector = strVector.replaceAll("[{} ]+", "").split(",");
        this.value = new double[arrStrVector.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(arrStrVector[i]);
        }
    }



    @Override
    public Var add(Var other) {
//        {3, 2, 6} + 5 = {3+5, 2+5, 6+6}
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);


    }

    @Override
    public Var sub(Var other) {
//      {1.0,                       1.0 - 9.0 = -8.0
//       6.0,    -    9.0   =       6.0 - 9.0 = -3.0
//       8.0}                       8.0 - 9.0 = -1.0
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
//      {1.0,         8.0       {1.0 - 8.0 = -7.0
//       6.0,    -    9.0   =    6.0 - 9.0 = -3.0
//       8.0}         3.0        8.0 - 3.0 =  5.0}
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value, value.length);
            double s=0;
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]*((Vector) other).value[i];
                s = s + res[i];
            }
            return new Scalar(s);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiter).append(value[i]);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}