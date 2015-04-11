package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordCountResultTest {
	static File testFile;

	@Before
	public void setUp() throws Exception {
		testFile = new File(".\\Test.txt");
		List<String> lines = new LinkedList<String>();
		lines.add("Hello World!");
		lines.add("I love Java! ");
		lines.add(" Eclipse is the best!!!");
		Files.write(testFile.toPath(), lines);
	}

	@After
	public void tearDown() throws Exception {
		Files.delete(testFile.toPath());
	}

	@Test
	public void test() throws IOException {
		WordCountResult result = WordCountResult.wordCount(testFile);
		assertEquals(3, result.getLines());
		assertEquals(9, result.getWords());
		assertEquals(48, result.getChars());
	}

}
