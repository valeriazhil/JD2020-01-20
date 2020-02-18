package by.it.demchik.jd01_10;

public class Bean {
    @Param(a=4,b=32)
    static double sum(int a,int b) {
        return a + b;
    }
    @Param(a=14,b=532)
    double avg(int a,int b) {
        return (a + b) / 2.0;
    }
    @Param(a=43,b=312)
    static double min(int a,int b) {
        return Math.min(a, b);
    }

    double max(int a,int b) {
        return Math.max(a, b);
    }
}