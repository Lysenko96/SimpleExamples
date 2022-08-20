package info.lysenko.anton.game;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private int numOfGuesses;

    public void startGame() {
        Ship ship = new Ship();
        int startCell = new Random().nextInt(3) + 2;
        ship.setLocationCells(buildShip(startCell, 3));
        gameMenu(ship);
        System.out.println("numOfGuesses: " + numOfGuesses);
    }

    private int[] buildShip(int startCell, int size) {
        int[] cells = new int[size];
        for (int i = 0; i < cells.length; i++)
            cells[i] = startCell++;

        return cells;
    }

    private void gameMenu(Ship ship) {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("enter cell: ");
            System.out.println(ship.checkYourself(in.next()));
            numOfGuesses++;
        } while (ship.getNumOfHits() != ship.getLocationCells().length);
    }
}
