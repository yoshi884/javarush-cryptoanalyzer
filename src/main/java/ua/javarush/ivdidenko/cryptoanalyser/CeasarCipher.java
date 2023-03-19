package ua.javarush.ivdidenko.cryptoanalyser;

import ua.javarush.ivdidenko.cryptoanalyser.exception.FileException;

import java.io.*;

public class CeasarCipher {
    private CeasarChipperEngine ceasarChipperEngine;

    private String source;
    private String target;
    private int key;

    private boolean isEncrypt;

    public CeasarCipher(String source, String target, int key, boolean isEncrypt) {
        this.source = source;
        this.target = target;
        this.key = key;
        this.isEncrypt = isEncrypt;
        this.ceasarChipperEngine = new CeasarChipperEngine();
    }

    public CeasarCipher(String source, String target) {
        this.source = source;
        this.target = target;
        this.ceasarChipperEngine = new CeasarChipperEngine();
    }

    public String getSource() {
        return source;
    }


    public String getTarget() {
        return target;
    }


    public void encryption() {

        if (!isEncrypt) {
            key = -key;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(this.getSource()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.getTarget()))
        ) {
            int currentChar;

            while ((currentChar = reader.read()) != -1) {
                char newChar = ceasarChipperEngine.newSymbol(key, currentChar);
                writer.write(newChar);

            }

            System.out.println("Done!");

        } catch (FileException e) {
            System.out.println("Wrong file:" + e.getMessage()) ;
        }catch (IOException e){
            System.out.println("Something went wrong :)" + e.getMessage());
        }
    }


    public void bruteForce() {

        for (int j = 0; j < ceasarChipperEngine.getABCLENGTH(); j++) {

            try (BufferedReader reader = new BufferedReader(new FileReader(getSource()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(getTarget()))

            ) {
                int total = kurwa(reader, writer, -j);

                if (total / 12 < countMatches()) {
                    System.out.println(j);
                    break;
                }

            } catch (Exception e) {
                System.out.println("Something went wrong :(" + e.getMessage());
            }

        }

    }


    private int countMatches() throws IOException {
        int matches = 0;
        BufferedReader reader = new BufferedReader(new FileReader(getTarget()));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] lines = line.split("\\s+");
            for (var currentLine : lines) {
                if (currentLine.matches("^[а-яА-ЯёЁ]+[.,\"':!?\\-]*$")) {
                    matches++;
                }
            }
        }

        return matches;
    }

    private int kurwa(BufferedReader reader, BufferedWriter writer, int key) throws IOException {
        int i = 0;
        int currentChar;

        while ((currentChar = reader.read()) != -1) {
            char newChar = ceasarChipperEngine.newSymbol(key, currentChar);
            writer.write(newChar);
            i++;
        }
        return i;
    }
}