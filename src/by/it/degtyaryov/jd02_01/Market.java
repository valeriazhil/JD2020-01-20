package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Market {

    public static final List<Good> ALL_GOODS = new ArrayList<>(Arrays.asList(
            new Good("Milk", 2.1),
            new Good("Bread", 0.7),
            new Good("Beer", 1.3),
            new Good("Sweets", 8.99),
            new Good("Eggs", 2.0),
            new Good("Water", 1.0)));

    private List<Buyer> buyers = new ArrayList<>(1000);

    public void start(int workTime) {
        for (int time = 0; time < workTime; time++) {
            int buyersToEnter = Dispatcher.getBuyerToEnterByTime(time);
            for (int i = 0; i < buyersToEnter; i++) {
                Buyer buyer = new Buyer(Dispatcher.getBuyersCounter(), Helper.getRandomIsPensioner());
                buyers.add(buyer);
                buyer.start();
            }
            System.out.printf("Time: %d sec. Now in market: %d buyers.%n", time, Dispatcher.getBuyersInMarket());
            Helper.sleep(1000);
        }
    }

    public void end() {
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
