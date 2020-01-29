package by.it.lomazki.Example;

public class Example {
    public static class Var {
        public static int sum(int a, int b) {
            return a + b;
        }

        public static void main(String[] args) {
            int j = 10;
            int k = 0;
            for (int i = 0; i < 4; i++) {
                int c=2;
                k = k+c;
            }
            int s = sum(j,k);
            System.out.println(s);
            System.out.println(s + p);
        }

        public static int p = 5;
        public  int in = 6;
    }
}
