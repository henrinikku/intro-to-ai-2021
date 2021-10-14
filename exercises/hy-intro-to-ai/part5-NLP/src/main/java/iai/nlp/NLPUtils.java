package iai.nlp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.*;
import opennlp.tools.sentdetect.*;

/**
 * NLP-methods
 */
public class NLPUtils {
    
    private final Parser parser;
    private final SentenceDetectorME sentenceDetector;
    
    /**
     * Constructs a syntax tree from a sentence.
     * 
     * @param sentence
     * @return Root of the constructed tree.
     */
    public Parse parse(String sentence) {
        // the parser prints to stderr when it can't parse the sentence, UGH
        PrintStream err = System.err;
        System.setErr(new Interceptor(err));
        Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
        System.setErr(err);
        
        return getRoot(topParses[0]);
    }
    
    /**
     * Detects sentences from text.
     * 
     * @param text
     * @return A String array of found sentences. 
     * @throws IOException 
     */
    public String[] detectSentences(String text) throws IOException {
        return sentenceDetector.sentDetect(text);
    }
    
    private Parse getRoot(Parse tree) {
        if (!tree.complete()) {
            return null;
        }
        
        Parse root = null;
        for (Parse child : tree.getChildren()) {
            if (child.getType().equals("S")) {
                root = child;
                break;
            }
        }
        
        if (root == null || !properTree(root)) {
            return null;
        }

        return root;
    }
    
    private boolean properTree(Parse root) {
        boolean NP = false, VP = false;
        
        for (Parse child : root.getChildren()) {
            if (child.getType().equals("NP")) {
                NP = true;
            } else if (child.getType().equals("VP")) {
                VP = true;
            }
        }
        
        return NP && VP;
    }
        
    public NLPUtils() throws FileNotFoundException, IOException {
        InputStream modelInSent = Files.newInputStream(Paths.get("data", "en-sent.bin"));
        InputStream modelInParser = Files.newInputStream(Paths.get("data", "en-parser-chunking.bin"));

        SentenceModel modelSent = new SentenceModel(modelInSent);
        sentenceDetector = new SentenceDetectorME(modelSent);
        
        ParserModel modelParser = new ParserModel(modelInParser);
        parser = ParserFactory.create(modelParser);

        modelInSent.close();
        modelInParser.close();
    }
    
    private class Interceptor extends PrintStream {
        
        public Interceptor(OutputStream out) {
            super(out, false);
        }

        @Override
        public void print(String s) {
        }
        
        @Override
        public void println(String s) {
        }
    
    }
    
}
