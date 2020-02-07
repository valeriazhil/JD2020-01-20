package by.it.anackij.jd01_09;


class Scalar extends Var {

    private double value;

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar other) {
        this.value = other.value;
    }

    Scalar(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double result= this.value-((Scalar)other).value;
            return new Scalar(result);
        }else {
            Var minus = new Scalar(-1);
            return other.add(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double result= this.value*((Scalar)other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double result= this.value/((Scalar)other).value;
            return new Scalar(result);
        }
        return super.div(other);
    }

    @Override
    public Var add(Var other){
        if (other instanceof Scalar){
            double result= this.value+((Scalar)other).value;
        return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
