package by.it.bunkov.jd02_01;


class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Buyer № " + number);
    }


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошёл в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started choosing goods");
        int timeout = Helper.random(500, 2000);
        Helper.sleep(timeout);
        System.out.println(this + " finished choosing goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
        Dispatcher.completeBuyer++;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}



