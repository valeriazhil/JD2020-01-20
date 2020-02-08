package by.it.zhuravaskarabahataya.jd01_08;

public class Runner {
    private static void print(Var var) {System.out.println(var);}
    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector(new double[]{1,2,3}); // закомментируйте вектор и/или
        Var m = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");// матрицу, если вы их не реализовали
        /* Уровень сложности A (калькулятор) */
        // C-V ? C-M ?
        print(s.add(s)); // C+C выведет в консоль 6.0
        print(s.add(v)); // C+В
        print(s.add(m)); // С+М
        print(s.sub(v));
        print(s.sub(m));
        print(s.sub(s)); // С-С выведет в консоль 0.0
        print(s.mul(s)); // С*C Свыведет в консоль 9.0
        print(s.mul(v)); // C*В Работает
        print(s.mul(m)); // C*M Работает
        print(s.div(s)); // C/C выведет в консоль 1.0

        print(v.add(v)); // V+V  выведет в консоль {2.0, 4.0, 6.0}
        print(v.add(s));
        print(v.sub(v)); // V-V  выведет в консоль {0.0, 0.0, 0.0}
        print(v.sub(s)); // V-S  работает
        print(v.sub(m)); // V-M невохможно
        print(v.mul(v)); // V*V  выведет в консоль 14.0
        print(v.div(v)); // V/V  сообщит о невозможности операции

        print(m.add(m)); // M+M  {{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        print(m.sub(m)); // M-M  {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        print(m.sub(v)); // M-V невозможно ????
        print(m.sub(s)); // M-S работает
        print(m.mul(m)); // M*M  {{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(m.mul(v)); // M*V  {14.0, 32.0, 50.0}
        print(v.mul(m)); // V*M  невозможно
        print(v.add(m));
        print(v.mul(s));
        print(v.div(s));
        print(v.div(m));
        print(m.mul(s));
        print(m.div(s));
        print(m.div(v));
        print(m.div(m));
    }
}
