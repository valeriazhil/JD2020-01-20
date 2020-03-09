package by.it.dolgiy.jd02_02;

import java.util.HashMap;
import java.util.Random;

class Helper {

    private static Random rnd = new Random();

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Dispatcher.K_SPEED);
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

    static boolean random(){
        return rnd.nextBoolean();
    }

    static HashMap<String, Integer> shoppingListMethod() {
        HashMap<String,Integer> shoppingList1 = new HashMap<>();
        shoppingList1.put("sausage",30);
        shoppingList1.put("cheese",20);
        shoppingList1.put("milk",10);
        shoppingList1.put("eggs",25);
        shoppingList1.put("beer",15);
        shoppingList1.put("crisps",10);
        shoppingList1.put("fish",30);
        shoppingList1.put("meat",40);
        return shoppingList1;
    }

    static HashMap<String, Integer> shoppingList = shoppingListMethod();


}
