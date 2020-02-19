package by.it.lomazki.Example.yuriy_Tkach;

public class Operation {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }
    static void inspectService (Class<?> service) {
        System.out.println(" ");
    }
}
