package by.it.demchik.jd01_12;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Map<String,Integer> list=new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.equals("end")) {
                break;
            } else {
                s=s.replaceAll("[^\\w']+","");
                if(list.containsKey(s)){
                    list.put(s,list.get(s)+1);
                }else {
                    list.put(s,1);
                }
            }
        }
        System.out.println(list);
    }
}
