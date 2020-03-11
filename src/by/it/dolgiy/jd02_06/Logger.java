package by.it.dolgiy.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    private static String filePath = TaskH.getPath(Logger.class,"log.txt");

    static void writeError(String exception){
        try (final FileWriter fileWriter = new FileWriter(filePath,true)){
            Date date = new Date();
            fileWriter.write(date +" "+ exception+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static volatile Logger instance;

    private Logger(){
    }

    public static Logger getInstance(){
        Logger localInstance = instance;
        if (localInstance==null){
            synchronized (Logger.class){
                localInstance = instance;
                if (localInstance==null){
                    instance=localInstance=new Logger();
                }
            }
        }
        return localInstance;
    }



}
