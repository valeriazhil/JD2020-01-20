package by.it.degtyaryov.jd01_10;

class Bean {

    @Param(a = 10, b = 20)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    static double sum(int a, int b) {
        return (double) a + b;
    }

    @Param(a = 30, b = 40)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 50, b = 60)
    double min(int a, int b) {
        return Math.min(a, b);
    }
}
