package com.hackbulgaria.corejava;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrokenSymbolicLinks {
    
    public static void getBrokenSymbolicLinks(Path path) throws IOException {
       DirectoryStream<Path> ds = Files.newDirectoryStream(path);
       java.util.Iterator<Path> it = ds.iterator();
       Path currentPath;
       File link;
       while(it.hasNext()) {
           currentPath = it.next();
           if(Files.isDirectory(currentPath)) {
               getBrokenSymbolicLinks(currentPath);
           }
           else if(Files.isSymbolicLink(currentPath)) {
               link = currentPath.toFile();
               if(!link.exists()) {
                   System.out.println("The Symbolic link with a path <" +currentPath + " is broken.");
               }
           }
           
       }
    }
    
    //Test-main
    public static void main(String[] args) throws IOException {
        BrokenSymbolicLinks.getBrokenSymbolicLinks(new File("C:\\Users\\Bobby\\Desktop").toPath());
    }

}
