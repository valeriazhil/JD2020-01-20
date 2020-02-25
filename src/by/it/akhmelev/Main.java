package by.it.akhmelev;


import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        double sum=10; int count=4;
        Locale.setDefault(new Locale("ru","RU"));
        System.out.printf(Locale.US,"avg=%1f",sum / count);
    }


}
