package model;

import java.util.List;
import java.util.Random;
import model.Player;
// import model.Game;

public class PlayerIA extends Player {
    public static final String RESET = "\u001B[0m";

    public PlayerIA(String name, char symbol, String symbolColor) {
        super(name, symbol, symbolColor);
    }

    // IA level 1 : Select random column between 1 and 7
    public static int level1() {
        Random rand = new Random();
        int column = rand.nextInt(7) + 1;
        return (column);
    }

    public static int checkNextWin(List<List<String>> board, String symbol) {
        int column = 0;
        // Check horizontal : --
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board.get(j).get(i).equals(symbol)
                        && board.get(j + 1).get(i).equals(symbol)
                        && board.get(j + 2).get(i).equals(symbol)
                        && board.get(j + 3).get(i).equals(" ")) {
                    column = j + 3;
                } else if (board.get(j).get(i).equals(symbol)
                        && board.get(j + 1).get(i).equals(symbol)
                        && board.get(j + 2).get(i).equals(" ")
                        && board.get(j + 3).get(i).equals(symbol)) {
                    column = j + 2;
                } else if (board.get(j).get(i).equals(symbol)
                        && board.get(j + 1).get(i).equals(" ")
                        && board.get(j + 2).get(i).equals(symbol)
                        && board.get(j + 3).get(i).equals(symbol)) {
                    column = j + 1;
                } else if (board.get(j).get(i).equals(" ")
                        && board.get(j + 1).get(i).equals(symbol)
                        && board.get(j + 2).get(i).equals(symbol)
                        && board.get(j + 3).get(i).equals(symbol)) {
                    column = j;
                }
            }
        }
        System.out.println("===========FUNCTION COLUMN = " + column + "============");
        System.out.println(board);
        return column;
    }

    // IA level 2 : Select random column between 1 and 7 and check if player can
    // win, if player can win, block him else select random column
    public static int level2(List<List<String>> board, Player player) {

        int column = 0;
        String playerSymbol = player.getSymbolColor() + player.getSymbol() + RESET;

        // System.out.println("Player symbol = " + playerSymbol);
        // System.out.println("=================LEVEL 2=====================");
        if (checkNextWin(board, playerSymbol) == 0) {
            column = level1();
            // column = 6;
        } else {
            // System.out.println("============ ELSE ELSE ELSE ============");
            column = checkNextWin(board, playerSymbol);
            // System.out.println("################# ELSE ELSE #### column = " + column);
        }
        return column;
    }
}