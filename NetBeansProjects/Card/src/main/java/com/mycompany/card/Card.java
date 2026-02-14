/*
* Card.java contains the methods and information to create a string which represents the name of the playing-card generateed by a random number generator inside of itself
* The card is represented by a number 0 - 13 which represents Ace-King in the deck and a number 0-3 which represents the four houses
* The card is created by randomly generating a number to hold the place of both aforementioned values and comparing it to their respective Enum
*/
package com.mycompany.card;

import java.io.*;
import java.util.*;
import java.util.Random;

/**
 *
 * @author ianmc
 */
public class Card {
    private final Random RANDOM = new Random();
    public int CARDRANK, CARDHOUSE;
    public char CARDHOUSECHAR, CARDRANKCHAR;
     
    //new constructor

    /**
     *
     * @param rank
     * @param house
     */
    public Card(char rank, char house) {
        this.CARDRANKCHAR = rank;
        this.CARDHOUSECHAR = house;
    }
    
    /**
     *
     */
    public enum CardHouse {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
    }

    /**
     *
     */
    public enum CardFace {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING;
    }
    public final CardFace MYCARDFACE = CardFace.values()[CARDRANK];
    public final CardHouse MYCARDHOUSE = CardHouse.values()[CARDHOUSE];
    
    /**
     *
     * @param otherCard
     * @return
     */
    public Boolean isLessThan(Card otherCard) {
        boolean result = false;
        if (otherCard.CARDRANK == 0) {
            if (CARDRANK != 0) { result = true; }
            else {  } //tie
        }
        else if (otherCard.CARDRANK != 0) {
            if (CARDRANK < otherCard.CARDRANK) {
                result = true;
            }
        }
        return result;
    } 
                      
    /**
     *
     * @return
     */
    public String cardEnumToString() {
        String result = "";
        if (MYCARDFACE == null) { System.out.println("ERR:NULLCARD"); }
        else { result = CardRankDisplay(CARDRANKCHAR)+" OF "+CardHouseDisplay(CARDHOUSECHAR); }
        return result;
    }

    private String CardHouseDisplay(char _house){
        String result = "";
        switch (_house) {
            case 'c' :
                result = "CLUBS";
                break;
            case 's' :
                result = "SPADES";
                break;
            case 'd' : 
                result = "DIAMONDS";
                break;
            case 'h' :
                result = "HEARTS";
                break;
            default :
                result = "ERROR,V2";
                break;
        }
        return result;
    }
    
    private String CardRankDisplay (char _rank) {
        String result = "";
        switch (_rank) {
            case 'j' :
                result = "JACK";
                break;
            case 'k' :
                result = "KING";
                break;
            case 'a' : 
                result = "ACE";
                break;
            case 'q' :
                result = "QUEEN";
                break;
            default:
                result = Character.toString(_rank);
        }
        return result;
    }
}

