package by.it.lomazki.Example;

import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    Vector vector=new Vector();
    public void addCharacterandPrint(){
        vector.add("Weasley");
        vector.add("Potter");
        for(int i=0;i<vector.size();i++){
            System.out.println("The characters are\t"+vector.get(i));
        }
    }
    public static void main(String args[]){
        Example example=new Example();
        example.addCharacterandPrint();
    }
}


