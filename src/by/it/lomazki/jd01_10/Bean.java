package by.it.lomazki.jd01_10;

public class Bean {

    @Param(a=4, b=7)
    static double sum (int a, int b) {
        return a+b;
    }
    @Param(a=2, b=1)
    static double min (int a, int b) {
        return (Math.min(a, b));
    }

    double max (int a, int b) {
        return (Math.max(a, b));
    }
    @Param(a=5, b=9)
    double avg (int a, int b) {
        return  (a+b)/2.0;
    }

}
