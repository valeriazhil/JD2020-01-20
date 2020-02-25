package by.it.degtyaryov.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private Backet backet;
    private Good chosenGood;
    private boolean pensioner;
    private final double speedFactor;

    Buyer(int number, boolean pensioner) {
        super("Buyer №" + number);
        this.backet = new Backet();
        this.pensioner = pensioner;
        this.speedFactor = (pensioner) ? 1.5 : 1;
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
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        chosenGood = Helper.getRandomGood();
        System.out.println(this + " choose " + chosenGood.getName().toLowerCase());
    }

    @Override
    public void goOut() {
		Market.buyerInMarket--;
        System.out.println(this + " go out from the market.");
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " start take backet.");
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        System.out.println(this + " take backet.");
    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this + " start put good in backet.");
        Helper.sleep((int) (Helper.getRandom(500, 2000) * speedFactor));
        backet.putInBacket(chosenGood);
        System.out.println(this + " put in backet " + chosenGood.getName().toLowerCase() + ".");
        chosenGood = null;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    @Override
    public String toString() {
        String age = (pensioner) ? "Pensioner " : "";
        return age + this.getName();
    }
}
