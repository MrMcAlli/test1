/*
* Main creates two classes of Card.java and compares their randomly generated stats against each other 
* Main then does the same comparison with two classes of Dice.java
* both are printed to console in a cmdline video-game format
 */
package com.mycompany.card;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author ianmc
 */
public class Main {

    static Deck mainDeck = new Deck();
    static DiceHolder diceHolder = new DiceHolder();
    static String fileName = "test.txt";

    private static void initialize() {
        createObjectsFromTextFile(fileName);
    }

    public static void createObjectsFromTextFile(String _fileName) {

        try (Scanner sc = new Scanner(new File(_fileName))) {

            int diceIndex = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.contains(("#"))) { //Dice data detected
                    for (int i = 0; i < line.length(); i++) {
                        CollectDiceFaceFromLine(line);
                    }
                    diceIndex++;
                } else { //the rest of the data is card data
                    for (int i = 0; i < line.length(); i += 2) {
                        mainDeck.addCard(
                                new Card(line.charAt(i), line.charAt(i + 1))
                        );
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to read file: " + e.getMessage());
        }
    }

    public static void CollectDiceFaceFromLine(String _line) {
        int endIndex;
        for (endIndex = 1; endIndex < _line.length(); endIndex++) {
            if (_line.charAt(endIndex) == '#') {
                break;
            } else if (Character.isDigit(_line.charAt(endIndex))){
                diceHolder.addFace(
                        new Dice(Character.getNumericValue(_line.charAt(endIndex)))
                );
            }
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("- Player: Ian Mc");
        System.out.println("- - Welcome to the Card Battler!");
        initialize();
        Card c1 = mainDeck.drawCard();
        Card c2 = mainDeck.drawCard();
        System.out.println("- - - Ian Mc's Card: " + c1.cardEnumToString() + "!");
        System.out.println("- - - Enemy's Card: " + c2.cardEnumToString() + "!");

        if (c1.isLessThan(c2) == true) {
            System.out.println("- - - - Too bad!  Ian Mc lost!");
        } else if (c1.isLessThan(c2) == false) {
            System.out.println("- - - - Good job!  Ian Mc won!");
        }
        System.out.println("- - Welcome to the Dice Battler!");

        Dice d1 = diceHolder.roll();
        Dice d2 = diceHolder.roll();

        System.out.println("- - - Ian Mc Rolled: " + d1.DICEVALUE + "!");
        System.out.println("- - - Enemy Rolled: " + d2.DICEVALUE + "!");
        if (d1.isLessThan(d2)) {
            System.out.println("- - - - Too bad!  Ian Mc lost!");
        } else {
            System.out.println("- - - - Good job!  Ian Mc won!");
        }

        System.out.println("- GAME OVER!");
    }

}
