package by.it.zhilenkova.jd01.jd01_10;



public class Bean {
    @Param(a=10, b=20)
    double sum (int x, int y){
        return x+y;
    }

    static double max (int d, int z){
        return Math.max(d, z); // or d>z?d:z
    }
    @Param(a=10, b=5)
    double min (int a1, int a2){
        return Math.min(a1, a2); // or a1<a2?a1:a2
    }
    @Param(a=20, b=3)
    static double avg (int a, int b){
        return (a+b)/2.0; //без .0 не выйдет вернуть интовое значение
    }
}
