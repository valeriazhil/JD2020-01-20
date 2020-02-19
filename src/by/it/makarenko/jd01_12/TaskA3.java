package by.it.makarenko.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int posZero = 0;
        while (true){
            String txt = sc.next();
            if (txt.equals("end"))
                break;
            Integer value = Integer.valueOf(txt);
            if(value<0)
                list.add(value);
            else if (value==0)
            list.add(posZero,value);
            else list.add(posZero++,value);
        }
        System.out.println(list);
    }
}
