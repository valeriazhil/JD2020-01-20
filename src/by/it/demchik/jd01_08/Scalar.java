package by.it.demchik.jd01_08;

class Scalar extends Var {
    private double value;

    Scalar(double value) {this.value = value;}

    @Override
    public Var add(Var other) {
       if (other instanceof Scalar) {
           double sum = this.value + ((Scalar) other).value;
           return new Scalar(sum);
       }
       else
           return other.add(this);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double def = this.value - ((Scalar) other).value;
            return new Scalar(def);
        }
        else

        return other.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double dr = this.value * ((Scalar) other).value;
            return new Scalar(dr);
        }
        else



        return other.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double z = this.value / ((Scalar) other).value;
            return new Scalar(z);


        }
        return other.div(other);

    }
    Scalar(String str) {this.value = Double.parseDouble(str);}
    Scalar(Scalar scalar) {this.value = scalar.value;}
    @Override
    public String toString() {return Double.toString(value);}
}
