package by.it.lomazki.Example;

public class Example {
    public static void main(String[] args) {

        int s = 0;
        for(int i = 1; i < 10; i++){
            int x = (int) (Math.random()*21-10);
            if(x <= 0)
                continue;
            s = s + x;
        }
        System.out.println(s);
    }
}

