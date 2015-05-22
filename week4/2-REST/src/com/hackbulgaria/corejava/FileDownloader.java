package com.hackbulgaria.corejava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileDownloader {
    
    public static void download(String s) throws IOException {
        URL url = new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
        byte[] buff = new byte[2048];
        int readBytes;
        InputStream in = new BufferedInputStream(url.openStream());
        BufferedOutputStream out = new BufferedOutputStream((new FileOutputStream(new File("downloaded.jpg"))));
        while((readBytes=in.read(buff))!=-1){
             out.write(buff, 0, readBytes);
          }
        in.close();
        out.close();
        }
    
    public static void main(String[] args) throws IOException {
        FileDownloader.download("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
    }

}
