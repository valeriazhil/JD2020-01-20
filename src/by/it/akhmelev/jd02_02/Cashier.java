package by.it.akhmelev.jd02_02;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "\tCashier № " + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + "opened");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + "started service for " + buyer);
                int timeout = Helper.random(2000, 5000);
                Helper.sleep(timeout);
                System.out.println(this + "finished service for " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Helper.sleep(1); //
            }
        }
        System.out.println(this + "closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
