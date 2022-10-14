package info.lysenko.anton.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private int numOfGuesses;
    private final List<Ship> ships = new ArrayList<>();
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = gridLength * gridLength;
    private int[] grid = new int[gridSize];
    private int shipCount;

    public void startGame() {
        Ship ship = new Ship("ship");
        Ship ship2 = new Ship("ship2");
        Ship ship3 = new Ship("ship3");
        ships.add(ship);
        ships.add(ship2);
        ships.add(ship3);
        gameMenu(ships);
        System.out.println(numOfGuesses);
    }

    public List<String> generateGameField(int size){
        List<String> alphaCells = new ArrayList<>();
        String[] alphacoords = new String[size];
        String temp = null;
        int[] coords = new int[size];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        shipCount++;

        int incr = 1;
        if((shipCount % 2) == 1){
            incr = gridLength;
        }

        while (!success && attempts++ < 200){
            location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            while (success && x < ships.size()){
                if(grid[location] == 0){
                    coords[x++] = location;
                    location += incr;
                    if(location>= gridSize){
                        success = false;
                    }
                    if(x > 0 && (location % gridLength == 0)){
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;
        while (x < ships.size()) {
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }

    private void gameMenu(List<Ship> ships) {
        Scanner in = new Scanner(System.in);
        for (Ship ship : ships) {

            List<String> location = generateGameField(3);
            ship.setLocationCells(location);

            do {
                System.out.print("enter cell: ");
                System.out.println(ship.checkYourself(in.next().toLowerCase(), location));
                numOfGuesses++;
            } while (ship.getNumOfHits() != ship.getLocationCells().size());
        }
    }
}
