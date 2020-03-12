package by.it.zhuravaskarabahataya.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private  static volatile Logger logger;

    private Logger(){
    }

    void log(String message){
        try (
            PrintWriter printWriter = new PrintWriter(new FileWriter("log.txt",true)))
        {
            printWriter.printf(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        Logger localLogger = logger;
        if (localLogger == null){
            synchronized (Logger.class){
                localLogger = logger;
                if (localLogger == null){
                    logger = localLogger = new Logger();
                }
            }
        }
        return logger;
    }
}
