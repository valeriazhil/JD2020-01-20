package by.it.degtyaryov.jd02_02;

class Cashier extends Thread {

    public Cashier(int number) {
        super("\tCashier №" + number);
    }

    @Override
    public void run() {
        System.out.printf("%s start working.%n", this);
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = Queue.get();
            if (buyer != null) {
                System.out.printf("Start calculating %s.%n", buyer);
                Helper.sleep(Helper.getRandom(2000, 5000));
                System.out.printf("End calculating %s.%n", buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                Helper.sleep(1);
            }
        }
        System.out.printf("%s end working.%n", this);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
