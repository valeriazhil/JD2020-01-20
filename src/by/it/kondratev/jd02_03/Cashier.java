package by.it.kondratev.jd02_03;

class Cashier implements Runnable {

    private static final CheckPrinter printer = new CheckPrinter();

    private static int counter = 0;
    private final int id = counter++;

    private final String name;
    private final CashierManager manager;
    private boolean worked;

    public Cashier(CashierManager manager) {
        this.name = "\tCashier №" + id;
        this.manager = manager;
        this.worked = false;
    }

    @Override
    public void run() {
        System.out.printf("%s start working day.%n", this);
        while (manager.getMarket().isOpened()) {
            if (worked) {
                Buyer buyer = manager.getMarket().getQueue().get();
                if (buyer != null) {
                    calculateBuyer(buyer);
                }
            } else {
                Helper.sleep(100);
            }
        }
        System.out.printf("%s end working day.%n", this);
    }

    private void calculateBuyer(Buyer buyer) {
        System.out.printf("%s start calculating %s.%n", this, buyer);
        Basket basket = buyer.getBasket();
        for (Good good : basket.getGoods()) {
            System.out.printf("%s is calculating %s.%n", this, good);
        }
        Helper.sleep(Helper.getRandom(2000, 5000));
        System.out.printf("%s end calculating %s. His total sum is %.2f.%n", this, buyer, basket.getSum());
        manager.getMarket().addToTotalIncome(basket.getSum());
        printer.print(id, basket, manager.getMarket());
        synchronized (buyer) {
            buyer.endWaiting();
            buyer.notify();
        }
    }

    public void resume() {
        System.out.printf("%s resume work.%n", this);
        worked = true;
    }

    public void pause() {
        System.out.printf("%s pause work.%n", this);
        worked = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
