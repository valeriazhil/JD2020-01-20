package by.it.dolgiy.jd01_08;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var{

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value=new double[value.length];
        for (int i = 0; i < this.value.length; i++) {
                this.value[i] = value[i];
        }
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[\\d\\\\.\\d]+");
        Matcher matcher = pattern.matcher(strVector);
        double[] strVector1 ={};
        while (matcher.find()) {
            String word = matcher.group();
            int last = strVector1.length;
            strVector1 = Arrays.copyOf(strVector1, last + 1);
            strVector1[last] = Double.parseDouble(word);
        }
        this.value = strVector1;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] add1 = Arrays.copyOf(value,value.length);
            for (int i = 0; i < add1.length; i++) {
                add1[i]=add1[i]+((Scalar) other).getValue();
            }
            return new Vector(add1);
        }
        else if (other instanceof Vector){
            double[] add1 = Arrays.copyOf(value,value.length);
            for (int i = 0; i < add1.length; i++) {
                add1[i]=add1[i]+((Vector) other).value[i];
            }
            return new Vector(add1);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] sub1 = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub1.length; i++) {
                sub1[i]=sub1[i]-((Scalar) other).getValue();
            }
            return new Vector(sub1);
        }
        else if (other instanceof Vector){
            double[] sub1 = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub1.length; i++) {
                sub1[i]=sub1[i]-((Vector) other).value[i];
            }
            return new Vector(sub1);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] mul1 = Arrays.copyOf(value,value.length);
            for (int i = 0; i < mul1.length; i++) {
                mul1[i]=mul1[i]*((Scalar) other).getValue();
            }
            return new Vector(mul1);
        }
        else if (other instanceof Vector){
            double[] mul1 = Arrays.copyOf(value,value.length);
            for (int i = 0; i < mul1.length; i++) {
                mul1[i]=mul1[i]*((Vector) other).value[i];
            }
            return new Vector(mul1);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] div1 = Arrays.copyOf(value,value.length);
            for (int i = 0; i < div1.length; i++) {
                div1[i]=div1[i]/((Scalar) other).getValue();
            }
            return new Vector(div1);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
