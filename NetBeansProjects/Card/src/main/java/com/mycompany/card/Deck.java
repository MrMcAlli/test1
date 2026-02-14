package com.mycompany.card;

import java.util.*;
import java.util.Random;

/**
 * Deck Class to hold Card class objects in an ArrayList up to a limit of 52
 * @author ianmc
 */
public class Deck {
    private final int MAXSIZE = 52;

    public List<Card> cards = new ArrayList<>(MAXSIZE);
    private Random RANDOM = new Random();

    /**
     *
     * @param c
     */
    public void addCard(Card c) {
        if (cards.size() < MAXSIZE) {
            cards.add(c);
        }
    }

    public Card drawCard() {
        Card result = null;
        int index = RANDOM.nextInt(0,cards.size());
        result = cards.remove(index);
        return result;
    }

}
