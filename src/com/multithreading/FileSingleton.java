package com.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Almas_Doskozhin
 * on 10/8/2018.
 */
public class FileSingleton {
    private final Path path;
    private static final FileSingleton inst = new FileSingleton();

    private FileSingleton() {
        super();
        path = Paths.get("output.txt");
        initFile(path);
    }

    private void initFile(Path path) {
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public synchronized void writeToFile(String str) {
        try {
            Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static FileSingleton getInstance() {
        return inst;
    }

}