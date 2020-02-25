package by.it.degtyaryov.jd02_01;

class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choosing goods.");
        Helper.sleep(Helper.getRandom(500, 2000));
        System.out.println(this + " end choosing goods.");
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
