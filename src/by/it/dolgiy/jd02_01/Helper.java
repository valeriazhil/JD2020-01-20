package by.it.dolgiy.jd02_01;

import java.util.HashMap;
import java.util.Random;

class Helper {

    private static Random rnd = new Random();

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.err.println("Error:"+e);
        }
    }

    static int random(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    static int random(int max) {
        return random(0, max);
    }

//    static HashMap<String, Integer> shoppingList = new HashMap<String, Integer>(){
//        {
//            shoppingList.put("sausage",30);
//            shoppingList.put("cheese",20);
//            shoppingList.put("milk",10);
//            shoppingList.put("eggs",25);
//            shoppingList.put("beer",15);
//        }
//    };

    static HashMap<String, Integer> shoppingList() {
        HashMap<String,Integer> shoppingList = new HashMap<>();
        shoppingList.put("sausage",30);
        shoppingList.put("cheese",20);
        shoppingList.put("milk",10);
        shoppingList.put("eggs",25);
        shoppingList.put("beer",15);
        return shoppingList;
    }
//захешилось по приколу сыр = 5.
}
