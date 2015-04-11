package com.hackbulgaria.corejava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WordCountResult {
	private int lines;
	private int words;
	private int chars;
	
	private WordCountResult(int lines, int words, int chars) {
		this.lines = lines;
		this.words = words;
		this.chars = chars;
	}
	
	
	public int getLines() {
		return lines;
	}


	public int getWords() {
		return words;
	}


	public int getChars() {
		return chars;
	}

	/* the method counts spaces as characters, but new lines NOT!. */
	public static WordCountResult wordCount(Path path) throws IOException {
		int countOfLines = 0;
		int countOfWords = 0;
		int countOfChars = 0;
		String[] words = null;
		List<String> lines = Files.readAllLines(path);
		countOfLines = lines.size();
		for(String line : lines) {
			countOfChars += line.length();
			words = line.trim().split(" "); //first remove front (and back white spaces, we don't want them as words
			countOfWords+=words.length;
		}
		for(String w : words) {
			System.out.println(w);
		}
		return new WordCountResult(countOfLines, countOfWords, countOfChars);
	}
	
	public static WordCountResult wordCount(File file) throws IOException {
		return wordCount(file.toPath());
	}
}
