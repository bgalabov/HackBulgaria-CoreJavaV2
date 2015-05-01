package com.hackbulgaria.corejava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ToUTF8 {

    public static void fixEncoding(Path path) throws IOException {
        List<String> fileLines = Files.readAllLines(path, Charset.forName("Windows-1251"));
        try (BufferedWriter bw = Files.newBufferedWriter(
                new File("converted_" + path.getFileName().toString()).toPath(), Charset.forName("UTF-8"))) {
            for (String string : fileLines) {
                bw.write(string);
                bw.write(String.format("%n", ""));
            }

        }
    }

    // Test-main
    public static void main(String[] args) throws IOException {
        ToUTF8.fixEncoding(new File(".\\lost.s04e11.hdtv.xvid-2hd.srt").toPath());
    }

}
