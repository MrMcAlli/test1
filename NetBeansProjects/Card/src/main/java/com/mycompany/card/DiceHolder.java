package com.mycompany.card;

import java.util.*;

/**
 * DiceHolder class to hold Dice(Face) Objects up to a count of 10 accounting for 6 side and a 4 sided die
 * Manages ArrayList
 * @author ianmc
 */
public class DiceHolder {

    public List<Dice> faces = new ArrayList<>(8);
    private Random RANDOM = new Random();

    /**
     *
     * @param dice
     */
    public void addFace(Dice dice) {
       if (faces.size() < 8) {
        faces.add(dice);
           
       }
    }

    /**
     *
     * @return Dice
     */
    public Dice roll() {
        Dice result = null;

        if (faces.isEmpty()) {
            throw new IllegalStateException("No dice faces available to roll");
        } else {           
            int index = RANDOM.nextInt(faces.size());
            result = faces.remove(index);
        }

        return result;
    }
}
