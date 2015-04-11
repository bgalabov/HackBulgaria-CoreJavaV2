package com.hackbulgaria.corejava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileUtils {
	private static FileUtils instance = null;
	
	private FileUtils() {
		
	}
	
	public static FileUtils getInstance() {
		if(instance == null) {
			instance = new FileUtils();
		}
		return instance;
	}
	
	public String readFrom(File file) throws FileNotFoundException, IOException {
		BufferedReader fileInput = new BufferedReader(new FileReader(file));
		String readString = fileInput.readLine();
		StringBuilder strBldr = new StringBuilder();
		while(readString != null) {
			strBldr.append(readString);
			strBldr.append("\n");
			readString = fileInput.readLine();
		}
		fileInput.close();
		return strBldr.toString();
	}
	
	public String readFrom(Path path) throws FileNotFoundException, IOException {
		List<String> fileContain = Files.readAllLines(path);
		StringBuilder strBldr = new StringBuilder();
		
		for(String s : fileContain) {
			strBldr.append(s);
			strBldr.append("\n");
		}
		return strBldr.substring(0, strBldr.length()-1).toString();
	}
	
	public void writeToFile(File file, String str) throws IOException {
		Files.write(file.toPath(), str.getBytes());
	}
	
	public void writeToFile(Path path, String str) throws IOException {
		Files.write(path, str.getBytes());
	}
	
	private Map<String, String> generatePropMap(List<String> list) {
		Map<String, String> dataMap = new HashMap<String, String>();
		int indexOfFirstEq;
		for(String s : list) {
			if(!s.substring(0, 1).equals("#")) {
				indexOfFirstEq = s.indexOf('=');
				dataMap.put(s.substring(0, indexOfFirstEq).trim(), s.substring((indexOfFirstEq + 1), s.length()).trim());
			} 
		}
		return dataMap;
	}
	
	public Map<String, String> parseProperties(File file) throws FileNotFoundException, IOException {
		List<String> rawProperties = new LinkedList<String>();
		String rawPropertiesString;
		rawPropertiesString = readFrom(file);
		String lines[] = rawPropertiesString.split("\\r?\\n");
		rawProperties.addAll(Arrays.asList(lines));
		return generatePropMap(rawProperties);
	}
	

	
	/*public static void main(String[] args) throws FileNotFoundException, IOException {
		FileUtils fu = FileUtils.getInstance();
		
		fu.writeToFile(Paths.get(".\\Test2.txt"), "Hello!\n I love Java!\n");
	}*/
}
