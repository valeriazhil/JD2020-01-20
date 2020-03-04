package by.it.kondratev.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Backet {

    List<String> list = new ArrayList<>();

    @Override
    public String toString() {
        return "Корзина: "+ list;
    }
}
