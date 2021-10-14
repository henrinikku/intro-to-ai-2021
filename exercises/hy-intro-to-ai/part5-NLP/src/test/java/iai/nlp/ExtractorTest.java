package iai.nlp;

import iai.nlp.Extractor;
import iai.nlp.NLPUtils;
import opennlp.tools.parser.Parse;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.MockStdio;

@Points("NLP")
public class ExtractorTest {

    //private static NLPUtils NLP;

    public ExtractorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
       // NLP = new NLPUtils();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaaEkaSubjekti() {
        //String txt = "This course is fun.";
        //Parse parsed = NLP.parse(txt);
        Parse parsed = Parse.parseParse("(S (NP (DT This) (NN course)) (VP (VBZ is) (NP (NN fun.))))").getChildren()[0];
        assertEquals("course", Extractor.extractSubject(parsed));
    }

    @Test
    public void testaaTokaSubjekti() {
        //String txt = "Gregor is ill.";
        //Parse parsed = NLP.parse(txt);
        Parse parsed = Parse.parseParse("(S (NP (NNP Gregor)) (VP (VBZ is)) (. ill.))").getChildren()[0];
        assertEquals("Gregor", Extractor.extractSubject(parsed));
    }

    @Test
    public void testaaKolmasSubjekti() {
        //String txt = "Because of his injuries, Gregor had lost much of his mobility.";
        //Parse parsed = NLP.parse(txt);
        Parse parsed = Parse.parseParse("(S (PP (IN Because) (IN of) (NP (PRP$ his) (NN injuries,))) (NP (NNP Gregor)) (VP (VBD had) (VP (VBN lost) (NP (NP (RB much)) (PP (IN of) (NP (PRP$ his) (NN mobility.)))))))").getChildren()[0];
        assertEquals("Gregor", Extractor.extractSubject(parsed));
    }

    @Test
    public void testaaSubjektiEiLoydy() {
//        String txt = "And even if he did catch the train he would not avoid his boss's " +
//                      "anger as the office assistant would have been there to see the five " +
//                      "o'clock train go, he would have put in his report about Gregor's " +
//                      "not being there a long time ago.";
//        Parse parsed = NLP.parse(txt);
        Parse parsed = Parse.parseParse("(S (CC And) (SBAR (RB even) (IN if) (S (NP (PRP he)) (VP (VBD did) (VP (VB catch) (NP (NP (DT the) (NN train)) (SBAR (S (NP (PRP he)) (VP (MD would) (RB not) (VP (VB avoid) (NP (PRP$ his) (NNS boss's) (NN anger)) (SBAR (IN as) (S (NP (DT the) (NN office) (NN assistant)) (VP (MD would) (VP (VB have) (VP (VBN been) (ADVP (RB there)) (S (VP (TO to) (VP (VB see) (NP (DT the) (CD five) (RB o'clock) (NN train))))))))))))))))))) (, go,) (NP (PRP he)) (VP (MD would) (VP (VB have) (VP (VBN put) (PP (IN in) (NP (PRP$ his) (NN report))) (PP (IN about) (NP (NP (NNP Gregor's)) (VP (RB not) (VBG being) (ADVP (RB there)) (NP (DT a) (JJ long) (NN time)))))))) (. ago.))").getChildren()[0];

        assertNull(Extractor.extractSubject(parsed));
    }

}
