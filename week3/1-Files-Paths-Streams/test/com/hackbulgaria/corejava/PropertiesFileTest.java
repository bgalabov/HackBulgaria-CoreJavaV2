package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertiesFileTest {
    static File propertiesFile;

    @Before
    public void setUp() throws IOException {
        propertiesFile = new File(".\\Test.properties");
        String rawProps = "# this=comment\n" + "a1=b1 \n" + "a2 =b2\n" + "a3    =    b3\n" + "a4 = b4\n"
                + "a5=b6=b7=b8\n" + "a6=b9 #comment \n" + "a7==b10\n";
        Files.write(propertiesFile.toPath(), rawProps.getBytes());
    }

    @Test
    public void test() throws FileNotFoundException, IOException {
        FileUtils fileUtils = FileUtils.getInstance();
        Map<String, String> map = fileUtils.parseProperties(propertiesFile);
        assertEquals("b6=b7=b8", map.get("a5"));
        assertEquals("b1", map.get("a1"));
        assertEquals("b9 #comment", map.get("a6"));
        assertEquals("b3", map.get("a3"));
        assertEquals("=b10", map.get("a7"));
    }

    @After
    public void tearDown() {
        propertiesFile.delete();
    }

}
