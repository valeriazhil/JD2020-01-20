package by.it.zhuravaskarabahataya.oop;

 class Test {
     public static void main(String[] args) {
        new D().start(new B());
     }
}

class A{
}

class B extends A{
}
abstract class C{
     abstract void doAct(A a);
     void start(A a){
         doAct(a);
     }
}
class D extends C{
     void doAct(A a){
         System.out.println("A");
     }
     void doAct(B b){
         System.out.println("B");
     }
}
