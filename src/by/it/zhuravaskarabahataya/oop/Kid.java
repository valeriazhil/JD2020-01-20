package by.it.zhuravaskarabahataya.oop;

class Kid extends Parent {
    static String kidsWord = null;

    String kidNonStfticWord = "nonstat";

    public Kid(String word) {
        super(word);
        System.out.println("Kid's constructor");
        System.out.println(kidNonStfticWord);

        this.kidNonStfticWord = word;
        System.out.println(kidNonStfticWord);
    }

    public static void go() {
        System.out.println("GO KID");
    }

    public void play() {
        System.out.println("kid is working");
    }

    @Override
    public void work() {
        super.work();
        System.out.println("i'm just a kid, i can't work");
    }
}
