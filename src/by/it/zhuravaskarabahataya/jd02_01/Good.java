package by.it.zhuravaskarabahataya.jd02_01;

import java.util.*;

class Good {
    private String name;
    private int price;

    Good( String name, int price){
        this.name = name;
        this.price = price;
        goods.put(name, price);
    }

    static HashMap<String, Integer> goods = new HashMap<>();

    static Good takeGood(){
        List<String> namesOfGoods = new ArrayList<>(goods.keySet());
        int randomGoodNumber = (int)(Math.random()*(namesOfGoods.size()));
        String chosenName = namesOfGoods.get(randomGoodNumber);
        int chosenPrice = goods.get(chosenName);
        return new Good(chosenName, chosenPrice);
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
