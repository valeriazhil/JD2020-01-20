package by.it.kondratev.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Backet {


    List<String> list = new ArrayList<>();

    
    @Override
    public String toString() {
        return "Корзина: "+ list;
    }
}
