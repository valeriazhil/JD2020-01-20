package by.it.zhuravaskarabahataya.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Market {

    public static void main(String[] args) {
        System.out.println("Market is open!");
        Warehouse warehouse = new Warehouse();

        List<Buyer> buyers = new ArrayList<>(128);
        int countBuyer = 0;
        for (int minutes = 0; minutes < 2; minutes++) {
            for (int seconds = 0; seconds < 30; seconds++) {
                int currentCount = TimingHelper.random(10);
                if (Dispatcher.buyersInMarket < seconds + 10) {
                    for (int i = 0; i < currentCount; i++) {
                        Buyer buyer = new Buyer(++countBuyer);
                        buyers.add(buyer);
                        buyer.start();
                    }
                }
                //System.out.println("Second " + seconds);
               // System.out.println("In the market " + Dispatcher.buyersInMarket + " buyers.");
                TimingHelper.sleep(1000);
            }
            for (int seconds = 31; seconds < 60; seconds++) {
                int currentCount = TimingHelper.random(3);
                if (Dispatcher.buyersInMarket < 40 + (30 - seconds)) {
                    for (int i = 0; i < currentCount; i++) {
                        Buyer buyer = new Buyer(++countBuyer);
                        buyers.add(buyer);
                        buyer.start();
                    }
                }
              //  System.out.println("Second " + seconds);
               // System.out.println("In the market " + Dispatcher.buyersInMarket + " buyers.");
                TimingHelper.sleep(1000);
            }
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("Something happened.");
            }
        }
        System.out.println("Earning today is " + Dispatcher.earning + ".");
        System.out.println("Market is closed...");
    }
}
