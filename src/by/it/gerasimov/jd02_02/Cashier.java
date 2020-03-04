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
        Dispatcher.increaseServedBuyersCount();
        try {
            Thread.sleep(Helper.getTimeOfCashierService());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " ended serving " + buyer);
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
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name + " closed");
    }
}
