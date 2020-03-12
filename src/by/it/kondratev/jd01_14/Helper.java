package by.it.kondratev.jd01_14;

import java.io.File;

public class Helper {

    private static final String root = System.getProperty("user.dir");

    public static String getPath(Class<?> clazz, String file_name) {
        String name = clazz.getName();
        name = name.replace('.', File.separatorChar).
                replace(clazz.getSimpleName(),"");
        return root + File.separatorChar + "src" + File.separatorChar + name + file_name;
    }

}
