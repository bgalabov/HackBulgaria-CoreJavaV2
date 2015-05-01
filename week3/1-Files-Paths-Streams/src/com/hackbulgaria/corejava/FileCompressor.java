package com.hackbulgaria.corejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class FileCompressor {

    /*
     * public static void compress(Path filePath) throws IOException {
     * Map<String, Integer> wordsMap = new HashMap<String, Integer>(); int index
     * = 0; int i; byte[] fileLines = Files.readAllBytes(filePath); String
     * fileContents = new String(fileLines); String[] separateWords =
     * fileContents.split("\\W"); for (String string : separateWords) {
     * if(!wordsMap.containsKey(string)) { wordsMap.put(string, index); index++;
     * } } String[] stringOfSpaces = fileContents.split("\\p{Alpha}+");
     * System.out.println(stringOfSpaces.length); for (String string :
     * stringOfSpaces) { System.out.println(string); } StringBuilder strbldr =
     * new StringBuilder();
     * 
     * if(Pattern.matches("\\W", fileContents.substring(0, 1))) { i=0; } else {
     * i=1; }
     * 
     * for (String string : separateWords) { strbldr.append("~"
     * +wordsMap.get(string) +stringOfSpaces[i]); i++; }
     * strbldr.append(stringOfSpaces[i]);
     * System.out.println(strbldr.toString());
     * 
     * ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream((new
     * File(".\\compressed.txt")))); os.writeObject(wordsMap);
     * os.write(fileContents.getBytes()); os.close();
     * 
     * }
     */

    public static void compress(Path filePath) throws IOException {
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        int index = 0;
        byte[] fileLines = Files.readAllBytes(filePath);
        String fileContents = new String(fileLines);
        String[] separateWords = fileContents.split("\\W");
        for (String string : separateWords) {
            if (!wordsMap.containsKey(string)) {
                wordsMap.put(string, index);
                index++;
            }
        }

        StringBuilder result = new StringBuilder();

        String delimiters = " !@#$%&()_+.?";
        StringTokenizer tokens = new StringTokenizer(fileContents, delimiters, true);
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if (!delimiters.contains(token)) {
                result.append("~" +wordsMap.get(token));
            } else {
                result.append(token);
            }
        }
        
        MapAndData md = new MapAndData(wordsMap, result.toString());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream((new File(".\\compressed.txt"))));
        os.writeObject(md);
        os.write(result.toString().getBytes());
        os.close();

    }
    
    public static void decompress(Path filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
        MapAndData md;
        int value;
        String key;
        ObjectInputStream os = new ObjectInputStream(new FileInputStream((new File(".\\compressed.txt"))));
        md = (MapAndData) os.readObject();
        os.close();
        md.map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = md.map.entrySet().iterator();
        String compressedString = md.compressedResult;
        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
            key = entry.getKey();
            value = entry.getValue();
            compressedString = compressedString.replaceAll("~" +value, key);
            System.out.println(compressedString);
        }     
    }

    //Test-main
    
   /* public static void main(String[] args) throws IOException, ClassNotFoundException {
        compress(new File(".\\textFile.txt").toPath());
        decompress(new File(".\\compressed.txt").toPath());
    }*/

}

class MapAndData implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 9218048381126073907L;
    Map<String, Integer> map;
    String compressedResult;
    
    public MapAndData(Map<String, Integer> map, String compressedResult) {
        this.map = map;
        this.compressedResult = compressedResult;
    }
}
