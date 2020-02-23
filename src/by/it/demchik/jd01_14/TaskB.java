package by.it.demchik.jd01_14;

import java.io.*;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);

        return path + clDir;

    }


   public static void main(String[] args) {
        FileInputStream did=null;
        try{
            FileInputStream is=new FileInputStream(dir(TaskB.class)+"text.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       System.out.println(did);
   }
}

//        InputStreamReader reader = null;
//        try {
//            reader = new InputStreamReader(new BufferedInputStream(new FileReader(dir(TaskB.class) + "text.txt")));
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}