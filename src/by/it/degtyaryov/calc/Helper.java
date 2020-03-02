package by.it.degtyaryov.calc;

import java.io.File;

class Helper {

    static String getPath(Class<?> cls, String fileName) {
        String root = System.getProperty("user.dir");
        String clsPath = cls.getName()
                .replace(cls.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return root + File.separator + "src" + File.separator + clsPath + fileName;
    }
}
