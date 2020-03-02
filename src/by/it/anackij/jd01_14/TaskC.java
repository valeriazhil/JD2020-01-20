package by.it.anackij.jd01_14;

//В классе TaskC нужно выполнить следующие шаги:
// Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
//формате file:имя_файла или dir:имя_каталога.
// Продублировать вывод в консоль в файл resultTaskC.txt

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class TaskC {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "by" + File.separator + "it" + File.separator
                   + "zhuravaskarabahataya" + File.separator);
        File [] myFiles = file.listFiles();
        getFiles(myFiles);
        System.out.println(file);

    }

    private static void getFiles (File[] directory){
        try{
        for (File file : directory) {
            if (file.isDirectory()){
                String printable = "dir:" + file.getName();
                System.out.println(printable);
                writeToFile(printable);
                getFiles(file.listFiles());
            }
            else {
                String printable = "file:" + file.getName();
                System.out.println(printable);
                writeToFile(printable + "\n");
            }
        }}
        catch (NullPointerException e){
            System.out.println("Список пуст");
        }
    }

    private static void writeToFile(String text) {
        File file = new File(getPath());
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getPath() {
        String name = TaskC.class.getName();
        String path = name
                .replace(TaskC.class.getSimpleName(), "")
                .replace('.', File.separatorChar);
        path = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + path + "resultTaskC.txt";
        return path;
    }
}
