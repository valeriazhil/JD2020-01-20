package by.it.rybakov.jd01_08;

import java.util.Arrays;

public class Vector extends Var implements Operation {
    private double[] values;
    public double[] getValues() {return values;}

   public Vector(double[] values){this.values=values;}
   public Vector(Vector other) {this(other.values);}


   @Override
   public Var add(Var other){
        double [] result= Arrays.copyOf(values, values.length);
        if (other instanceof Scalar){
            for (int i = 0; i < result.length; i++) {
                result[i]+= ((Scalar) other).getValue();
            }
            return new Vector(result);
       }else if (other instanceof Vector){
                for (int i = 0; i <values.length ; i++) {
                    result[i] += ((Vector)other).getValues()[i];
                }
                return new Vector(result);

            }
            return super.add(other);



   }
   @Override
   public Var sub(Var other){
        double[] result=Arrays.copyOf(values, values.length);
       if (other instanceof Scalar){
           for (int i = 0; i < result.length; i++) {
               result[i]-= ((Scalar) other).getValue();
           }
           return new Vector(result);
       }else if (other instanceof Vector){
           for (int i = 0; i <values.length ; i++) {
               result[i] -= ((Vector)other).getValues()[i];
           }
           return new Vector(result);

       }
       return super.sub(other);

   }

    @Override
    public Var mul(Var other){
        double[] result=Arrays.copyOf(values, values.length);
        if (other instanceof Scalar){
            for (int i = 0; i < result.length; i++) {
                result[i]*= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }else if (other instanceof Vector){
            int resInt=0;
            for (int i = 0; i <values.length ; i++) {
                resInt+= values[i]*((Vector)other).getValues()[i];
            }
            return new Scalar(resInt);

        }
        return super.mul(other);

    }



    @Override
    public Var div (Var other){
        double[] result=Arrays.copyOf(values, values.length);
        if (other instanceof Scalar){
            if(((Scalar)other).getValue()==0){
                return  null;
            }
            for (int i = 0; i < result.length; i++) {
                result[i]/= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }else if (other instanceof Vector){
            if(result.length!=((Vector)other).getValues().length){
                return  null;
            }
            for (double value:((Vector)other).getValues()){
                if(value==0);
                    return null;
            }
            for (int i = 0; i <values.length ; i++) {
                result[i] /= ((Vector)other).getValues()[i];
            }
            return new Vector(result);

        }
        return super.div(other);

    }



   public Vector(String strValue){
        String[] array;
        array= strValue.trim().replace("{","").replace("}", "").split(" ,");

        values=new double[array.length];
         for (int i = 0; i < array.length; i++) {
             values[i]=Double.parseDouble(array[i]);

         }
     }
     @Override
     public String toString() {
        StringBuilder out=new StringBuilder();
        out.append('{');
        String delimiter="";
        for (double value:values) {
            out.append(delimiter).append(value);
            delimiter=", ";

        }
        out.append('}');
        return out.toString();
    }
}

