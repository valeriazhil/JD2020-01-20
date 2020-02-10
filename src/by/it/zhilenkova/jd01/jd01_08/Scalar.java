package by.it.zhilenkova.jd01.jd01_08;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar (String str){
         this.value = Double.parseDouble(str);
    }

    Scalar (Scalar scalar){
         this.value=scalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value + ((Scalar)other).value;
            return new Scalar(sum);
        }else {
            //5+vector--> vector.add(5)-если other был вектором, то add ищем в векторе
            //5+matrix--> matrix.add(5)-если matrix был матрицей, то add ищем в матрице
           return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double sub = this.value - ((Scalar)other).value;
            return new Scalar(sub);
        }else {
            return new Scalar(-1).mul(other).add(this);
            //5-(1,2,3)-->1*(1,2,3)+5
        }
     }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value * ((Scalar)other).value;
            return new Scalar(mul);
        }else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
         if (other instanceof Scalar){
             double div = this.value/((Scalar)other).value;
             return new Scalar(div);
         }
         return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
