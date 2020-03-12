package by.it.zhuravaskarabahataya.oop;

public class Main {
    int x = 0;
    void move(int dx) { x += dx; }

    int getX() {
        return x;
    }

    public static void main(String[] args) throws Exception {
        Child test1 = new Child();
        test1.move(1);
        System.out.println(test1.getX());
    }
}

class Child extends Main {
    float x = 0.0f;
    void move(int dx) {
        move((float) dx);
    }
    void move(float dx) {
        x += dx;
    }
//    float getX() {
//        return x;
//    }
}

//import com.sun.org.apache.xpath.internal.operations.Bool;
//
//import java.util.Map;
//
////class Main {
////    static boolean a;
////    static int b = Main.c;
////    static int c = 9;
////
////    public static void main(String[] args) {
////        System.out.println(Parent.parentssWord);
////        System.out.println(Kid.kidsWord);
////        System.out.println();
////        Parent p = new Parent("I'm parent");
////        Kid k = new Kid("I'm a kid");
////        Parent pk = new Kid("I'm hybrid");
////        Parent parentFromKid = k;
////      //НЕЛЬЗЯ ПРИВОДИТЬ К ПОТОМКУ
////        // Kid fromParent = (Kid) p;
////        pk.work();
//////        if (!a)
//////        System.out.println(a);
//////        Integer a = 129;
//////        Integer b = 129;
//////        System.out.println(a==b);
////        String aa = "kkk";
////        String bb = "kkk";
////        System.out.println(aa==bb);
////        System.out.println(true ? false : true == true ? false : true);
////        String [][] String = {{"JNj"}};
////        System.out.println();
////        System.out.println(b + " " + c);
////        Boolean b1 = new Boolean("true");
////        Boolean b2 = new Boolean("b1");
////        Boolean b3 = new Boolean(false);
////        Boolean b4 = new Boolean("ededb3");
////        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);
//////        Parent obj = new Kid("kmm");
//////        Integer integer = new Integer("100");
//////
//////        System.out.println("/jnk/");
//////        System.out.println("//jnk//");
//////        System.out.println("/*jnk*/");
//////        System.out.println("///jnk///");
//////        System.out.println("/jnk/");
////
////        for (int i = 0; i < 5; i++) {
////            MyThread myThread = new MyThread(i);
////            Thread theThread = new Thread(myThread);
////            theThread.run();
////            theThread.run();
////        }
////
////
////    }
////}
////
////class MyThread implements Runnable{
////    int name;
////
////    MyThread(int number){
////        this.name = number;
////    }
////
////    @Override
////    public void run() {
////        System.out.println("Thread runned" + name);
////    }
////}
//
// class Z {
//    public void print( Object o ) {
//        System.out.println( "Object" );
//    }
//
//    public void print( String str ) {
//        System.out.println( "String" );
//    }
//
////    public void print( Integer i ) {
////        System.out.println( "Integer" );
////    }
//
//    public static void main(String[] args) {
//        switch(10) {
//            case 1:
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            default:
//                break;
//          //  System.out.println("default");
//        }
//        Z z = new Z();
//        z.print( null );
//    }
//}
//
