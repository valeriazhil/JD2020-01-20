package by.it.gerasimov.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private int number;
    private boolean pensioner;

    public Buyer(int number1, int number2) {
        super("Buyer #" + (number1 + 1) + "." + (number2 + 1));
        this.number = number1;// * Helper.getMaxBuyersByStep() + number2;
    }

    private double getSpeed() {
        return isPensioner() ? Helper.getPensionerDecelerationRate() : 1.0;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setPensioner(boolean pensioner) {
        if (pensioner && !isPensioner()) {
            setName(getName().replaceFirst("Buyer", "Pensioner"));
        } else if (!pensioner && isPensioner()) {
            setName(getName().replaceFirst("Pensioner", "Buyer"));
        }
        this.pensioner = pensioner;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
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
            sleep((long) (Helper.getTimeToChoose() * getSpeed()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chooseGoods() {
        for (int i = 0; i < Helper.getGoodsCount(); i++) {
            sleepChooseGoods();
            printToConsole(" chose good " + (i + 1));
            putGoodsToBasket();
        }
    }

    @Override
    public void goOut() {
        sleepGoOut();
        printToConsole(" left the shop");
    }

    private void sleepGoOut() {
        try {
            sleep((long) (Helper.getGoOutTime() * getSpeed()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeBasket() {
        printToConsole(" took a basket");
    }

    @Override
    public void putGoodsToBasket() {
        printToConsole(" put good into the basket");
    }
}
