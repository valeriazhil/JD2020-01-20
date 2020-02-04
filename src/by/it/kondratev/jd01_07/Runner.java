package by.it.kondratev.jd01_07;

import static java.lang.Double.parseDouble;

public class Runner {

    public static void main(String[] args) {
        //Var v1 = new  Scalar(3.1415);
        //Var v2 = new Vector(new double[]{1,2,4});
        //Var v3 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        //System.out.println(v1);
        //System.out.println(v2);
        //System.out.println(v3);

        String strVector = "{{1,2,5},{3,4,8},{5,6,9},{7,8,1}}";
        strVector = strVector.substring(1, strVector.length() - 2);
        //    strVector.(',','n');
        //strVector.replace('}',' ');
        //strVector = strVector.trim();
        String[] row = strVector.split("},");
        for (int i = 0; i <row.length ; i++) {
            row[i] = row[i].substring(1);
        }
        String [] cols = row[0].split(",");
        double [][] mas = new double[row.length][cols.length];
        for (int i = 0; i < row.length ; i++) {
            String [] col = row[i].split(",");
            for (int j = 0; j < col.length ; j++) {
                mas [i][j] = Double.parseDouble(col[j]);
                System.out.print(mas [i][j]+" ");
            }
            System.out.println();


        }
        /*double [] mas = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mas[i]=Double.parseDouble(arr[i]);
            System.out.println(arr[i]+"==="+ mas[i]);
        }*/
    }
}

