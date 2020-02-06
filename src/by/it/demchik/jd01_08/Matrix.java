package by.it.demchik.jd01_08;
import java.util.Arrays;
class Matrix extends Var{
   private double[][]value;

    @Override
    public Var add(Var other) {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    public Matrix(String m) { }

    @Override
    public String toString() {
        return "Matrix";
    }

}
