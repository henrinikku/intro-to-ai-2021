package iai.nlp;

import opennlp.tools.parser.Parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
        
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Use this object to access NLP methods, for example NLP.parse(sentence)
        NLPUtils NLP = new NLPUtils();
        
        File file = Paths.get("data", "metamorphosis.txt").toFile();
        // File file = new File(Main.class.getResource("/wikipedia.txt").getFile());
        List<String> lines = FileUtils.readLines(file);

        for (String line : lines) {
            for (String sentence : NLP.detectSentences(line)) {
                // logic here
            }
        }
    }
    
}
