package by.it.makarenko.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private double[] values;

    public Vector(double[] values) {
        this.values =  new double[values.length];
        System.arraycopy(values,0,this.values,0,values.length);
    }

Vector (String strValue){
        String[] sArray = strValue.replace('{',' ')
                .replace('}',' ')
                .trim().split(",\\s*");
        values = new double[sArray.length];
    for (int i = 0; i <values.length ; i++) {
        values[i]=Double.parseDouble(sArray[i]);

    }
}

    Vector(Vector otherVec) {
        this.values = otherVec.values;
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(values,values.length);
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector){
            double[] res = Arrays.copyOf(values,values.length);
            for (int i = 0; i <res.length ; i++) {
                res[i]=res[i]+((Vector)other).values[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public String toString(){
        return Arrays.toString(values).replace('[','{')
                .replace(']','}');
    }
}
