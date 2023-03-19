package ua.javarush.ivdidenko.cryptoanalyser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CeasarChipperEngine {


    private static final Character[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
            '.', ',', '«', '»', '(', ')', '"', '\'', ':', ';', '-', '!', ' ', '?', '\n', 13, '…'};

    private final int ABCLENGTH = ALPHABET.length;

    public int getABCLENGTH() {
        return ABCLENGTH;
    }

    public char newSymbol(int key, int ch) {
        char result = 0;
        for (int i = 0; i < ABCLENGTH; i++) {
            if (ALPHABET[i] == ch) {
                int total = i + key;

                result = keyAdjustment(total);
                break;
            }
        }
        return result;
    }
    private char keyAdjustment(int key) {
        ArrayList<Character> list = new ArrayList(Arrays.asList(ALPHABET));

        Collections.rotate(list, -key);

        return list.get(0);
    }
}
