package by.it.demchik.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src/by/it/demchik/jd01_14/";

        String filename = path + "text.txt";
        File f = new File(filename);
        int counter=0;
        FileReader is = null;
        try{
            is = new FileReader(f);

            int s;
            // int a=0;
            while((s = is.read()) != -1) {

                char ch = (char) s;
                if(ch=='!')counter++;
                if (ch==' ')counter++;
                if (ch==',')counter++;
                if(ch=='.')counter++;
//if (ch = " ") a++;
//System.out.print(a);
                System.out.print("");}
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        catch(IOException e) {
            System.out.println("IO exception: " + e.getMessage());
        }
        finally {if (is != null) {
            try {is.close();
            }
            catch(IOException e) {
                System.out.println("Неверная ссылка к файлу");
            }
        }}
        System.out.println(""+"\n Колличество слов - "+counter);}}
