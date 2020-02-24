package by.it.zhuravaskarabahataya.jd01_01;

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

/DecimalFormat df = new DecimalFormat("#.#####");
df.format(0.912385);
возвращает:
*/
class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int earthWeight = sc.nextInt();
        sc.close();
        System.out.println(getWeight(earthWeight));
    }

    public static double getWeight(int weight) {
        double marsWeight = weight / 9.81 * 3.86;
        //return (double) Math.round(marsWeight * 100) / 100;
        double m100 = marsWeight*100;
        double ostatok = m100 - (int) m100;
        if (ostatok<0.5) return  (int) (m100) / 100.0;
        else return  (int)(m100+1) / 100.0;
    }
}
