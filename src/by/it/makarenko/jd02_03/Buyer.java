package by.it.makarenko.jd02_03;

import java.util.Map;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private static Semaphore semaphore = new Semaphore(20);
    int number;
    boolean pensioner;
    Basket personalBasket;

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.newBuyerEnterToMarket();
        this.number = number;
        this.pensioner = isPensioner();
    }

    boolean isPensioner() {
        final int PENSIONER_INCIDENT = 4;
        int thisBuyerIncident = (int) (Math.random() * 5);
        return thisBuyerIncident == PENSIONER_INCIDENT;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        // payForGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {

        ScreenPrinter.printEnterTheMarket(this, this.pensioner);
    }

    @Override
    public void goToQueue() {
        ScreenPrinter.printGoToQueue(this);
        synchronized (this) {
            try {
                if (this.pensioner) {
                    QueuePens.add(this);
                } else {
                    QueueBuyers.add(this);
                }
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Basket.basketSemaphore.release();
    }

    @Override
    public void takeBacket() {
        int timeout = (int) (TimingHelper.random(500, 2000) * pensionerSlowdown());
        TimingHelper.sleep(timeout);
        personalBasket = new Basket();
        try {
            Basket.basketSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScreenPrinter.printSmth(this,  " took a basket.");
    }

    @Override
    public void chooseGoods() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScreenPrinter.printSmth(this, " started choosing goods.");
        int timeout = (int) (TimingHelper.random(500, 2000) * pensionerSlowdown());
        putGoodsToBacket();
        TimingHelper.sleep(timeout);
        ScreenPrinter.printSmth(this, " finished choosing goods.");
        semaphore.release();
    }

    private double pensionerSlowdown() {
        if (this.pensioner) {
            return 1.5;
        } else {
            return 1;
        }
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = (int) (TimingHelper.random(500, 2000) * pensionerSlowdown());
        for (int i = 0; i < this.personalBasket.capacity; i++) {
            putOneProductToBasket(timeout);
        }
    }

    void putOneProductToBasket(int timeout) {
        TimingHelper.sleep(timeout);
        Good takenGood = Good.takeGood();
        int price = takenGood.getPrice();
        Map <Good, Integer> thisBusket = this.personalBasket.basketGoods;
        if (thisBusket.containsKey(takenGood)) {
            int newPrice = thisBusket.get(takenGood) + price;
            thisBusket.replace(takenGood, newPrice);
        } else {
            this.personalBasket.basketGoods.put(takenGood, price);
        }
        this.personalBasket.totalPrice += price;

        ScreenPrinter.printSmth(this, " put "
                + takenGood.getName() + "(" + takenGood.getPrice() + " coins) into a basket.");
    }

//    @Override
//    public void payForGoods() {
//        int payment = this.personalBusket.totalPrice;
//        Dispatcher.earning += payment;
//        System.out.println("Buyer №" + this.number + " payed " + payment + ".");
//    }

    @Override
    public void goOut() {
        ScreenPrinter.printSmth(this,  " go out.");
        Dispatcher.buyerLeaveToMarket();
    }
}
