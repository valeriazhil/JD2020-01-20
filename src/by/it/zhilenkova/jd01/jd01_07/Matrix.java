package by.it.zhilenkova.jd01.jd01_07;
import java.util.Arrays;

 class Matrix extends Var {
     private double [][] value;


     Matrix(double[ ][ ] value){
         this.value = value;
     }

     Matrix(Matrix matrix){
         this.value = new double[matrix.value.length][];
         System.arraycopy(matrix.value, 0, this.value, 0, this.value.length);
     }

     //    { { 1.0, 2.0 }, { 3.0, 4.0 } }

     Matrix(String strMatrix){
         strMatrix = strMatrix.replaceAll("[{|}]{2,}", "");
         String[] stringValue = strMatrix.split("[}][\\s]?,[\\s]?[{]");

         this.value = new double[stringValue.length][];
         for (int i = 0; i < stringValue.length; i++) {

             String[] valueStringNumber = stringValue[i].trim().split(",");
             double[] tempArr = new double[valueStringNumber.length];

             for (int j = 0; j < valueStringNumber.length; j++) {
                 tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                 this.value[i] = tempArr;
             }
         }
     }
     @Override
     public String toString() {
         StringBuilder sb  =new StringBuilder("{{");
         String delimeter = "";
         for (double [] row : value){
             for (int i = 0; i <row.length ; i++) {
                 sb.append(delimeter).append(row [i]);
                 delimeter = ", ";
             }
             sb.append("}");
             delimeter = ",{";
         }
         sb.append("}");
         return sb.toString();
     }
 }
