package by.it.bunkov.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class Backet {

    private List<Good> goods = new ArrayList<>();

    public void addGood(Good good) {
        goods.add(good);
    }

    public List<Good> getGoods() {
        return goods;
    }

}
