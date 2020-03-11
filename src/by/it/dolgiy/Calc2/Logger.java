package by.it.dolgiy.Calc2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

public class Logger {
    private static String filePath = TaskH.getPath(Logger.class,"log.txt");
    private static Deque<String> logs = new LinkedList<>();

    static void writeError(String exception){
        try (final FileWriter fileWriter = new FileWriter(filePath,true)){
            Date date = new Date();
            logs.addFirst(exception+"\n");
            fileWriter.write(date +" "+ exception+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeExpression(String expression, String result){
        try (final FileWriter fileWriter = new FileWriter(filePath,true)){
            logs.addFirst(expression+"\n");
            fileWriter.write(expression + " = "+ result + "\n");
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
