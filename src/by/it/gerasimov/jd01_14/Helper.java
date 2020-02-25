package by.it.gerasimov.jd01_14;

import java.io.File;

class Helper {

    private static final String root = System.getProperty("user.dir");

    static String getPath(Class<?> aClass) {
        String path = aClass.getPackage().getName().replace(".", File.separator);
        return root + File.separator + "src" + File.separator + path + File.separator;
    }
}
