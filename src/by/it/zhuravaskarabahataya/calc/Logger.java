package by.it.zhuravaskarabahataya.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Logger {
    private  static volatile Logger logger;

    static String logFile = FileHelper.getFilePath("log.txt", FileHelper.class);

    private Logger(){
    }

    void log(String message){
        try (
            PrintWriter printWriter = new PrintWriter(new FileWriter(logFile,true)))
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
