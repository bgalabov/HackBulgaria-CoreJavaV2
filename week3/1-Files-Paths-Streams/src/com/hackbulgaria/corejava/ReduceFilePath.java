package com.hackbulgaria.corejava;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReduceFilePath {
    public static Path reduceFilePath(String pathString) {
        return Paths.get(pathString).normalize();
    }
    
    /* public static void main(String[] args) {
        System.out.println(reduceFilePath("C:\\Users\\Guest\\..\\Boby\\.\\Desktop").toString());
    }*/

}
