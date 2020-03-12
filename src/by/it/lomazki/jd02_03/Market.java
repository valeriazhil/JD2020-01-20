package by.it.lomazki.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Market {
    public static void main(String[] args) {

        System.out.println("The market open");
        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            pool.execute(cashier);
        }
        pool.shutdown();


        while (Dispatcher.marketIsOpened()) {
            int currentCount = TimerHelper.random(2);
            for (int i = 0; i < currentCount && Dispatcher.marketIsOpened(); i++) {
                AtomicInteger number = Dispatcher.numberBuyers;
                Buyer buyer = new Buyer(number);
                buyer.start();
            }
            TimerHelper.sleep(1000);
        }

            try {
                while (!pool.awaitTermination(120, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("The market closed");
    }
}
