package by.it.kondratev.jd02_02;

import java.util.List;
import java.util.Map;

class WorkDay {

static final List<String> GOODS_LIST = Good.goodsList();
static final Map<String, Integer> PRICE_LIST = Good.make_price_list();

    public static void main(String[] args) {
        Market market = new Market();
        System.out.println("Магазин открылся");
        market.theDayStarted();
        market.theDayEnded();
        System.out.println("Магазин закрылся");
    }
}
