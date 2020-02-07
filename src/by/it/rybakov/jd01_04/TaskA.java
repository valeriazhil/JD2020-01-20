package by.it.rybakov.jd01_04;

public class TaskA {

    static void printMulTable(){
        for (int i = 2; i <=9; i++) {
            for (int j = 2; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
            
        }

    }
    public static void main(String[] args) {
        printMulTable();

    }
    static void buildOneDimArray(String line){



    }
}
