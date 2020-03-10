package by.it.kondratev.jd02_03;

import java.util.Random;

class Helper {

   static int random(int min, int max) {
       Random generator = new Random();
       int n = generator.nextInt(max-min+1) + min;
       return n;
   }

   static void sleep(int timeout) {
       try {
           Thread.sleep(timeout);
       } catch (InterruptedException e) {
           System.err.println("Exception in thread");
       }

   }

}
