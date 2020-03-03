package by.it.degtyaryov.jd02_02;

import java.util.List;

class Cashier extends Thread {

    public Cashier(int number) {
        super("\tCashier №" + number);
    }

    @Override
    public void run() {
        System.out.printf("%s start working.%n", this);
        while (!Dispatcher.allBuyersComplete()) {
            Buyer buyer = Queue.get();
            if (buyer != null) {
                calculateBuyer(buyer);
            } else {
                Helper.sleep(100);
            }
        }
        System.out.printf("%s end working.%n", this);
    }

    private void calculateBuyer(Buyer buyer) {
        System.out.printf("%s start calculating %s.%n", this, buyer);
        List<Good> buyerGoods = buyer.getBasket().getGoods();
        for (Good good : buyerGoods) {
            System.out.printf("%s is calculating %s.%n", this, good);
        }
        Helper.sleep(Helper.getRandom(2000, 5000));
        System.out.printf("%s end calculating %s.%n", this, buyer);
        synchronized (buyer) {
            buyer.notify();
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
