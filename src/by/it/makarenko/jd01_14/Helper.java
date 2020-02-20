package by.it.makarenko.jd01_14;

import java.io.File;

public class Helper {
    private static final String root = System.getProperty("user.dir");

    static String getPath(String fileName) {
        String name = TaskA.class.getName();
        String path = name.replace(TaskA.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path = root + File.separator + "src" + File.separator + path + fileName;
    }
}
