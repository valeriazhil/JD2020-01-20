package by.it.kondratev.jd02_01;

class Buyer extends Thread implements IBuyer{

    Buyer (int number) {
        super("Покупатель № " + number);
    }

    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println("Зашёл в магазин " + this.getName());
    }

    @Override
    public void chooseGoods()  {
        System.out.println("Начал выбирать товары " + this.getName());
        Helper.sleep(Helper.random(500,2000));
        System.out.println("Окончил выбирать товары " + this.getName());
    }

    @Override
    public void goOut() {
        System.out.println("Ушёл из магазина " + this.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
