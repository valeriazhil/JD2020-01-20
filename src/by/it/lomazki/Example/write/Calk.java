package by.it.lomazki.Example.write;

import java.util.Scanner;

public class Calk {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++)
                        for (int p = 0; p < 3; p++)
                            System.out.print(i*10000 + j*1000 + k*100 + l*10 + p);

    }
}
