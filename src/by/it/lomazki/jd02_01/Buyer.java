package by.it.lomazki.jd02_01;

class Buyer extends Thread implements IBuyer {


    public Buyer(int number) {
        super("Buyer " + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
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
    public void goOut() {
        System.out.println(this + " leave the Market");
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
