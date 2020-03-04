package by.it.gerasimov.jd02_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Shop {

    public static void main(String[] args) throws InterruptedException {
        Helper.setSpeed(100);
        Helper.generatePriceList();
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        List<Integer> count = new LinkedList<>();
        for (int i = 0; Dispatcher.shopIsOpened(); i++) {
            for (int j = 0; j < Dispatcher.getBuyersCountByStep(i) && Dispatcher.shopIsOpened(); j++) {
                Buyer buyer = new Buyer();
                threads.add(buyer);
                buyer.start();
            }
            count.add(Dispatcher.getCurrentBuyersCount());
            Thread.sleep(1000 / Helper.getSpeed());
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("The shop don't wait " + thread.getName());
            }
        }
        System.out.println("The shop closed");
        for (int i = 0; i < count.size(); i++) {
            System.out.printf("%2d ", count.get(i));
            if ((i + 1) % 60 == 0) {
                System.out.println();
            }
        }
    }
}
