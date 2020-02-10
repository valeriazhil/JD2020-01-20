package by.it.makarenko.jd01_09;

class Scalar extends Var {
    public double getValue() {
        return value;
    }

    private double value;


    Scalar(double value){
        this.value=value;
    }

    Scalar(Scalar other){
        this.value = other.value;
    }

    Scalar(String strScalar){
        value=Double.parseDouble(strScalar);
    }


  @Override
  public String toString() {
      return Double.toString(value);
  }

  @Override
  public Var add(Var other) {
        if(other instanceof Scalar){
            double sum = this.value+((Scalar)other).value;
            return new Scalar(sum);
        } else
            return other.add(this);
  }

  @Override
  public Var sub(Var other) {
      if(other instanceof Scalar){
          double minus = this.value-((Scalar)other).value;
          return new Scalar(minus);
      } else
          return new Scalar(-1).mul(other).add(this);
  }

  @Override
  public Var mul(Var other) {
      if(other instanceof Scalar){
          double mul = this.value*((Scalar)other).value;
          return new Scalar(mul);
      } else
          return other.mul(this);
  }

  @Override
  public Var div(Var other) {
      if(other instanceof Scalar){
          double div = this.value/((Scalar)other).value;
          return new Scalar(div);
      } else
          return super.div(other);
  }
}
