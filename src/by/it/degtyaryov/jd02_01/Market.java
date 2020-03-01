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

    private static final int BUYERS_BEGIN_MINUTE = 10;
    private static final int BUYERS_MIDDLE_MINUTE = 40;

    private List<Buyer> buyers = new ArrayList<>(2000);

    public void startWork(int workTime) {
        int entered = 0;
        for (int time = 0; time < workTime; time++) {
            int mustBeInMarket = getCountMustBeInMarket(time);
            int buyersToEnter = (Dispatcher.buyerInMarket > mustBeInMarket) ?
                    0 : mustBeInMarket - Dispatcher.buyerInMarket;
            for (int i = 0; i < buyersToEnter; i++) {
                boolean isPensioner = Helper.getRandom(1, 4) % 4 == 0;
                Buyer buyer = new Buyer(++entered, isPensioner);
                buyers.add(buyer);
                buyer.start();
            }
            System.out.printf("Time: %d sec. Now in market: %d buyers.%n", time, Dispatcher.buyerInMarket);
            Helper.sleep(1000);
        }
    }

    public void endWork() {
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getCountMustBeInMarket(int time) {
        int count;
        time %= 60; // для привязки к секунде без учета минуты
        if (time < 30)
            count = BUYERS_BEGIN_MINUTE + time;
        else
            count = BUYERS_MIDDLE_MINUTE + (30 - time);
        return count;
    }
}
