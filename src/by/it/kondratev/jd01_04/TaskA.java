package by.it.kondratev.jd01_04;

public class TaskA {

    public static void main(String[ ] args){
        //printMulTable();
        String  string = "123 99 88 77 66 5 4 3 1 0 2";
        buildOneDimArray(string);

    }

    static void printMulTable(){
        String [][] elem = new String[8][8];
        for (int i = 2; i <10 ; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%1d*%1d=%-3d",i,j,i*j);  }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        line = line.trim();                                //скопировано из InOut ...
        String[] strArr = line.split(" ");
        int count = strArr.length;
        double[] mas = new double[count];
        for (int i = 0; i < count; i++) {
            mas[i] = Double.parseDouble(strArr[i]);        //... скопировано из InOut
        }

        for (int i = 0; i < mas.length ; i++) {
            //System.out.printf("V["+i+"]=%-5.3d  ",mas[i]);
            System.out.print(mas[i]+" ");
            if(i+1==5) System.out.println();
        }

    }
}
