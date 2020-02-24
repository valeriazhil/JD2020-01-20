package by.it.cherkas.jd01_14;

import java.io.File;

public class Helper {

    static String getPath(Class<?> cls, String fileName) {
        String root = System.getProperty("user.dir");
        String clsPath = cls.getName()
                .replace(cls.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return root + File.separator + "src" + File.separator + clsPath + fileName;
    }
}
