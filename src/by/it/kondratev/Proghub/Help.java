package by.it.kondratev.Proghub;

import java.io.*;

public class Help {

    static String string;

    static String topic(){
        try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in))
            ) {
            System.out.println("Введите название темы: ");
            string = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    static boolean search(String topic_name) {

        try (BufferedReader br = new BufferedReader(
                new FileReader("helpfile.txt")
        )) {
            int x = '#';
            do {
                if (br.read()==x) {
                    if (br.readLine().equals(topic_name)) {
                        string = br.readLine();
                        System.out.println(string);
                        return true;
                    }
                }
            } while (br.read()!= -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Тема не найдена");
        return false;
    }

}
