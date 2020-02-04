package by.it.kondratev.jd01_07;

import static java.lang.Double.parseDouble;

public class Runner {

    public static void main(String[] args) {
        //Var v1 = new  Scalar(3.1415);
        Var v2 = new Vector(new double[]{1,2,4});
        //Var v3 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        //System.out.println(v1);
        System.out.println(v2);
        //System.out.println(v3);

        /*String strVector = "{1,2,4}";
        strVector = strVector.substring(1, strVector.length() - 1);
        //    strVector.(',','n');
        System.out.println(strVector);
        //strVector.replace('}',' ');
        //strVector = strVector.trim();
        String[] arr = strVector.split(",");
        double [] mas = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mas[i]=Double.parseDouble(arr[i]);
            System.out.println(arr[i]+"==="+ mas[i]);
        }*/
    }
}

