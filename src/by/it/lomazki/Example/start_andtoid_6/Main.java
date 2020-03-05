package by.it.lomazki.Example.start_andtoid_6;

public class Main {

    public static void main(String[] args) {
//
//        System.out.println(sum(6,5));

        Student s = new Student();
        s.setName("Yasya ");
        s.setSecondName("Umnash ");
        String name = s.getName();
        String secondName = s.getSecondName();

        System.out.println(name + secondName);

//        Advice a =new Advice();
//        a.message();

    }
    public static void foo () {
        // тело метода
    }

    public static int sum(int a, int b) {
        int sum = a + b;
        return sum;

    }
}
