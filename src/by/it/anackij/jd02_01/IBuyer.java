package by.it.anackij.jd02_01;

interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void payForGoods();
    void goOut();
}
