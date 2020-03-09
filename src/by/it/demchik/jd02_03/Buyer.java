package by.it.demchik.jd02_03;

class Buyer extends Thread implements IBuyer {

    private boolean waitingState = false;

    void endWait() {
        this.waitingState = false;
    }

    Buyer(int number) {
        super("Buyer № " + number);
        Dispatcher.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing goods");
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished choosing goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " queued");
        synchronized (this) {
            try {
                QueueBuyers.add(this);
                waitingState = true;
                while (waitingState) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " leave the Market");
        Dispatcher.buyerLeaveTheMarket();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
