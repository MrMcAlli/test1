package com.mycompany.card;

import java.util.Random;

/**
 * Small copy of Card.java with same methods
 * @author ianmc
 */
public class Dice {

    private static final Random random = new Random();
    public int DICEVALUE;

    /**
     * @param value
     */
    public Dice(int value) {
        this.DICEVALUE = value;
    }

    //Changing Dice to be a collection of faces to represent 1 dice instead of 1 face from a dice
    public enum DiceFace {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX;
    }

    public final DiceFace MYDICEFACE = DiceFace.values()[DICEVALUE];

    public String diceEnumToString() {
        String result = "";
        result = MYDICEFACE.toString();
        if ("".equals(result) == true) {
            result = "ERR:NULLDICEFACE";
        }
        return result;
    }

    /**
     *
     * @param otherDice
     * @return
     */
    public boolean isLessThan(Dice otherDice) {
        boolean result = otherDice.DICEVALUE > DICEVALUE;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World! (Card.java)");
    }



}
