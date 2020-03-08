package by.it.kondratev.jd02_01;

import java.util.List;

class WorkDay {

static final List<String> GOODS_LIST = Good.goodsList();

    public static void main(String[] args) {
        Market market = new Market();
        System.out.println("Магазин открылся");
        market.theDayStarted();
        market.theDayEnded();
        System.out.println("Магазин закрылся");
    }
}
