package iai.nlp;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class FileUtils {
    
    /**
     * Reads lines of a file to an array.
     * 
     * @param file
     * @return
     * @throws IOException 
     */
    public static List<String> readLines(File file) throws IOException {
        return Files.readAllLines(file.toPath(), Charset.defaultCharset());
    }
    
    /**
     * Reads a file to a String
     * 
     * @param file
     * @return
     * @throws IOException 
     */
    public static String readFile(File file) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, Charset.defaultCharset());
    }
    
}
