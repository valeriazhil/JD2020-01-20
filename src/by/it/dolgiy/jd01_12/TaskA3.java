package by.it.dolgiy.jd01_12;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list =new ArrayList<>();
        int pos = 0;
        while (true){
            String text = scanner.next();
            if (text.equals("end"))
                break;
            Integer value = Integer.valueOf(text);
            if (value<0)
                list.add(value);
            else if (value==0)
                list.add(pos,value);
            else
                list.add(pos++,value);
        }
        System.out.println(list);
    }

}
