package by.it.dolgiy.jd01_10;

class Bean {

    @Param(a=2,b=5)
    static double sum (int a, int b){
        return a+b;
    }

    @Param(a=2,b=5)
    double max (int a, int b){
        return Math.max(a, b);
    }

    @Param(a=2,b=5)
    double min (int a, int b){
        return Math.min(a, b);
    }

    static double avg (int a, int b){
        return (a+b)/2.0;
    }

}
