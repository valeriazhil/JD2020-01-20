package by.it.gerasimov.jd02_02;

class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "Cashier #" + number;
        Dispatcher.increaseCashierCount();
    }

    @Override
    public String toString() {
        return name;
    }

    private void serve(Buyer buyer) {
        System.out.println(name + " started serving " + buyer);
        double sum = 0;
        for (Good good : buyer.getBasket().getGoods()) {
            sum += Helper.getPriceList().get(good);
        }
        try {
            Thread.sleep(Helper.getTimeOfCashierService());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Dispatcher.increaseServedBuyersCount();
        System.out.printf("%s ended serving %s with sum: %.2f\n", name, buyer, sum);
    }

    @Override
    public void run() {
        System.out.println(name + " opened");
        while (!Dispatcher.shopIsClosed()) {
            Buyer buyer = BuyerQueue.extract();
            if (buyer != null) {
                synchronized (buyer) {
                    serve(buyer);
                    buyer.notify();
                }
            } else {
                synchronized (Dispatcher.OPEN_CASHIER_MONITOR) {
                    try {
                        System.out.println(name + " temporary closed");
                        Dispatcher.decreaseCashierCount();
                        Dispatcher.OPEN_CASHIER_MONITOR.wait();
                        Dispatcher.increaseCashierCount();
                        System.out.println(name + " temporary opened");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(name + " closed");
        synchronized (Dispatcher.OPEN_CASHIER_MONITOR) {
            Dispatcher.OPEN_CASHIER_MONITOR.notifyAll();
        }
    }
}