package by.it.akhmelev.jd01_10;

public class Bean {

    @Param(a=10,b=20)
    double max(int a, int b){
        return a<b?b:a;
    }

    @Param(a=15,b=25)
    static double min(int a, int b){
        return a>b?b:a;
    }

    double avg(int a, int b){
        return (a+b)/2.0;
    }

    @Param(a=30,b=50)
    static double sum(int a, int b){
        return a+b;
    }





}
