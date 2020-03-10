package by.it.zhuravaskarabahataya.jd02_01;

import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket {

    int number;
    boolean pensioner;
    Basket personalBusket;

    Buyer(int number) {
        super("Buyer №" + number);
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
       // payForGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter the market.");
        Dispatcher.buyersInMarket ++;
        if (this.pensioner){
            System.out.println("And he is a pensioner.");
        }
    }


    @Override
    public void takeBacket() {
        int timeout = (int)(TimingHelper.random(500, 2000) * pensionerSlowdown());
        TimingHelper.sleep(timeout);
        personalBusket = new Basket();
        System.out.println("Buyer №" + this.number + " took a basket.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing goods.");
        int timeout = (int)(TimingHelper.random(500, 2000) * pensionerSlowdown());
        putGoodsToBacket();
        TimingHelper.sleep(timeout);
        System.out.println(this + " finished choosing goods.");
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
        int timeout = (int)(TimingHelper.random(500, 2000) * pensionerSlowdown());
        for (int i = 0; i < this.personalBusket.capacity; i++) {
            putOneProductToBasket(timeout);
        }
    }

    void putOneProductToBasket(int timeout){
            TimingHelper.sleep(timeout);
            Good takenGood = Good.takeGood();
            int price = takenGood.getPrice();
            Map thisBusket = this.personalBusket.basketGoods;
            if (thisBusket.containsKey(takenGood)){
                int newPrice = (int) thisBusket.get(takenGood) + price;
                thisBusket.replace(takenGood, newPrice);
            }
            else {
                this.personalBusket.basketGoods.put(takenGood, price);
            }
            this.personalBusket.totalPrice += price;
            System.out.println("Buyer №" + this.number + " put " + takenGood.getName() + " into a basket.");
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
        Dispatcher.buyersInMarket --;
        Dispatcher.completeBuyer++;
    }
}
