package by.it.dolgiy.Calc;

import by.it.dolgiy.Calc.translate.CalcErrors;
import by.it.dolgiy.Calc.translate.ResMan;

class Scalar extends Var {

    private double value;
    static ResMan man =  ResMan.INSTANCE;
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
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double add1 = this.value + ((Scalar) other).value;
            return new Scalar(add1);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double sub1 = this.value - ((Scalar) other).value;
            return new Scalar(sub1);
        }
        else
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double mul1 = this.value * ((Scalar) other).value;
            return new Scalar(mul1);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if ((((Scalar) other).value)==0){
                throw new CalcException(man.getString(CalcErrors.DIV_BY_ZERO));
            }
            double div1 = this.value / ((Scalar) other).value;
            return new Scalar(div1);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
