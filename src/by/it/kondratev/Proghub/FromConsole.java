package by.it.kondratev.Proghub;

import java.io.*;

public class FromConsole {
    public static void main(String[] args)  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try (FileWriter fw = new FileWriter("test.txt", true)){
            str = br.readLine();
            fw.write("\n" + str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
