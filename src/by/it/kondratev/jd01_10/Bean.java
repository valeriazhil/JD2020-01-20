package by.it.kondratev.jd01_10;

public class Bean {

    static double max (int a, int b) {
        return Math.max(a,b);
    }

    @Param(a=2,b=5)
    static double min (int a, int b) {
        return Math.min(a,b);
    }

    @Param(a=20,b=15)
    double sum (int a, int b) {
        return a+b;
    }

    @Param(a=3,b=11)
    double avg (int a, int b) {
        return (a+b)/2.0;
    }
}
