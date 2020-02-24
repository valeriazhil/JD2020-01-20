package by.it.makarenko.jd02_01;

public class Buyer extends Thread implements IBuyer {

    Buyer(int number){
        super("Buyer number "+number);
    }
    @Override
    public void run(){

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Enter in market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " starte chooising goods");
        int timeout = HelperTime.random(500, 2000);
        HelperTime.sleep(timeout);
        System.out.println(this + " stoped chooising goods");

    }

    @Override
    public void goOut() {
        System.out.println(this + "Go away");
        Dispatcher.completeBuyer++;
    }


    @Override
    public String toString() {
        return getName();
    }
}
