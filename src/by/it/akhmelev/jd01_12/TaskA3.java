package by.it.akhmelev.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int posZero=0;
        while (true){
            String text = scanner.next();
            if (text.equals("end"))
                break;
            Integer value = Integer.valueOf(text);
            if (value<0)
                list.add(value);
            else if (value==0)
                list.add(posZero,value);
            else
                list.add(posZero++,value);
        }
        System.out.println(list);

    }
}
