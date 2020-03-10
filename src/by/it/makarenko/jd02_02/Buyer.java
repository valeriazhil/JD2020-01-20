package by.it.makarenko.jd02_02;

public class Buyer extends Thread implements IBuyer {
    int number;

    Buyer(int number){
        super("Buyer number "+number);
        Dispatcher.newBuyer();
        this.number = number;

    }

    @Override
    public void run(){
        enterToMarket();
        chooseGoods();
        goToQueue();
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
    public void goToQueue(){
        System.out.println(this+" go to queue");
        synchronized (this){
            try {
                QueueBuyer.add(this);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " Go away");
        Dispatcher.buyerLeaveInMarket();
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
