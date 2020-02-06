package by.it.zhuravaskarabahataya.jd01_08.oop;

public class Main {

    public static void main(String[] args) {
        Surgeon Vladimir = new Neurosurgeon("Vladimir");
        Surgeon Ararat = new Neurosurgeon();
        Surgeon Evdakim = new PlasticSurgeon();
        Vladimir.treat();
        Evdakim.treat();

        Surgeon Nikolasha = new Intern("Николаша");
        Nikolasha.operate();
        Vladimir.operate(Nikolasha);
        System.out.println(Vladimir.salarySurgeon);
    }
}
