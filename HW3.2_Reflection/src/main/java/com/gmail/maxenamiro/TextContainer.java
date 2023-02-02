package com.gmail.maxenamiro;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(path = "/Users/a1/Documents/Java_pro/file.txt")
public class TextContainer {
    private static String text = "you done";

    @Saver
    public static void save(String nameFile) throws FileNotFoundException{
        File file = new File(nameFile);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(text);
        }
    }
}