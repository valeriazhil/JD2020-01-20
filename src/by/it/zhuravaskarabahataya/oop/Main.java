package by.it.zhuravaskarabahataya.oop;

class Main {
    static boolean a;

    public static void main(String[] args) {
        System.out.println(Parent.parentssWord);
        System.out.println(Kid.kidsWord);
        System.out.println();
        Parent p = new Parent("I'm parent");
        Kid k = new Kid("I'm a kid");
        Parent pk = new Kid("I'm hybrid");
        pk.work();
        if (!a)
        System.out.println(a);
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a==b);


    }
}

