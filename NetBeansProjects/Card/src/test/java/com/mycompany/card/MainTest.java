/*
 * I am aware the Dice and DiceHolder logic is outdated and must be updated, but for the sake of timeliness and completion of the foundational task of creating unit-tests-
 * -for the project as a whole, I am leaving it as is in this submission. I apologize.
 * Refactored both Main.createObjectsFromTextFile & Main.CollectDiceFaceFromLine functions to be public and take parameters for testing purposes
 * For testing purposes I am instantiating the Main.mainDeck via testMainCreateObjects(). I assume this is not optimal but I was unable to determine if it is bad practice for the assignment
 * Unit Testing seems to be generally conducted from a seperate "testing class", so this is what I have emulated here. I attemped to add a Unit Test to each function-
 * from all 5 classes that was not private,static, or generally not needing to be tested (in my opinion).
 * I am not sure of other alternatives but I opted to use the built-in UnitTesting generation built-into Apache Netbeans, this generated several functions with tags like-
 * - @BeforeAll which i am not entirely familiar with and was unable to incorporate most into my assignment, although, I left the functions in the assignment.
 *
 * In total, from creating Unit tests I have realized the extent of the damage my repeated edits have caused to the codebase as 3 of the 9 tests -should- fail, my logic is wrong.
 * I plan to refactor and implement logic changes to the Dice,DiceHolder, and Card classes between now and my next submission
* @author ianmc 
*/
package com.mycompany.card;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    
    DiceHolder mainDice = Main.diceHolder;
    Deck mainDeck = Main.mainDeck;
    String mainFileName = Main.fileName;
    
    DiceHolder testDice = new DiceHolder();    
    Deck testDeck = new Deck();
    
    
    public MainTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
        assertTrue(Main.mainDeck.cards.isEmpty(), "FAIL: mainDeck should be empty, it is not.");        
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
//        fail("The test case is a prototype.");
    }
   
    
    @Test
    public void testMainCreateObjects() {
        Main.createObjectsFromTextFile(mainFileName);
        assertTrue(Main.mainDeck.cards.isEmpty() == false, "FAIL: mainDeck is empty, it should not be.");
        assertTrue(Main.diceHolder.faces.isEmpty() == false, "FAIL, diceHolder is empty, it should not be");
    }
    
    //Test the ability of the Deck class to be instantiated and Test the expected maxSize vs the result
    @Test
    public void testDeckAdd() {
        int maxExpectedCards = 50;
        System.out.println(Main.mainDeck.cards.size()); 
        for (int i = 0; i < maxExpectedCards; i++) {
            if (Main.mainDeck.cards.get(i) != null) { testDeck.addCard(Main.mainDeck.cards.get(i)); }
            else {testDeck.addCard(Main.mainDeck.cards.get(0)); }
        }
        assertTrue(testDeck.cards.size() == 50, "FAIL: testDeck should be full (50), it is not.");
        testDeck.addCard(testDeck.drawCard());
        assertFalse(testDeck.cards.size() > 50, "FAIL: testDeck size increased past limit");
    }
    
    @Test
    public void testDeckDraw() {
        assertTrue(Main.mainDeck.drawCard() != null, "FAIL: Draw Card returns null card");
    }
    
    
    @Test
    public void testCardComparison() {
        Card c1 = new Card('a','s');
        Card c2 = new Card('1','c');
        
        assertTrue(c2.isLessThan(c1) == true, "FAIL: Ace of Spades registered as lower than 1 of Clubs");
    }
    
    @Test
    public void testCardEnumConversion() {
        Card c1 = new Card('a','s'); //ace of spades
        String expectedOutput = "ACE OF SPADES";
        System.out.println(c1.cardEnumToString());
        assertTrue(c1.cardEnumToString().startsWith(expectedOutput) == true, "FAIL: card name String does not match with expected output");
    }
    
    @Test
    public void testDiceHolderAdd() {
        int maxExpectedDie = 6;
        for (int i = 0; i < maxExpectedDie; i++) {
            testDice.addFace(mainDice.faces.get(i));
        }
        
        assertTrue(testDice.faces.size() == 8, "FAIL: testDice should be full (10), it is not");
        testDice.addFace(testDice.faces.get(1));
        assertFalse(testDice.faces.size() > 8, "FAIL: testDice size increased past limit (10)");
    }
    
    @Test
    public void testDiceComparison() {
        Dice d1 = new Dice(5);
        Dice d2 = new Dice(1);
        assertTrue(d2.isLessThan(d1), "FALSE: Dice(1) registered as higher than Dice(5)");
    }
    
    @Test
    public void testDiceEnumConverstion() {
        Dice d1 = new Dice(5);
        String expectedValue = "FIVE";
        System.out.println(expectedValue);
        assertTrue(d1.diceEnumToString() == (expectedValue), "FAIL: Dice Enum Conversion Differs From Expected Value");
    }
    
}
