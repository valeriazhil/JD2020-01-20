package by.it.lomazki.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Buyer extends Thread implements IBuyer {


    public Buyer(AtomicInteger number) {
        super("Buyer " + number);
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
        System.out.println(this + " inter to the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing goods");
        int timeout = TimerHelper.random(500, 2000);
        TimerHelper.sleep(timeout);
        System.out.println(this + " finished choosing goods");

    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to queue");
        synchronized (this){
            try {
                QueueBuyers.add(this);
                this.wait();
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
