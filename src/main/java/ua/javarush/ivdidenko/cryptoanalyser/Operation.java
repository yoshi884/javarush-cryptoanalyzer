package ua.javarush.ivdidenko.cryptoanalyser;

import java.io.*;

import java.util.Scanner;



public class Operation {
    Temp temp = new Temp();
    public  void fromFileToFile(int key) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Source : ");
        String source = scanner.nextLine();
        System.out.println("to : ");
        String target = scanner.nextLine();

        try(BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(target)))
        {
            int currentChar;

            while ((currentChar = reader.read()) != -1){

                temp.fileEncryption(writer,key ,currentChar);

            }

            System.out.println("Done!");

        }catch (Exception e ){
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }


    }
}

