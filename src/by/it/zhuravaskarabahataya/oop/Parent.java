package by.it.zhuravaskarabahataya.oop;

class Parent {
    static String parentssWord = "Hello!";

    String parentNonStfticWord;

    public Parent(String word) {
        System.out.println("Parent's constructor");
        System.out.println(parentNonStfticWord);

        this.parentNonStfticWord = word;
        System.out.println(parentNonStfticWord);
    }

    public static void go() {
        System.out.println("GO parent");
    }

    public void work() {
        System.out.println("parent is working");
    }

}
