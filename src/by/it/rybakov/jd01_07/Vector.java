package by.it.rybakov.jd01_07;

import java.util.Arrays;

class Vector  extends  Var{

    private double[] value;

    Vector(double[ ] value) {
        this.value=value;
    }



    Vector (Vector vector) {
        this.value=vector.value;
    }

    Vector(String str) {
        //  {1 ,2 ,4, 8}
        String[] part = str.replace("{", "")
                .replace("}", "")
                .replace(" ", "")
                .split(",");

        value=new double[part.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(part[i]);
        }


    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return  sb.toString();

    }
}

