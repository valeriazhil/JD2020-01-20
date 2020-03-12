package by.it.bunkov.jd02_02;


import java.util.Random;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private int number;
    private boolean pensioner;
    private Backet backet;
    private Good chosenGood;

    public Buyer() {
        this(Dispatcher.getTotalBuyersCount() + 1);
    }

    public Buyer(int number) {
        this(number, new Random().nextDouble() <= 0.25);
    }

    public Buyer(int number, boolean pensioner) {
        super((pensioner ? "Pensioner" : "Buyer") + " #" + number);
        this.number = number;
        this.pensioner = pensioner;
        Dispatcher.increaseBuyersCount();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    private double getSpeedRate() {
        return isPensioner() ? Helper.getPensionerDecelerationRate() : 1.0;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public int getNumber() {
        return number;
    }

    public Backet getBasket() {
        return backet;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    private void printToConsole(String str) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < this.getNumber(); i++) {
            out.append(' ');
        }
        out.append(this.getName()).append(str);
        System.out.println(out.toString());
    }

    @Override
    public void enterToMarket() {
        printToConsole(" entered to the shop");
    }

    private void sleepChooseGoods() {
        try {
            sleep((long) (Helper.getTimeToChoose() * getSpeedRate()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chooseGoods() {
        for (int i = 0; i < Helper.getGoodsCount(); i++) {
            sleepChooseGoods();
            chosenGood = Helper.chooseGood();
            printToConsole(" chose good " + (i + 1));
            putGoodsToBasket();
        }
    }

    @Override
    public void goOut() {
        sleepGoOut();
        printToConsole(" left the shop");
        Dispatcher.decreaseCurrentBuyersCount();
    }

    private void sleepGoOut() {
        try {
            sleep((long) (Helper.getGoOutTime() * getSpeedRate()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeBasket() {
        backet = new Backet();
        printToConsole(" took a basket");
    }

    @Override
    public void putGoodsToBasket() {
        backet.addGood(chosenGood);
        printToConsole(
                " put " + chosenGood.getName() + " for " + chosenGood.getPrice() + " into the basket");
    }

    @Override
    synchronized public void goToQueue() {
        printToConsole(" go to the queue");
        try {
            BuyerQue.add(this);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



