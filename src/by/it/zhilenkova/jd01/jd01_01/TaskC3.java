package by.it.zhilenkova.jd01.jd01_01;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1. Метод getWeight(int weight) должен быть статическим.
2. Метод getWeight должен возвращать значение типа double.
3. Метод getWeight должен обязательно (!) округлять до сотых возвращаемое значение типа double.
4. Метод getWeight не должен ничего выводить на экран.
5. Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.

Пример:

Ввод:
75

Вывод:
29.51


*/
class TaskC3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите массу человека:");
        System.out.println(getWeight(scanner.nextInt()));
        //int weight=scanner.nextInt();
        //System.out.printf(Locale.ENGLISH,"Вывод:\n%.8f%n", getWeight(weight) ); //Локаль для вывода точки
}

    private static double getWeight(int weight) {
       // double gEarth= 9.81;
        //double gMars = 3.86;
        //double part = gMars / gEarth;
        //double mEarth=weight;
        //double aMars= mEarth*part;
        double aMars=weight * 3.86/ 9.81*100;
        double dif=aMars - (int) aMars;
        if (dif<0.5)
            return ((int) aMars)/100.0;
        else
        return ((int)aMars+1)/100.0;

    }

    }
