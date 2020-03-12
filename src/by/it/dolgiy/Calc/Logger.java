package by.it.dolgiy.Calc;


import by.it.dolgiy.Calc.translate.CalcErrors;
import by.it.dolgiy.Calc.translate.ResMan;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class Logger {
    private static String filePath = TaskH.getPath(Logger.class,"log.txt");
    static LinkedList<String> logs = new LinkedList<>();
    static ResMan man = ResMan.INSTANCE;

    static void writeError(String exception){
//        try (final FileWriter fileWriter = new FileWriter(filePath,true)){
            Date date = new Date();
            logs.addLast(date +" "+ exception+"\n");
//            fileWriter.write(date +" "+ exception+"\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    static void writeExpression(String expression, String result){
//        try (final FileWriter fileWriter = new FileWriter(filePath,true)){
            Date date = new Date();
            logs.addLast(date+" "+expression + "="+ result+"\n");
//            fileWriter.write(date+" "+expression + "="+ result + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    static void startWriteReport(){
//        try (final FileWriter fileWriter = new FileWriter(filePath,true)){
            String date = getDataReportString();
            String report = man.get(CalcErrors.START) +" "+date;
            logs.addLast(report+"\n");
//            fileWriter.write(report + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    static void endWriteReport(){
//        try (final FileWriter fileWriter = new FileWriter(filePath,true)){
            String date = getDataReportString();
            String report = man.get(CalcErrors.STOP) +" "+date;
            logs.addLast(report+"\n");
//            fileWriter.write(report + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static String getDataReportString() {
        Date moment = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date d = null;
        String str = dateFormat.format(moment);
        try {
            d = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        return dateFormat.format(d);
    }

    static void printLog(LinkedList<String> logs){
        try (final FileWriter fileWriter = new FileWriter(filePath)){
            for (String log : logs) {
                fileWriter.write(log);
            }
            logs.clear();
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
