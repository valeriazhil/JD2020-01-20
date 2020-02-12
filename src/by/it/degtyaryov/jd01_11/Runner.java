package by.it.degtyaryov.jd01_11;

import java.util.ArrayList;
import java.util.List;

class Runner {

    public static void main(String[] args) {
        List<String> arr = new ListA();
        arr.add("Hello");
        arr.add("World");
        arr.add("!");
        arr.add("?");
        System.out.println(arr);

        arr.add(2, "My value");
        System.out.println(arr);

        List<String> ar1 = new ArrayList<>();
        ar1.add("new");
        ar1.add("val");

        arr.addAll(ar1);
        System.out.println(arr);

        System.out.println(arr.get(5));
    }
}
