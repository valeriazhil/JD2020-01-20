package by.it.anackij.jd02_03;

import java.util.Map;
import java.util.Set;

class ScreenPrinter {

    private static final Object PRINTER_MONITOR = new Object();


    static void printBill(Buyer buyer, Cashier cashier) {
        synchronized (PRINTER_MONITOR) {
            int cashierNumber = cashier.getNumber();
            int columnsToRigth = cashierNumber - 1;
            Map<Good, Integer> thisBill = buyer.personalBasket.basketGoods;
            Set<Map.Entry<Good, Integer>> entries = thisBill.entrySet();
            for (int i = 0; i < columnsToRigth; i++) {
                System.out.printf("%-20s", " ");
            }
            System.out.printf("%-20s\n", " ____________________");
            for (int i = 0; i < 7; i++) {
                if (columnsToRigth == i) {
                    System.out.printf("|%-18s|", cashier.getName());
                } else if (i == 5) {
                    System.out.printf("%8s %-5d", "IN QUEUE", Dispatcher.getBuyersInQueue());
                } else if (i == 6) {
                    System.out.printf("%s%4d\n", "Total revenue ", Dispatcher.getRevenue());
                } else {
                    System.out.printf("%-20s", " ");
                }
            }
            for (Map.Entry<Good, Integer> entry : entries) {
                for (int i = 0; i < columnsToRigth; i++) {
                    System.out.printf("%-20s", " ");
                }
                System.out.printf("|%-15s%5d|\n", entry.getKey().getName(), entry.getValue());
            }
            for (int i = 0; i < columnsToRigth; i++) {
                System.out.printf("%-20s", " ");
            }
            System.out.printf("|%15s%5d|\n", "total:", buyer.personalBasket.totalPrice);
            for (int i = 0; i < columnsToRigth; i++) {
                System.out.printf("%-20s", " ");
            }
            System.out.printf("%-20s\n", "|____________________|");

        }
    }

    public synchronized static void printGoToQueue(Buyer buyer) {
        synchronized (PRINTER_MONITOR) {
            System.out.println(buyer + " go to queue.");
        }
    }

    public static void printEnterTheMarket(Buyer buyer, boolean isPens) {
        synchronized (PRINTER_MONITOR){
            System.out.println(buyer + " enter the market.");
            if (isPens){
                System.out.println("And he is a pensioner...");
            }
        }
    }

    public static void printSmth(Buyer buyer, String s) {
        synchronized (PRINTER_MONITOR){
            System.out.println(buyer.getName() + s);
        }
    }

    public static void printSmthCashier(Cashier cashier, String s) {
        synchronized (PRINTER_MONITOR){
            System.out.println(cashier.getName() + s);
        }
    }



    public static void printThis(String s){
        synchronized (PRINTER_MONITOR){
            System.out.println(s);
        }
    }
}
