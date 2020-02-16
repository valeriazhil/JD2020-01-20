package by.it.anackij.jd01_10;

public class Bean {

    @Param(a =10,b=14)
    double max(int a, int b) {
        return a < b ? b : a;
    }

    @Param(a =30,b=15)
    double min(int a, int b) {
        return (a > b ? b : a);
    }

    @Param(a =20,b=10)
   static double avg(int a, int b) {
        return (a + b) / 2;
    }


    static double sum(int a, int b) {
        return a + b;
    }
}
