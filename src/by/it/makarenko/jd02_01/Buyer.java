package by.it.makarenko.jd02_01;

public class Buyer extends Thread implements IBuyer {
    int number;

    Buyer(int number){
        super("Buyer number "+number);
        this.number = number;
    }

    @Override
    public void run(){
        enterToMarket();
        chooseGoods();
        goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " Enter in market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choosing goods");
        int timeout = HelperTime.random(500, 2000);
        HelperTime.sleep(timeout);
        System.out.println(this + " stoped chooising goods");

    }

    @Override
    public void goOut() {
        System.out.println(this + " Go away");
        Dispatcher.completeBuyer++;
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
