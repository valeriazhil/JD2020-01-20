package by.it.lomazki.jd02_03;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "\tCashier № " + number;
    }

    @Override
    public void run() {
        System.out.println(this + "Opened");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.println(this + "started service for" + buyer);
                int timeout = TimerHelper.random(2000, 5000);
                TimerHelper.sleep(timeout);
                System.out.println(this + "finished service for" + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                TimerHelper.sleep(1);
            }
        }
        System.out.println(this + "Closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
