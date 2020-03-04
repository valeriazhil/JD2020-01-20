package by.it.zhuravaskarabahataya.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Market {
    static List<Thread> threads = new ArrayList<>(128);
    static int cashierNeeded;

    public static void main(String[] args) {
        System.out.println("Market is open!");
        Warehouse warehouse = new Warehouse();
        System.out.println("closed?" + Dispatcher.marketIsClosed());
        System.out.println("opened?" + Dispatcher.marketIsOpened());
       // CashierManager.createCashiers();


            ExecutorService pool = Executors.newFixedThreadPool(5);

            for (int i = 1; i <= 2; i++) {
                Cashier cashier = new Cashier(i);
                pool.execute(cashier);
            }
        pool.shutdown();
        int seconds = 0;
        while (Dispatcher.marketIsOpened()) {

            System.out.println();
            System.out.println("\t\tSECOND " + seconds++);
            System.out.println("closed?" + Dispatcher.marketIsClosed());
            System.out.println("opened?" + Dispatcher.marketIsOpened());
            System.out.println();
            System.out.println("buyersInMarket " + Dispatcher.buyersInMarket);
            System.out.println("NumberBuyers " + Dispatcher.numberBuyers);
            System.out.println("CompletedBuyers " + Dispatcher.completedBuyers);
            if (seconds < 30) {
                QueueBuyers.print();
                QueuePens.print();
                for (int i = 0; i < 2; i++) {
                    if (Dispatcher.buyersInMarket.get() < seconds+10){
                        Buyer buyer = new Buyer(Dispatcher.numberBuyers.get() + 1);
                        buyer.start();
                        threads.add(buyer);
                    }
                }

            } else if (seconds <= 59) {
                QueueBuyers.print();
                QueuePens.print();
                if (Dispatcher.buyersInMarket.get() < (70-seconds)){
                Buyer buyer = new Buyer(Dispatcher.numberBuyers.get() + 1);
                buyer.start();
                threads.add(buyer);}
            }
            if (seconds == 59) {
                seconds = 0;
            }


            TimingHelper.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Something happened.");
            }
        }
       // CashierManager.close();
      try{
          while (!pool.awaitTermination(1, TimeUnit.MICROSECONDS));

      }
      catch (InterruptedException e) {
          e.printStackTrace();
      }
        System.out.println(Dispatcher.buyersInMarket);
        System.out.println(Dispatcher.completedBuyers);
        System.out.println(Dispatcher.marketIsClosed());
        System.out.println(Dispatcher.marketIsOpened());
        System.out.println();
        System.out.println("buyersInMarket " + Dispatcher.buyersInMarket);
        System.out.println("NumberBuyers " + Dispatcher.numberBuyers);
        System.out.println("CompletedBuyers " + Dispatcher.completedBuyers);
        System.out.println("Earning today is " + Dispatcher.getRevenue() + ".");
        System.out.println("Market is closed...");
    }
}
