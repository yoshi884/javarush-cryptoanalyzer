package com.javarush.cryptanalyzer.ivdidenko.cryptoanalyser;

import java.io.File;
import java.util.Scanner;

public class Dialog {

    private  static  final  String DEFAULT_SOURCE_FOR_ENCRYPT = "target/input.txt";
    private  static  final  String DEFAULT_SOURCE_FOR_DECRYPT = "target/encoded.txt";
    private  static  final  String DEFAULT_TARGET_FOR_ENCRYPT = "target/encoded.txt";
    private  static  final  String DEFAULT_TARGET_FOR_DECRYPT = "target/output.txt";
    private static final String DEFAULT_TARGET_FOR_BRUTEFOERCE = "target/output.txt";
    private static final String QUESTION_KEY = "Key?: ";
    private static final String QUESTION_SOURCE = "Указанный путь должен быть абсолютным. Или нажмите Enter для значения по умолчанию. \nSource?:";
    private static final String QUESTION_TARGET = "Target?: ";
    private static final String START_MESSAGE = "Выберите тип операции :\n 1 - FromFileToFileEncryption\n 2 - FromFileToFileDecryption\n 3 - BrutForce ";
    private static final String SCANNER_EXCEPTION_MESSAGE = "Incorrect input! : ";


    public  void startDialogAndEncrypt(){

        Scanner scanner = new Scanner(System.in);

        System.out.println(START_MESSAGE);
        int type = 0;
        try {
             type = scanner.nextInt();

        }catch (Exception e){
            System.out.println(SCANNER_EXCEPTION_MESSAGE + e.getMessage());
            throw e;
        }
        int key = 0;
        switch (type){
            case 1 :
                System.out.println(QUESTION_KEY);
                try {
                    key = scanner.nextInt();
                }catch (Exception e){
                    System.out.println(SCANNER_EXCEPTION_MESSAGE + e.getMessage());
                    throw e;
                }

                System.out.println(QUESTION_SOURCE);
                scanner.nextLine();
                String source = scanner.nextLine();
                System.out.println(QUESTION_TARGET);
                String target = scanner.nextLine();
                if (source.isEmpty()){
                    File file = new File(DEFAULT_SOURCE_FOR_ENCRYPT);
                    source = file.getAbsolutePath();
                }
                if(target.isEmpty()){
                    File file = new File(DEFAULT_TARGET_FOR_ENCRYPT);
                    target = file.getAbsolutePath();
                }

                CeasarCipher ceasarCipher = new CeasarCipher(source , target , key , true);

                ceasarCipher.encryption();
                break;
            case 2 :
                System.out.println(QUESTION_KEY);
                try {
                    key = scanner.nextInt();
                }catch (Exception e){
                    System.out.println(SCANNER_EXCEPTION_MESSAGE + e.getMessage());
                    throw e;
                }
                System.out.println(QUESTION_SOURCE);
                scanner.nextLine();
                source = scanner.nextLine();
                System.out.println(QUESTION_TARGET);
                target = scanner.nextLine();

                if (source.isEmpty()){
                    File file = new File(DEFAULT_SOURCE_FOR_DECRYPT);
                    source = file.getAbsolutePath();
                }
                if(target.isEmpty()){
                    File file = new File(DEFAULT_TARGET_FOR_DECRYPT);
                    target = file.getAbsolutePath();
                }

                 ceasarCipher = new CeasarCipher(source , target , key , false);

                ceasarCipher.encryption();
                break;
            case 3 :

                System.out.println(QUESTION_SOURCE);
                scanner.nextLine();
                source = scanner.nextLine();
                System.out.println(QUESTION_TARGET);
                target = scanner.nextLine();


                if (source.isEmpty()){
                    File file = new File(DEFAULT_SOURCE_FOR_DECRYPT);
                    source = file.getAbsolutePath();
                }
                if(target.isEmpty()){
                    File file = new File(DEFAULT_TARGET_FOR_BRUTEFOERCE);
                    target = file.getAbsolutePath();
                }

                ceasarCipher = new CeasarCipher(source ,target);

                ceasarCipher.bruteForce();
                break;
        }


    }
}
