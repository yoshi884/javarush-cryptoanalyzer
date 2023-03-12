package ua.javarush.ivdidenko.cryptoanalyser;

import java.io.*;

import java.util.Scanner;



public class Operation {
    Temp temp = new Temp();
    Scanner scanner = new Scanner(System.in);

    private String source;
    private String target;
    private int key;


   public void setSource(){
       System.out.println("Source?: ");
       this.source = scanner.nextLine();
   }

    public String getSource(){
        return source;
    }



    public void setTarget(){
        System.out.println("Target?: ");
        this.target = scanner.nextLine();
    }

    public String getTarget(){
        return target;
    }



    public void setKey(){
        System.out.println("Key?: ");
        this.key = Integer.parseInt(scanner.nextLine());
    }

    public int getKey(){
       return key;
    }



    public  void encryption(int key) {
       setSource();
       setTarget();

        try(BufferedReader reader = new BufferedReader(new FileReader(getSource()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(getTarget()))
        )
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


    public void decryption(int key){
        setSource();
        setTarget();

        try(BufferedReader reader = new BufferedReader(new FileReader(getSource()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(getTarget()))
        )
        {
            int currentChar;

            while ((currentChar = reader.read()) != -1){

                temp.fileDecryption(writer,key ,currentChar);

            }

            System.out.println("Done!");

        }catch (Exception e ){
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }

    }

}
