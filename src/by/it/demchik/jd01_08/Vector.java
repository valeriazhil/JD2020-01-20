package by.it.demchik.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public void setValue(double[] value) {
        this.value = value;
    }




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

    Vector(double[]value){this.value=value;}
    Vector(Vector vector){this.value=vector.value;}

    @Override
    public String toString() {return "{" + Arrays.toString(value) +
                '}';
    }
}
