package ua.javarush.ivdidenko.cryptoanalyser.exception;

import java.io.FileNotFoundException;

public class FileException extends FileNotFoundException {
    public FileException(String message) {
        super(message);
    }

}
