package ua.javarush.ivdidenko.cryptoanalyser;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Temp {


    private static final Character[] ALPHABET = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            '.', ',', '«', '»', '(', ')', '"', '\'', ':', ';', '-', '!', ' ', '?', '\n'};

    public static final int ABCLENGTH = ALPHABET.length;

    public  void fileEncryption(BufferedWriter writer , int key , int ch) {

        try {
            for (int i = 0; i < ABCLENGTH; i++) {
                if(ALPHABET[i] == (char) ch){
                    int total = i  + key;
                    if(total >= ABCLENGTH){
                        writer.write(keyAdjustment(total));
                        System.out.println(ALPHABET[i] + "--->" + keyAdjustment(total));
                        break;
                    }

                    char newChar =ALPHABET[i + key];
                    writer.write(newChar);
                    System.out.println(ALPHABET[i] + "--->" + newChar);
                    break;
                } /*else if (i == ABCLENGTH -1){
                    System.out.println("Not found ! :" + ch);
                }*/
            }
        }catch (Exception e){
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }
    }


    public void fileDecryption(BufferedWriter writer , int key , int ch){


        try {

            for (int i = 0; i < ALPHABET.length; i++) {
                if(ALPHABET[i] == (char) ch){
                    int total = i  - key;
                    if(total <0){
                        writer.write(keyAdjustment(total) );
                        break;
                    }

                    char newChar =ALPHABET[i - key];
                    writer.write(newChar);
                    break;
                }
            }


        }catch (Exception e){
            System.out.println("Something went wrong :(");
            e.printStackTrace();
        }
    }


    public char keyAdjustment(int key ){


        ArrayList <Character> list = new ArrayList(Arrays.asList(ALPHABET));


        Collections.rotate(list , -key );


        return list.get(0);
    }


}
