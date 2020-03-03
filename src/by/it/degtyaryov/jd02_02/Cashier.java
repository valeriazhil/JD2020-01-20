package by.it.degtyaryov.jd02_02;

import java.util.List;

class Cashier extends Thread {

    private boolean open;
    private int number;

    public Cashier(int number) {
        super("\tCashier №" + number);
        CashierManager.cashierInPause(this);
        open = false;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.printf("%s start working day.%n", this);
        while (!Dispatcher.allBuyersComplete()) {
            if (open) {
                Buyer buyer = Queue.get();
                if (buyer != null) {
                    calculateBuyer(buyer);
                }
            }
        }
        System.out.printf("%s end working day.%n", this);
    }

    public void openCash() {
        System.out.printf("%s resume work.%n", this);
        open = true;
    }

    public void closeCash() {
        System.out.printf("%s pause work.%n", this);
        open = false;
    }

    private void calculateBuyer(Buyer buyer) {
        Check check = new Check();
        List<Good> buyerGoods = buyer.getBasket().getGoods();
        System.out.printf("%s start calculating %s.%n", this, buyer);
        for (Good good : buyerGoods) {
            System.out.printf("%s is calculating %s.%n", this, good);
            check.add(good);
        }
        Helper.sleep(Helper.getRandom(2000, 5000));
        System.out.printf("%s end calculating %s. His total sum is %.2f.%n", this, buyer, check.getSum());
        Reporter.printReport(this.number, check);
        synchronized (buyer) {
            buyer.notify();
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
