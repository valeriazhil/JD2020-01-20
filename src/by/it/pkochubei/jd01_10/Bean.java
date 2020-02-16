package by.it.pkochubei.jd01_10;

public class Bean {
    @Param(a = 1, b = 2)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 3, b = 4)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 5, b = 6)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    double min(int a, int b) {
        return Math.min(a, b);
    }
}
