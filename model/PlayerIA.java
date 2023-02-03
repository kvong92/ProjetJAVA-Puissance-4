package model;

import java.util.Random;

public class PlayerIA extends Player {

    public PlayerIA(String name, char symbol, String symbolColor, int score) {
        super(name, symbol, symbolColor, score);
    }

    public static int level1() {
        Random rand = new Random();
        int column = rand.nextInt(7) + 1;
        return (column);
    }
}
