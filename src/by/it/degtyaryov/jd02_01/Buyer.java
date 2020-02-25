package by.it.degtyaryov.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private Backet backet = new Backet();
    private Good chosenGood;


    Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        int goodToBuy = Helper.getRandom(1, 4);
        for (int i = 0; i < goodToBuy; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        System.out.printf("%s end choosing of %d goods and his basket contains: %s%n",
                this, goodToBuy, backet.toString().toLowerCase());
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
        chosenGood = Helper.getRandomGood();
        System.out.println(this + " choose " + chosenGood.getName().toLowerCase());
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out from the market.");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " start take backet.");
        Helper.sleep(Helper.getRandom(500, 2000));
        System.out.println(this + " take backet.");
    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this + " start put good in backet.");
        Helper.sleep(Helper.getRandom(500, 2000));
        backet.putInBacket(chosenGood);
        System.out.println(this + " put in backet " + chosenGood.getName().toLowerCase() + ".");
        chosenGood = null;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
