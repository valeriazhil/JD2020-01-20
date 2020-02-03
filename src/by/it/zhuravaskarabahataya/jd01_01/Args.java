package by.it.zhuravaskarabahataya.jd01_01;

public class Args {

    private String[] args;

    void printArgs() {
        int i = 1;
        for (String a : args) {
            i++;
            System.out.println("Аргумент " + i + "=" + a);
        }
    }

    public Args(String[] args) {
        this.args = args;
    }

}
