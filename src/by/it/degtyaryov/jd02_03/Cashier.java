package by.it.degtyaryov.jd02_03;

import java.util.List;

class Cashier implements Runnable {

    private static int counter = 0;
    private final int id = counter++;

    private final CashierManager manager;
    private final Reporter reporter = new Reporter();
    private final String name;
    private boolean isWorked;

    public Cashier(CashierManager manager) {
        this.name = "\tCashier №" + id;
        this.manager = manager;
    }

    @Override
    public void run() {
        System.out.printf("%s start working day.%n", this);
        while (manager.marketIsOpen()) {
            if (isWorked) {
                Buyer buyer = Queue.get();
                if (buyer != null) {
                    calculateBuyer(buyer);
                }
            } else {
                Helper.sleep(100);
            }
        }
        System.out.printf("%s end working day.%n", this);
    }

    public void resume() {
        System.out.printf("%s resume work.%n", this);
        isWorked = true;
    }

    public void pause() {
        System.out.printf("%s pause work.%n", this);
        isWorked = false;
    }

    private void calculateBuyer(Buyer buyer) {
        Basket basket = buyer.getBasket();
        List<Good> buyerGoods = basket.getGoods();
        System.out.printf("%s start calculating %s.%n", this, buyer);
        for (Good good : buyerGoods) {
            System.out.printf("%s is calculating %s.%n", this, good);
        }
        Helper.sleep(Helper.getRandom(2000, 5000));
        System.out.printf("%s end calculating %s. His total sum is %.2f.%n", this, buyer, basket.getSum());
        Market.addToTotalIncome(basket.getSum());
        reporter.printReport(id, basket);
        synchronized (buyer) {
            buyer.endWaiting();
            buyer.notify();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
