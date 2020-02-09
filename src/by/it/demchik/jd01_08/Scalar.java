package by.it.demchik.jd01_08;

class Scalar extends Var {
    private double value;


    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum=this.value+((Scalar)other).value;
            return new Scalar(sum);
        }
else
    return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
        double min=this.value-((Scalar)other).value;
        return new Scalar(min);
    }
    else
        return other.add(this);
    }

    @Override
    public Var mul(Var other) {  if (other instanceof Scalar){
        double mn=this.value*((Scalar)other).value;
        return new Scalar(mn);
    }
    else
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double del=this.value/((Scalar)other).value;
            return new Scalar(del);
        }
        else
            return other.add(this);

    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }
    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
