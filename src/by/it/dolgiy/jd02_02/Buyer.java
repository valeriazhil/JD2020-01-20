package by.it.dolgiy.jd02_02;


class Buyer extends Thread implements IBuyer, IUseBasket {

    Buyer(int number,String buyer){
        super("Buyer № " + number + buyer);
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
        Dispatcher.newBuyer();
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" took a basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started choosing goods");
        int timeout = Helper.random(500,2000);
        if (Runner.pensioner){
            timeout = (int) (timeout*1.5);
        }
        Helper.sleep(timeout);
        System.out.println(this+" finished choosing goods");
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " put products to basket");
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" queued");
        synchronized (this){
            QueueBuyers.add(this);
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.err.println("Error:"+e);
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
