package by.it.zhuravaskarabahataya.jd02_03;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {

    int number;
    boolean pensioner;
    Basket personalBasket;
    private boolean waitingState = false;

    public void setWaitingState(boolean waitingState) {
        this.waitingState = waitingState;
    }

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
    public void takeBacket() {
        int timeout = (int) (TimingHelper.random(500, 2000) * pensionerSlowdown());
        TimingHelper.sleep(timeout);
        personalBasket = new Basket();
        ScreenPrinter.printTakeBasket(this);
    }

    @Override
    public void chooseGoods() {
        ScreenPrinter.printSmth(this, " started choosing goods.");
        int timeout = (int) (TimingHelper.random(500, 2000) * pensionerSlowdown());
        putGoodsToBacket();
        TimingHelper.sleep(timeout);
        ScreenPrinter.printSmth(this, " finished choosing goods.");
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
        Map thisBusket = this.personalBasket.basketGoods;
        if (thisBusket.containsKey(takenGood)) {
            int newPrice = (int) thisBusket.get(takenGood) + price;
            thisBusket.replace(takenGood, newPrice);
        } else {
            this.personalBasket.basketGoods.put(takenGood, price);
        }
        this.personalBasket.totalPrice += price;

        System.out.println("Buyer №" + this.number + " put "
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
        System.out.println(this + " go out.");
        Dispatcher.buyerLeaveTheMarket();
    }
}
