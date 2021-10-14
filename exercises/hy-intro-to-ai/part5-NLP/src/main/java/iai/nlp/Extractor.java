package iai.nlp;

import opennlp.tools.parser.Parse;

public class Extractor {
    
    /**
     * Finds the subject of a sentence from a syntax tree.     * 
     * @param root root of the tree (S)
     * @return Subject as a String
     */
    public static String extractSubject(Parse root) {
        // Implement finding the suject as follows:
        // 1. Choose a root's child node with POS NP.
        // 2. Do a BFS search on the subtree of the chosen child.
        // 3. Subject is in the first found node whose POS-tag is a noun.
        // POS tags that are nouns: NN, NNP, NNS, NNPS.
        // If no noun is found, return null.
        // 
        // Useful methods in Parse objects:
        // node.getChilderen()
        // node.getType()
        // node.getCoveredText()
        return "";
    }
    
}
