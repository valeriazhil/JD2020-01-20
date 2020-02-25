package by.it.degtyaryov.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Backet {

    private List<Good> goods = new ArrayList<>();

    public void putInBacket(Good item) {
        goods.add(item);
    }

    @Override
    public String toString() {
        StringBuilder backet = new StringBuilder();
        for (Good item : goods) {
            backet.append(item);
            backet.append("; ");
        }
        return backet.toString();
    }
}
