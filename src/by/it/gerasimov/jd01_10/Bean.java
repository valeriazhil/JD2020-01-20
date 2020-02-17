package by.it.gerasimov.jd01_10;

class Bean {

    @Param(a = 3, b = 2)
    static double sum(int a, int b) {
        return a + b;
    }
    @Param(a = 3, b = 5)
    static double max(int a, int b) {
        return Math.max(a, b);
    }
    @Param(a = 5, b = 1)
    double min(int a, int b) {
        return Math.min(a, b);
    }
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }


}
