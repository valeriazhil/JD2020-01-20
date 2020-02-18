package by.it.bunkov.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ListA<>();
        // проверим добавление
        myList.add("First"); arList.add("First");
        myList.add("Two"); arList.add("Two");
        myList.add("Seven"); arList.add("Seven");
        System.out.println("add myList:" +myList+"\narList:"+arList);
        myList.add(2,"Four"); arList.add(2,"Four");
        myList.add(0,"Start"); arList.add(0,"Start");
        System.out.println("add() myList:"+myList+"\narList:"+arList);
        // проверим удаление
        myList.remove("Start"); arList.remove("Start");
        myList.remove(3); arList.remove(3);
        System.out.println("remove myList:"+myList+"\narList:"+arList);
        // проверим чтение
        System.out.println("get myList(0):"+myList.get(0)+"\narList(0):"+arList.get(0));




    }




}
