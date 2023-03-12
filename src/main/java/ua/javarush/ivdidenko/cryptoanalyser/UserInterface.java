package ua.javarush.ivdidenko.cryptoanalyser;

import java.util.Scanner;

public class UserInterface {
    public static void OperationType(){
        Operation operation = new Operation();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Что делаем?: 1 - FromFileToFile");
        int type = scanner.nextInt();
        switch (type){
            case 1 :
                System.out.println("Key? : ");
                int bias = scanner.nextInt();
                operation.fromFileToFile(bias);
                break;
        }


    }
}
