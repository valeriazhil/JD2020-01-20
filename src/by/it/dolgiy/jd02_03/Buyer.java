package by.it.dolgiy.jd02_03;

import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waitingState = false;
    private static Semaphore semaphore = new Semaphore(20);

    void endWait() {
        this.waitingState = false;
    }

    Buyer(int number,String buyer){
        super("Buyer № " + number + buyer);
        Dispatcher.newBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" took a basket");
    }

    @Override
    public void chooseGoods() {
        try {
            semaphore.acquire();
            System.out.println(this+" started choosing goods");
            int timeout = Helper.random(500,2000);
            if (Runner.pensioner){
                timeout = (int) (timeout*1.5);
            }
            Helper.sleep(timeout);
            System.out.println(this+" finished choosing goods");
        } catch (InterruptedException e) {
            System.out.println("Error:"+e);
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " put products to basket");
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" queued");
        synchronized (this){
            try {
                QueueBuyers.add(this);
                waitingState = true;
                while (waitingState){
                    this.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Error:"+e);
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this+" leave the Market");
        Dispatcher.buyerLeaveTheMarket();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
