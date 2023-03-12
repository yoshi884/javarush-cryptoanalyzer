package ua.javarush.ivdidenko.cryptoanalyser;

import java.util.Scanner;

public class UserInterface {
    public static void OperationType(){
        Operation operation = new Operation();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Что делаем?:\n 1 - FromFileToFileEncryption\n 2 - FromFileToFileDecryption");
        int type = scanner.nextInt();
        switch (type){
            case 1 :
                operation.setKey();
                operation.encryption(operation.getKey());
                break;
            case 2 :
                operation.setKey();
                operation.decryption(operation.getKey());
        }


    }
}
