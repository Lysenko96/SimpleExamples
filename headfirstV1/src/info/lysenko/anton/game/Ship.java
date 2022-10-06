package info.lysenko.anton.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ship {

    private List<String> locationCells;
    private int numOfHits;
    private String name;
    // no setter for final
    private final Set<String> hits = new HashSet<>();

    public Ship() {
    }

    public Ship(String name) {
        this.name = name;
    }

    public String checkYourself(String guess, List<String> locationCells) {
        String result = "no hit";
        for (String cell : locationCells) {
            if (guess.equals(cell)) {
                checkNumOfHits(guess, cell);
                result = checkHitsResult(guess);
                hits.add(guess);
                System.out.println(hits);
                break;
            }
        }
        return result;
    }

    public void setLocationCells(List<String> locationCells) {
        this.locationCells = locationCells;
    }

    public List<String> getLocationCells() {
        return locationCells;
    }

    public int getNumOfHits() {
        return numOfHits;
    }

    private String checkHitsResult(String guess) {
        String result = "hit";
        if (numOfHits == locationCells.size())
            result = "destroy";
        else if (hits.contains(guess))
            result = "repeated hit";
        return result;
    }

    private void checkNumOfHits(String guess, String cell) {
        if (guess.equals(cell)) {
            if (!hits.contains(guess))
                numOfHits++;
        }
    }
}
