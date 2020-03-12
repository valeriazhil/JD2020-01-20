package by.it.bunkov.jd02_01;


class Buyer extends Thread implements IBuyer, IUseBacket {

    private int number;
    private boolean pensioner;
    private Backet basket;
    private Good chosenGood;

    public Buyer(int number1, int number2) {
        super("Buyer #" + (number1 + 1) + "." + (number2 + 1));
        this.number = number1;// * Helper.getMaxBuyersByStep() + number2;
        Helper.buyersCount++;
    }

    private double getSpeedRate() {
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

    public Backet getBasket() {
        return basket;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
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
            putGoodsToBacket();
        }
    }




    @Override
    public void goOut() {
        sleepGoOut();
        printToConsole(" left the shop");
        Helper.buyersCount--;
    }

    private void sleepGoOut() {
        try {
            sleep((long) (Helper.getGoOutTime() * getSpeedRate()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void takeBacket() {
        basket = new Backet();
        printToConsole(" took a basket");

    }

    @Override
    public void putGoodsToBacket() {
        basket.addGood(chosenGood);
        printToConsole(" put " + chosenGood.getName() + " for " + chosenGood.getPrice() + " into the basket");


    }
}



