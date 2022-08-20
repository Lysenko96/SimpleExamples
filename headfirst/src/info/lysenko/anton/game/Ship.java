package info.lysenko.anton.game;

import java.util.HashSet;
import java.util.Set;

public class Ship {

    private int[] locationCells;
    private int numOfHits;

    // no setter for final
    private final Set<Integer> hits = new HashSet<>();

    public String checkYourself(String guess) {
        String result = "no hit";
        for (Integer cell : locationCells) {
            if (Integer.parseInt(guess) == cell) {
                checkNumOfHits(guess, cell);
                result = checkHitsResult(guess);
                hits.add(Integer.parseInt(guess));
                System.out.println(hits);
                break;
            }
        }
        return result;
    }

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    public int[] getLocationCells() {
        return locationCells;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    private String checkHitsResult(String guess) {
        String result = "hit";
        if (numOfHits == locationCells.length)
            result = "destroy";
        else if (hits.contains(Integer.parseInt(guess)))
            result = "repeated hit";
        return result;
    }

    private void checkNumOfHits(String guess, int cell) {
        if (Integer.parseInt(guess) == cell)
            if (!hits.contains(Integer.parseInt(guess)))
                numOfHits++;
    }
}
