package by.it.bunkov.jd02_03;


public class Shop {
    public static void main(String[] args) {
        Helper.setSpeed(100);
        Helper.generatePriceList();
        Dispatcher.generateCashiers();
        Dispatcher.generateCashiers();
        Dispatcher.generateBuyers();
        Dispatcher.joinAll();
        System.out.println("The shop closed");
        Dispatcher.printDynamics();
    }

}
