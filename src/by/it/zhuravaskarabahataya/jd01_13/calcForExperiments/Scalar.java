package by.it.zhuravaskarabahataya.jd01_13.calcForExperiments;
//пробдема с делением
class Scalar extends Var implements Operation {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


//    @Override
//    public Var add(Var other) throws CalcException {
//        if (other instanceof Scalar) {
//            double result = this.value + ((Scalar) other).value;
//            return new Scalar(result);
//        }
//        return other.add(this);
//    }

    public Var add(Var other) throws CalcException{
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) throws CalcException {
        double result = this.value + ((Scalar) other).value;
        return new Scalar(result);
    }

    @Override
    public Var add(Vector other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var add(Matrix other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
       return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var sub(Scalar other) throws CalcException {
        double result = this.value - ((Scalar) other).value;
        return new Scalar(result);
    }

    @Override
    public Var sub(Vector other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var sub(Matrix other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
       return other.mul(this);
    }

    @Override
    public Var mul(Scalar other) throws CalcException {
        return new Scalar(other.value*this.value);
    }

    @Override
    public Var mul(Vector other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var mul(Matrix other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div(this);
    }

    @Override
    public Var div(Scalar other) throws CalcException {
        if ( other.value == 0) {
            throw new CalcException("Деление на ноль");
        }
        double result = this.value / ((Scalar) other).value;
        return new Scalar(result);
    }

    @Override
    public Var div(Vector other) throws CalcException {
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) throws CalcException {
        return super.div(other);
    }
}
