package by.it.zhuravaskarabahataya.jd01_12;


import java.util.*;

//TaskB2. Считалка. В кругу стоят N человек.
//  При ведении счета по кругу итератором вычеркивается каждый второй человек,
// пока не останется один.
//  Нужно составить два метода, моделирующие процесс и возвращающие имя оставшегося человека:
// static String process(ArrayList<String> peoples)
// static String process(LinkedList<String> peoples)
//  Покажите работу методов в main
class TaskB2 {
    public static void main(String[] args) {
        List<String> peolpesArray = new ArrayList<String>();
        peolpesArray.add("Vasya"); peolpesArray.add("Lola"); peolpesArray.add("Herbert");
        peolpesArray.add("Elena"); peolpesArray.add("koka"); peolpesArray.add("Boba");
        peolpesArray.add("Biba"); peolpesArray.add("Marya"); peolpesArray.add("Tom");

        List<String> peolpesLinked = new LinkedList<>();
        peolpesLinked.add("Vasya"); peolpesLinked.add("Lola"); peolpesLinked.add("Herbert");
        peolpesLinked.add("Elena"); peolpesLinked.add("koka"); peolpesLinked.add("Boba");
        peolpesLinked.add("Biba"); peolpesLinked.add("Marya"); peolpesLinked.add("Tom");

        System.out.println(process((ArrayList<String>) peolpesArray));
        System.out.println(process((LinkedList<String>) peolpesLinked));

    }

    static String process(ArrayList<String> peoples){
        String name;
        int counter = 1;
        while (peoples.size() != 1){
            Iterator<String> iterator = peoples.iterator();

            while (iterator.hasNext()){
                String person= iterator.next();
                if (counter == 2){
                    iterator.remove();
                    counter--;
                }
                else {
                    counter++;
                    continue;
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        String name;
        int counter = 1;
        while (peoples.size() != 1){
            Iterator<String> iterator = peoples.iterator();

            while (iterator.hasNext()){
                String person= iterator.next();
                if (counter == 2){
                    iterator.remove();
                    counter--;
                }
                else {
                    counter++;
                    continue;
                }
            }
        }
        return peoples.get(0);
    }

}
