package by.it.lomazki.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Market {
    public static void main(String[] args) {

        System.out.println("The market open");
        List<Thread> threads = new ArrayList<>(128);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Dispatcher.marketIsOpened()) {
            int currentCount = TimerHelper.random(2);
            for (int i = 0; i < currentCount && Dispatcher.marketIsOpened(); i++) {
                int number = Dispatcher.numberBuyers;
                Buyer buyer = new Buyer(++number);
                threads.add(buyer);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Something stupid");
            }
        }
        System.out.println("The market closed");
    }
}
